class Program {

	public static void main(String[] args) throws Exception {
		if(args.length == 0)
			Server.run();
		else
			Client.run(args[0]);
	}
}

