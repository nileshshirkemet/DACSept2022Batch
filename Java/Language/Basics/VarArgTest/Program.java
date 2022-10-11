class Program {

	private static double average(double first, double second, double... remaining) {
		double total = first + second;
		for(double value : remaining){
			total += value;
		}
		return total / (2 + remaining.length);
	}

	private static double averageWithDeviation(double first, double second, Deviation dev) {
		dev.value = first > second ? (first - second) / 2 : (second - first) / 2;
		return average(first, second);
	}

	public static void main(String[] args) {
		System.out.printf("Average of two values = %.3f%n", average(23.4, 28.7));
		System.out.printf("Average of three values = %.3f%n", average(23.4, 28.7, 21.6));
		System.out.printf("Average of five values = %.3f%n", average(23.4, 28.7, 21.6, 34.2, 18.9));
		if(args.length > 1) {
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			Deviation d = new Deviation();
			double a = averageWithDeviation(x, y, d);
			System.out.printf("Average of given values = %.3f with deviation = %.2f%n", a, d.value);
		}
	}
}


