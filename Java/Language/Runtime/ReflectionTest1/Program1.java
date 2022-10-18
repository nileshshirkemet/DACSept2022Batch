class Program {

	public static void printAsXml(Item info) {
		System.out.println("<Item>");
		System.out.printf("  <name>%s</name>%n", info.name());
		System.out.printf("  <brand>%s</brand>%n", info.brand());
		System.out.println("</Item>");
		System.out.println();
	}

	public static void printAsXml(Customer info) {
		System.out.println("<Customer>");
		System.out.printf("  <id>%s</id>%n", info.id());
		System.out.printf("  <purchase>%s</purchase>%n", info.purchase());
		System.out.printf("  <rating>%s</rating>%n", info.rating());
		System.out.println("</Customer>");
		System.out.println();
	}

	public static void main(String[] args) {
		printAsXml(new Item("cpu", "intel"));
		printAsXml(new Item("ssd", "samsung"));
		printAsXml(new Customer("Alex", 45000, 3));
	}
}

