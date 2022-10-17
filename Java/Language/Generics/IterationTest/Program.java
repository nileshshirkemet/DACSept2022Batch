class Program {

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<>(); 
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		for(var i = a.iterator(); i.hasNext();){
			String s = i.next();
			System.out.println(s);
		}
		System.out.println("-------------------");
		SimpleStack<Double> b = new SimpleStack<>();
		b.push(35.1);
		b.push(48.2);
		b.push(29.3);
		b.push(38.4);
		for(double d : b)
			System.out.println(d);
	}
}

