record Item(String name, String brand, int stock){}

record Customer(String id, double purchase, int rating) implements Comparable<Customer> {
	
	public int compareTo(Customer that) {
		return -id.compareTo(that.id);
	}
}

class Shop {

	public String name = "CitiTek";

	public long phone = 9876543210L;
}

