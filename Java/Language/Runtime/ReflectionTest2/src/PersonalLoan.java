package finance;

public class PersonalLoan {

	@MaxDuration(value = 6)
	public float common(double amount, int period) {
		return 10 + 0.5f * period;
	}

	public float employee(double amount, int period) {
		return common(amount, period) / 2;
	}
}

