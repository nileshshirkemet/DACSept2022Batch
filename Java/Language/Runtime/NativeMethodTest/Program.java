import java.util.*;

class Program {
	
	public static void main(String[] args) {
		if(args[0].equals("gcd")){
			if(args.length < 4){
				long a = Long.parseLong(args[1]);
				long b = Long.parseLong(args[2]);
				System.out.printf("G.C.D = %d%n", LegacyBridge.gcdOfTwo(a, b));
			}else{
				long[] nums = Arrays.stream(args)
								.skip(1)
								.mapToLong(Long::parseLong)
								.toArray();
				System.out.printf("G.C.D = %d%n", LegacyBridge.gcdOfMany(nums));
			}
		}else if(args[0].equals("compute")){
			double a = Double.parseDouble(args[1]);
			double b = Double.parseDouble(args[2]);
			int n = Integer.parseInt(args[3]);
			var c = new Computation(a, b);
			System.out.printf("Result = %f%n", c.compute(n));
		}
	}
}

