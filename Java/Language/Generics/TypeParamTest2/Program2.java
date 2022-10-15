class Program {

	//private static void printAnyStack(SimpleStack<? extends Object> store) {
	private static void printAnyStack(SimpleStack<?> store) {
		while(!store.empty())
			System.out.println(store.pop());
		System.out.println("----------------------");
		//store.push(12.3);
	}

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<>(); //type inference
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		//a.push(123.45);
		printAnyStack(a);
		SimpleStack<Interval> b = new SimpleStack<>();
		b.push(new Interval(5, 31));
		b.push(new Interval(7, 42));
		b.push(new Interval(6, 13));
		b.push(new Interval(4, 24));
		printAnyStack(b);
	}
}

