static class Transformer
{
    public static void Encode(Span<byte> bytes, int count)
    {
        for(int i = 0; i < count; ++i)
            bytes[i] = (byte)(bytes[i] ^ '#');
    }
}
