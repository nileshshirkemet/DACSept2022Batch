class Program {

	private static void printStringStack(SimpleStack<String> store) {
		while(!store.empty())
			System.out.println(store.pop());
		System.out.println("----------------------");
	}

	private static void printIntervalStack(SimpleStack<Interval> store) {
		while(!store.empty())
			System.out.println(store.pop());
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		//a.push(123.45);
		printStringStack(a);
		SimpleStack<Interval> b = new SimpleStack<Interval>();
		b.push(new Interval(5, 31));
		b.push(new Interval(7, 42));
		b.push(new Interval(6, 13));
		b.push(new Interval(4, 24));
		printIntervalStack(b);
	}
}

