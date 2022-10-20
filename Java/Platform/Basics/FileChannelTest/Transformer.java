class Transformer {

	public static void transform(java.nio.ByteBuffer data, int count) {
		for(int i = 0, j = count - 1; i < j; ++i, --j){
			byte ib = data.get(i);
			byte jb = data.get(j);
			data.put(i, jb);
			data.put(j, ib);
		}
	}
}

