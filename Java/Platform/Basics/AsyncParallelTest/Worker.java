class Worker {

	public static long doWork(int amount) {
		long future = System.currentTimeMillis() + 100 * amount;
		while(System.currentTimeMillis() < future);
		return amount * amount;
	}
}

