import java.util.*;

class Program {

	static class IntervalComparison implements Comparator<Interval> {
		
		public int compare(Interval x, Interval y) {
			return x.seconds() - y.seconds();
		}
	}

	public static void main(String[] args) {
		//Set<Interval> store = new HashSet<>();
		//Set<Interval> store = new TreeSet<>();
		Set<Interval> store = new TreeSet<>(new IntervalComparison());
		store.add(new Interval(5, 31));
		store.add(new Interval(7, 52));
		store.add(new Interval(8, 23));
		store.add(new Interval(6, 14));
		store.add(new Interval(3, 45));
		store.add(new Interval(4, 91));
		for(Interval item : store)
			System.out.println(item);
	}
}

