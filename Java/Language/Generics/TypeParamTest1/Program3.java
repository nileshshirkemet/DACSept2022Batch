class Program {

	//a generic method declaration with type-parameter T
	private static <T> T select(int index, T first, T second) {
		if((index % 2) == 1)
			return first;
		return second;
	}

	//a generic method declaration with type-parameter T
	//bounded by java.lang.Comparable<T> to extend set of 
	//members supported by T with the members of java.lang.Comparable<T>
	private static <T extends Comparable<T>> T select(T first, T second){
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args) {
		if(args.length > 0){
			int s = Integer.parseInt(args[0]);
			String ss = select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			//auto-boxing - enclosing a value of primitive type (double) 
			//within an instance of its wrapper class (java.lang.Double)
			//so that it can be passed in place of java.lang.Object
			double sd = select(s, 45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);			
			//double sd2 = select(s, "9.5", 5.9);
		}else{
			String ss = select("Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);
			Interval si = select(new Interval(4, 50), new Interval(3, 45));
			System.out.printf("Selected Interval = %s%n", si);
		}
	}
}

