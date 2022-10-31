import shopping.*;
import java.rmi.*;

class Program {

	public static void main(String[] args) throws Exception {
		var stub = (OrderManager)Naming.lookup("rmi://localhost:6000/orderManager");
		String customerId = args[0].toUpperCase();
		if(args.length > 2){
			int productNo = Integer.parseInt(args[1]);
			int quantity = Integer.parseInt(args[2]);
			try{
				int orderNo = stub.placeOrder(customerId, productNo, quantity);
				System.out.printf("New Order Number: %d%n", orderNo);
			}catch(Exception e){
				System.out.println("Order Failed: " + e);
			}
		}else{
			var orders = stub.fetchInvoice(customerId);
			for(var entry : orders)
				System.out.printf("%d\t%d\t%tF%n", entry.getProductNo(), entry.getQuantity(), entry.getOrderDate());
		}
	}
}

