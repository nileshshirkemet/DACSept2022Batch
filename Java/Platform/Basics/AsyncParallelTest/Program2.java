import java.util.stream.IntStream;
import java.util.concurrent.CompletableFuture;

class Program {

	public static void main(String[] args) throws Exception {
		int limit = Integer.parseInt(args[0]);
		System.out.print("Computing...");
		var c = new Computation();
		var t1 = System.nanoTime();
		var job = c.computeAsync(1, limit)
				   .thenAccept(r -> {
						var t2 = System.nanoTime();
						System.out.println("Done!");
						System.out.printf("Result = %d, computed in %.3f seconds.%n", r, (t2 - t1) / 1e9);
					});
		while(!job.isDone()) {
			System.out.print('.');
			Thread.sleep(500);
		}
	}

	static class Computation {

		public long compute(int first, int last) {
			return IntStream.range(first, last + 1)
					.mapToLong(Worker::doWork)
					.sum();
		}

		public CompletableFuture<Long> computeAsync(int first, int last) {
			//the supplied method is executed by a pooled thread allowing the
			//caller thread to resume its execution and obtain the result of
			//invocation at a time in future when the poooled thread has 
			//completed the execution
			return CompletableFuture.supplyAsync(() -> compute(first, last));
		}
	}
}

