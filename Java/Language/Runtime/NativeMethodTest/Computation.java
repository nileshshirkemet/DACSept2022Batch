class Computation {

	private double first;
	private double second;

	public Computation(double a, double b) {
		first = a;
		second = b;
	}

	public native double compute(int terms);

	static {
		System.loadLibrary("computationsup");
	}
}

