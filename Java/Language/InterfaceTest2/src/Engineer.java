package taxation;

public class Engineer implements TaxPayer {

	private int projects;

	public Engineer(int count) {
		projects = count;
	}

	public double annualIncome() {
		return 500000 + 30000 * projects;
	}
}

