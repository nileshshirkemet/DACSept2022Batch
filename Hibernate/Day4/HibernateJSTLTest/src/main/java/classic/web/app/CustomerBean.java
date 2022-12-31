package classic.web.app;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.met.model.Order;
import com.met.util.HibernateUtil;

public class CustomerBean implements java.io.Serializable {

	private String id;
	private String password;

	public final String getId() { return id; }
	public final void setId(String value) { id = value; }

	public final String getPassword() { return password; }
	public final void setPassword(String value) { password = value; }

	//private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	public boolean authenticate() throws SQLException {
//		try(var con = DB.connect()){
//			var pstmt = con.prepareStatement("select count(cust_id) from customers where cust_id=? and pwd=?");
//			pstmt.setString(1, id);
//			pstmt.setString(2, password);
//			var rs = pstmt.executeQuery();
//			rs.next();
//			int count = rs.getInt(1);
//			rs.close();
//			pstmt.close();
//			if(count == 1)
//				return true;
//			id = password = null;
//			return false;
//		}
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			Query<Long> createQuery = session.createQuery("select count(id) from com.met.model.Customer "
					+ "where id=:idVal and password=:pwdVal", Long.class);
			createQuery.setParameter("idVal", id);
			createQuery.setParameter("pwdVal", password);
			Long count = createQuery.getSingleResult();
			
			if(count != null && count == 1) {
				return true;
			}
			
			id = password = null;
			return false;
			
		}
		
		
		
		
		
	}

	@SuppressWarnings("deprecation")
	public List<Order> getOrders() throws SQLException {
//		var orders = new ArrayList<OrderEntry>();
//		try(var con = DB.connect()){
//			var pstmt = con.prepareStatement("select pno, qty, ord_date from orders where cust_id=?");
//			pstmt.setString(1, id);
//			var rs = pstmt.executeQuery();
//			while(rs.next())
//				orders.add(new OrderEntry(rs));
//			rs.close();
//			pstmt.close();
//		}
//		return orders;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			Criteria createCriteria = session.createCriteria(Order.class);
			createCriteria.add(Restrictions.eq("custId", id));
			
			List<Order> list = createCriteria.list();
			
			return list;
			
		}
		
		
	}


	public static class OrderEntry {
		
		private int productNo;
		private int quantity;
		private java.sql.Date orderDate;

		OrderEntry(ResultSet rs) throws SQLException {
			productNo = rs.getInt("pno");
			quantity = rs.getInt("qty");
			orderDate = rs.getDate("ord_date");
		}

		public final int getProductNo() { return productNo; }

		public final int getQuantity() { return quantity; }

		public final java.sql.Date getOrderDate() { return orderDate; }
	}
}

