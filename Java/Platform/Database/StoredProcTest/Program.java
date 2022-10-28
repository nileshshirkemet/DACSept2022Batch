import java.sql.*;

class Program {

	public static void main(String[] args) throws Exception {
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//iitdac.met.edu/xe", "scott", "tiger");
		CallableStatement cstmt = con.prepareCall("{call place_order(?, ?, ?, ?)}");
		cstmt.setString(1, customerId);
		cstmt.setInt(2, productNo);
		cstmt.setInt(3, quantity);
		cstmt.registerOutParameter(4, Types.INTEGER);
		try{
			cstmt.execute();
			int orderNo = cstmt.getInt(4);
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			System.out.println("Order Failed!");
		}
		cstmt.close();
		con.close();
	}
}

