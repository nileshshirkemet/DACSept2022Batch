class Program {

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int y = Integer.parseInt(args[1]);
		Investment inv = new Investment(p, y);
		System.out.printf("Future value of safe investment: %.2f%n", inv.futureValue());
		inv.allowRisk(true);
		System.out.printf("Future value of risky investment: %.2f%n", inv.futureValue());
	}
}

