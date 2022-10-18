package finance;

public class HomeLoan {

	@MaxDuration(12)
	public float common(double amount, int period) {
		return amount < 1000000 ? 9 : 8;
	}

	public float woman(double amount, int period) {
		return common(amount, period) - 1;
	}

	public float soldier(double amount, int period) {
		return 4;
	}
}

