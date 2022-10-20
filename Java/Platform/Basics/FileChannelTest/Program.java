import java.nio.file.*;
import java.nio.channels.*;

class Program {
	
	public static void main(String[] args) throws Exception {
		var doc = Path.of(args[0]);
		try(var channel = FileChannel.open(doc, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
			var lock = channel.lock();
			int n = (int)channel.size();
			var buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, n);
			Transformer.transform(buffer, n);
			lock.release();
		}
	}	
}

