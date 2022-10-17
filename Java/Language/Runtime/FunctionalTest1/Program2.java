
class Program {

	private static float safeScheme(int n) {
		return n < 3 ? 6 : 7;
	}

	public static void main(String[] args) {
		var input = new java.util.Scanner(System.in);
		System.out.print("Enter payment and years: ");
		double p = input.nextDouble();
		int y = input.nextInt();
		var inv = new Investment(p, y);
		//passing method-reference for InterestRate
		System.out.printf("Future value of riskless investment = %.2f%n", inv.futureValue(Program::safeScheme));
		//passing lambda-expression (anonymous method reference) for InterestRate
		System.out.printf("Future value of riskful investment  = %.2f%n", inv.futureValue(n -> 9 + 0.25f * n));
	}
}

