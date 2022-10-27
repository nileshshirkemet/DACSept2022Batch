record ItemInfo(double price, int stock) {

	public static ItemInfo parse(String text) {
		String[] parts = text.split(",");
		double p = Double.parseDouble(parts[0].substring(6));
		int s = Integer.parseInt(parts[1].substring(6));
		return new ItemInfo(p, s);
	}

}

