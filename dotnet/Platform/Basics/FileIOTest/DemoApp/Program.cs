using System.IO.MemoryMappedFiles;

if(args.Length > 1)
{
    using var input = new FileStream(args[0], FileMode.Open);
    using var output = new FileStream(args[1], FileMode.CreateNew);
    Span<byte> buffer = stackalloc byte[80]; //new byte[80];
    while(input.Position < input.Length)
    {
        int n = input.Read(buffer);
        Transformer.Encode(buffer, n);
       //output.Write(buffer.Slice(0, n));
       output.Write(buffer[0..n]);
    }
}
else
{
    var doc = new FileInfo(args[0]);
    using var mapping = MemoryMappedFile.CreateFromFile(doc.FullName);
    using var view = mapping.CreateViewAccessor(0, doc.Length);
    Transformer.Reverse(view);
}
