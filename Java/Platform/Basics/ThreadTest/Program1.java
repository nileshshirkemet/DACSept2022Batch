class Program {
	
	private static String client;

	private static void handleJob(int id) {
		System.out.printf("Thread<%x> has accepted job<%d> for %s%n", Thread.currentThread().hashCode(), id, client);
		Worker.doWork(10 * id);
		System.out.printf("Thread<%x> has finished job<%d> for %s%n", Thread.currentThread().hashCode(), id, client);
	}

	public static void main(String[] args) {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 1;
		client = "Jack";
		handleJob(n);
		client = "Jill";
		handleJob(2);
	}
}

