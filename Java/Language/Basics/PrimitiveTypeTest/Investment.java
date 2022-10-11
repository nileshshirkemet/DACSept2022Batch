class Investment {

	//method defined with static modifier can be called on the
	//class (using . operator) in which it is defined and as such
	//it can only refer to other static members of that class
	public static double futureValue(double payment, int years) {
		float i = rateOfInterest();
		return (payment / i) * (Math.pow(1 + i, years) - 1);
	}

	//private member is only visible within current class as opposed
	//to public members which are visible in any class
	private static float rateOfInterest() {
		return 0.06f;
	}

}

