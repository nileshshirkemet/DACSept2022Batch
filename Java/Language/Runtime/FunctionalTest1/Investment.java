//this class produces immutable object whose state cannot be changed
//after instantiation
class Investment {

	//final instance field can only be initialized in the constructor
	private final double payment;
	private final int years;

	public Investment(double payment, int years) {
		this.payment = payment;
		this.years = years;
	}

	public double payment() {
		return payment;
	}

	public int years() {
		return years;
	}

	public double futureValue(InterestRate interest) {
		float i = interest.forPeriod(years) / 100;
		return (payment / i) * (Math.pow(1 + i, years) - 1);
	}
}

