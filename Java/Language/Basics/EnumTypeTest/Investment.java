class Investment {

	private double payment;
	private int years;
	private RiskLevel risk;

	public Investment(double amount, int period) {
		payment = amount;
		years = period;
		risk = RiskLevel.NONE;
	}

	public void allowRisk(boolean yes) {
		risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
	}

	//method overloading - defining a method in a class whose
	//name matches with another method defined in the same class
	//but has different list of parameter types
	public void allowRisk(RiskLevel level) {
		risk = level;
	}

	public double futureValue() {
		float i;
		switch(risk) {
			case HIGH:
				i = 0.11f;
				break;
			case LOW:
				i = 0.08f;
				break;
			default:
				i = 0.06f;
		}
		return (payment / i) * (Math.pow(1 + i, years) - 1);
	}

}

