class LegacyBridge {

	public native static long gcdOfTwo(long first, long second);

	public native static long gcdOfMany(long[] all);

	static{
		System.loadLibrary("legacybridgesup");
	}
}
