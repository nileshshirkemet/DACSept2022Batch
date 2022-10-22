import java.io.*;
import java.net.*;

class Program {

	public static void main(String[] args) throws Exception {
		String item = args[0].toLowerCase();
		int quantity = Integer.parseInt(args[1]);
		String host = args[2];
		//Step 1
		var server = new Socket(host, 4010);
		//Step 2
		var input = server.getInputStream();
		var output = server.getOutputStream();
		var reader = new BufferedReader(new InputStreamReader(input));
		var writer = new PrintWriter(new OutputStreamWriter(output));
		System.out.println(reader.readLine());
		writer.println(item);
		writer.flush();
		String response = reader.readLine();
		if(response != null){
			var info = ItemInfo.parse(response);
			if(quantity <= info.stock())
				System.out.printf("Total Payment: %.2f%n", quantity * info.price());
			else
				System.out.println("Item out of stock!");

		}else{
			System.out.println("Item not sold!");
		}
		writer.close();
		reader.close();
		//Step 3
		server.close();
	}
}

