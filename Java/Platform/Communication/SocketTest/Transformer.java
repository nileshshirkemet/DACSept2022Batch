class Transformer {

	public static void transform(byte[] data, int count) {
		for(int i = 0; i < count; ++i)
			data[i] = (byte)(data[i] ^ '#');
	}
}

