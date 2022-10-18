import java.util.*;

class Program {

	public static void main(String[] args) {
		if(args[0].equals("items")){
			var items = Shop.getItems();
			Arrays.stream(items)
				.filter(i -> i.brand().equalsIgnoreCase(args[1]))
				.map(i -> i.name())
				.forEach(System.out::println);
		}else if(args[0].equals("customers")){
			double min = Double.parseDouble(args[1]);
			var customers = Shop.getCustomers();
			customers.stream()
				.filter(c -> c.purchase() >= min)
				.sorted()
				.map(c -> "*".repeat(c.rating()) + "\t" + c.id())
				.forEach(System.out::println);
		}
	}
}

