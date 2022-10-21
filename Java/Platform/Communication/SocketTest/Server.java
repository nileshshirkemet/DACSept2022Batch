import java.net.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.channels.*;

class Server {

	public static final String SERVICE_NAME = "encrypt.sock";

	public static void run() throws Exception {
		Files.deleteIfExists(Path.of(SERVICE_NAME));
		//Step 1
		var listener = ServerSocketChannel.open(StandardProtocolFamily.UNIX);
		listener.bind(UnixDomainSocketAddress.of(SERVICE_NAME));
		for(;;){
			//Step 2
			var client = listener.accept();
			//Step 3
			var buffer = ByteBuffer.allocate(80);
			int n = client.read(buffer);
			buffer.flip();
			Transformer.transform(buffer.array(), n);
			client.write(buffer);
			//Step 4
			client.close();
		}
	}
}

