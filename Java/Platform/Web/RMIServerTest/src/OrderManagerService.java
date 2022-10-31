package shopping;

import java.rmi.*;
import java.util.*;
import javax.persistence.*;

public class OrderManagerService extends java.rmi.server.UnicastRemoteObject implements OrderManager {

	private static final int PORT = 6000;

	public OrderManagerService() throws RemoteException {
		super(PORT); //export this object on specified TCP/IP port
	}

	public int placeOrder(String customerId, int productNo, int quantity) {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();
		try{
			var tx = em.getTransaction();
			tx.begin();
			var ctr = em.find(CounterEntity.class, "orders");
			int orderNo = ctr.getNextValue() + 1000;
			var ord = new OrderEntity();
			ord.setOrderNo(orderNo);
			ord.setOrderDate(new Date());
			ord.setCustomerId(customerId);
			ord.setProductNo(productNo);
			ord.setQuantity(quantity);
			em.persist(ord);
			tx.commit(); //tx will rollback if commit is not called
			return orderNo;
		}finally{
			em.close();
		}
	}

	public List<OrderEntity> fetchInvoice(String customerId) {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();	
		try{	
			var query = em.createQuery("SELECT e FROM OrderEntity e WHERE e.customerId=?1", OrderEntity.class);	
			query.setParameter(1, customerId);
			return query.getResultList();
		}finally{	
			em.close();
		}
	}

	public static void main(String[] args) throws Exception {
		var naming = java.rmi.registry.LocateRegistry.createRegistry(PORT);
		naming.bind("orderManager", new OrderManagerService());
	}
}

