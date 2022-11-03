package modern.web.app;

import shopping.*;
import java.rmi.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/orders")
public class OrderManagerAPI {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response readOrders(@PathParam("id") String customerId) {
		try{
			var remote = (OrderManager)Naming.lookup("rmi://localhost:6000/orderManager");
			var orders = remote.fetchInvoice(customerId);
			if(orders.size() == 0)
				return Response.status(404).build();
			return Response.ok(orders).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(OrderEntity info) {
		try{
			var remote = (OrderManager)Naming.lookup("rmi://localhost:6000/orderManager");
			int orderNo = remote.placeOrder(info.getCustomerId(), info.getProductNo(), info.getQuantity());
			info.setOrderNo(orderNo);
			return Response.ok(info).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
}

