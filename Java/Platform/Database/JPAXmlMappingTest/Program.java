import shopping.*;
import javax.persistence.*;

class Program {

	public static void main(String[] args) throws Exception {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();
		if(args.length == 0){
			var query = em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class);
			for(var entry : query.getResultList())
				System.out.printf("%d\t%.2f\t%d%n", entry.getProductNo(), entry.getPrice(), entry.getStock());
		}else{
			int id = Integer.parseInt(args[0]);
			ProductEntity product = em.find(ProductEntity.class, id);
			if(product != null){
				for(var entry : product.getOrders())
				System.out.printf("%s\t%d\t%tF%n", entry.getCustomerId(), entry.getQuantity(), entry.getOrderDate());
			}
		}
		em.close();
	}
}

