class Server {

	public static void main(String[] args) throws Exception {
		var shop = Shop.open("store.xml");
		var endpoint = new java.net.InetSocketAddress(8010);
		var server = com.sun.net.httpserver.HttpServer.create(endpoint, 10);
		server.createContext("/shopping", client -> {
			String item = client.getRequestURI()
					.getPath()
					.substring(10); //remove /shopping/
			String info = shop.getItemInfo(item);
			if(info != null){
				byte[] content = info.getBytes();
				client.sendResponseHeaders(200, content.length);
				var output = client.getResponseBody();
				output.write(content);
				output.close();
			}else{
				client.sendResponseHeaders(404, -1);
			}
		});
		server.start();
	}
}

