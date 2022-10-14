package taxation;

public class Programmer implements TaxPayer {

	private int lines;

	public Programmer(int count) {
		lines = count;
	}

	public double annualIncome() {
		return 300000 + 0.25 * lines;
	}

}

