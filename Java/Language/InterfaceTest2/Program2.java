import taxation.*;

class Program {
	
	//nested (static) member class can only reference static members
	//of its outer class
	static class Auditor implements AutoCloseable {

		public Auditor() {
			System.out.println("Acquiring resources");
		}

		public void audit(String id, TaxPayer target) {
			if(id.length() < 4)
				throw new IllegalArgumentException("Invalid ID");
			double payment = target.incomeTax() + 500;
			System.out.printf("Total Payment: %.2f%n", payment);
		}

		public void close() {
			System.out.println("Releasing resources");
		}

	}

	private static void process(String name, int count) {
		TaxPayer t = name.equals("jack") ? new Engineer(count) : new Programmer(count);
		try(Auditor a = new Auditor()){
			a.audit(name, t);
		}//compiler will attach finally block with a.close()
	}

	public static void main(String[] args) {
		try{
			String m = args[0].toLowerCase();
			int n = Integer.parseInt(args[1]);
			process(m, n);
		}catch(Exception e){
			System.out.printf("Error: %s%n", e);
		}
	}
}

