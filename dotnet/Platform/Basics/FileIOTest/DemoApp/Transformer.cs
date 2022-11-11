static class Transformer
{
    public static void Encode(Span<byte> bytes, int count)
    {
        for(int i = 0; i < count; ++i)
            bytes[i] = (byte)(bytes[i] ^ '#');
    }

    public static void Reverse(UnmanagedMemoryAccessor data)
    {
        for(long i = 0, j = data.Capacity - 1; i < j; ++i, --j)
        {
            byte ib = data.ReadByte(i);
            byte jb = data.ReadByte(j);
            data.Write(i, jb);
            data.Write(j, ib);
        }
    }
}
