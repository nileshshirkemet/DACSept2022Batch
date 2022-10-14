class Program {

	private static Object select(int index, Object first, Object second) {
		if((index % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) {
		if(args.length > 0){
			int s = Integer.parseInt(args[0]);
			String ss = (String)select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			//auto-boxing - enclosing a value of primitive type (double) 
			//within an instance of its wrapper class (java.lang.Double)
			//so that it can be passed in place of java.lang.Object
			double sd = (double)select(s, 45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);
			double sd2 = (double)select(s, "9.5", 5.9);
		}
	}
}

