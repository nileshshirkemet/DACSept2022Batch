import java.io.*;
import java.net.*;

class Program {

	public static void main(String[] args) throws Exception {
		//Step 1
		var listener = new ServerSocket(4010);
		service(listener);
	}

	private static void service(ServerSocket listener) throws IOException {
		var shop = Shop.open("store.xml");
		for(;;) {
			//Step 2
			var client = listener.accept();
			client.setSoTimeout(20000);
			//Step 3
			var input = client.getInputStream();
			var output = client.getOutputStream();
			var reader = new BufferedReader(new InputStreamReader(input));
			var writer = new PrintWriter(new OutputStreamWriter(output), true);
			try{
				writer.println("Welcome to CitiTek");
				String item = reader.readLine();
				String info = shop.getItemInfo(item);
				if(info != null)
					writer.println(info);
			}catch(Exception e){}
			writer.close();
			reader.close();
			//Step 4
			client.close();
		}
	}
}

