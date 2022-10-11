class Investment {

	//instance fields
	private double payment;
	private int years;
	private boolean risk;

	//constructor
	public Investment(double amount, int period) {
		payment = amount;
		years = period;
		risk = false;
	}

	//instance method must be called (using . operator) on
	//an object (referenced by 'this' argument) of the class
	//in whcih it is defined and it can refer to any member 
	//of that class
	public void allowRisk(boolean yes) {
		risk = yes;
	}

	public double futureValue() {
		float i = risk ? 0.08f : 0.06f;
		return (payment / i) * (Math.pow(1 + i, years) - 1);
	}

}

