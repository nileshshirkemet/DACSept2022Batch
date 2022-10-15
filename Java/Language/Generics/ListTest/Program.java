import java.util.*;

class Program {

	public static void main(String[] args) {
		//List<Interval> store = new ArrayList<>();
		List<Interval> store = new LinkedList<>();
		store.add(new Interval(5, 31));
		store.add(new Interval(7, 52));
		store.add(new Interval(8, 23));
		store.add(new Interval(6, 14));
		store.add(new Interval(3, 45));
		store.add(new Interval(4, 91));
		for(Interval item : store)
			System.out.println(item);
		System.out.printf("Third Interval = %s%n", store.get(2));
	}
}

