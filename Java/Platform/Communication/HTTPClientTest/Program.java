import java.net.*;
import java.net.http.*;

class Program {

	public static void main(String[] args) throws Exception {
		String host = args[0];
		String item = args[1].toLowerCase();
		int quantity = Integer.parseInt(args[2]);
		URI site = new URI(String.format("http://%s:8010/shopping/%s", host, item));
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder()
						.GET()
						.uri(site)
						.build();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		if(response.statusCode() == 200){
			String content = response.body();
			var info = ItemInfo.parse(content);
			if(quantity <= info.stock())
				System.out.printf("Total Payment: %.2f%n", quantity * info.price());
			else
				System.out.println("Item out of stock!");
		}else{
			System.out.println("Item not sold!");
		}
	}

}

