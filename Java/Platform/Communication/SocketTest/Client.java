import java.net.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.channels.*;

class Client {

	public static void run(String text) throws Exception {
		var cs = Charset.forName("UTF-8");
		//Step 1
		var server = SocketChannel.open(StandardProtocolFamily.UNIX);
		server.connect(UnixDomainSocketAddress.of(Server.SERVICE_NAME));
		//Step 2
		server.write(cs.encode(text));
		var buffer = ByteBuffer.allocate(80);
		server.read(buffer);
		buffer.flip();
		System.out.println(cs.decode(buffer));
		//Step 3
		server.close();
	}
}

