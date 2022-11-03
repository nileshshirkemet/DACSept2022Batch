package shopping;

import java.rmi.*;
import java.util.*;

public interface OrderManager extends Remote {
	int placeOrder(String customerId, int productNo, int quantity) throws RemoteException;
	List<OrderEntity> fetchInvoice(String customerId) throws RemoteException;
}

