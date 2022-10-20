import java.util.stream.IntStream;

class Program {

	public static void main(String[] args) throws Exception {
		int limit = Integer.parseInt(args[0]);
		System.out.print("Computing...");
		var c = new Computation();
		var t1 = System.nanoTime();
		var r = c.compute(1, limit);
		var t2 = System.nanoTime();
		System.out.println("Done!");
		System.out.printf("Result = %d, computed in %.3f seconds.%n", r, (t2 - t1) / 1e9);
	}

	static class Computation {

		public long compute(int first, int last) {
			return IntStream.range(first, last + 1)
					.mapToLong(Worker::doWork)
					.sum();
		}
	}
}

