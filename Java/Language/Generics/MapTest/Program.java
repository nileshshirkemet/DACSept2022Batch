import java.util.*;

class Program {

	public static void main(String[] args) {
		//Map<String, Interval> store = new HashMap<>();
		Map<String, Interval> store = new TreeMap<>();
		store.put("monday", new Interval(5, 31));
		store.put("tuesday", new Interval(7, 52));
		store.put("wednesday", new Interval(8, 23));
		store.put("thursday", new Interval(6, 14));
		store.put("friday", new Interval(3, 45));
		store.put("monday", new Interval(4, 31));
		if(args.length > 0) {
			String key = args[0].toLowerCase();
			Interval val = store.get(key);
			if(val != null)
				System.out.println(val);
		}else{
			for(var pair : store.entrySet())
				System.out.printf("%-12s%8s%n", pair.getKey(), pair.getValue());
		}
	}
}

