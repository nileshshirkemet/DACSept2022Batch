class Worker {

	public static int doWork(int amount, int balance, int action) {
		long future = System.currentTimeMillis() + amount / 1000;
		while(System.currentTimeMillis() < future);
		return balance + amount * action;
	}
}

