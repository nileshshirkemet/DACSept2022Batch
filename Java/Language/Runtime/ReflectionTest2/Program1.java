import java.lang.reflect.*;

class Program {

	public static void main(String[] args) throws Exception {
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName(args[1]);
		Method interest = c.getMethod(args[2], double.class, int.class);
		Object scheme = c.getConstructor().newInstance();
		int m = 10;
		for(int n = 1; n <= m; ++n){
			float r = (float)interest.invoke(scheme, p, n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%16.2f%n", n, emi);
		}
	}
}

