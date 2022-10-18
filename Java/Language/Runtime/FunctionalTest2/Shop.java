import java.util.*;

/*
	A record is a reference type which on instantiation produces
	value-like immutable objects. Compiler translates a record type
	to a class containing final instance fields corresponding to
	record parameters along with
	(1) a parameterized constructor for initializing those fields
	(2) instance methods for getting values of those fields
	(3) overrides for toString, hashCode and equals method
*/
record Item(String name, String brand){}

record Customer(String id, double purchase, int rating) implements Comparable<Customer> {
	public int compareTo(Customer that) {
		return -id.compareTo(that.id);
	}
}

class Shop {

	public static Item[] getItems() {
		return new Item[] {
			new Item("cpu", "intel"),
			new Item("ddr", "samsung"),
			new Item("mouse", "logitech"),
			new Item("motherboard", "intel"),
			new Item("cpu", "amd"),
			new Item("ssd", "samsung"),
			new Item("keyboard", "logitech"),
			new Item("display", "samsung")
		};
	}
	
	public static Collection<Customer> getCustomers() {
		var customers = new ArrayList<Customer>();
		customers.add(new Customer("Ranjeet", 35000, 3));
		customers.add(new Customer("Vishal", 20000, 2));
		customers.add(new Customer("Abhishek", 85000, 5));
		customers.add(new Customer("Manish", 40000, 4));
		customers.add(new Customer("Saeed", 55000, 1));
		customers.add(new Customer("Nisha", 25000, 2));
		customers.add(new Customer("Ketaki", 90000, 5));
		customers.add(new Customer("Pooja", 15000, 1));
		customers.add(new Customer("Darshan", 80000, 4));
		customers.add(new Customer("Harshal", 30000, 3));
		return customers;
	}
}

