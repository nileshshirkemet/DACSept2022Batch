package finance;

public class CarLoan extends PersonalLoan {

	@Override
	public float common(double amount, int period) {
		return 13.5f;
	}
}

