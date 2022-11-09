using System.Text;
using System.Runtime.InteropServices;

unsafe class Program
{
    private static double AddSquares(double[] values)
    {
        double sum = 0;
        double* pSum = &sum; //taking address of value on stack
        //to take address of an element in an array which is on heap
        //this array must be pinned using fixed statement
        fixed(double* pItems = &values[0])
        {
            for(int i = 0; i < values.Length; ++i)
                *pSum += pItems[i] * pItems[i];
        }
        return sum;
    }

    //pseudo-attribute to insert pinvokeimpl IL modifier 
    [DllImport("encbuf", EntryPoint="encrypt_buffer")] 
    private extern static long EncryptData(byte[] bytes, int count, string key, delegate*<byte, byte, int> transform);

    private static int XorEncode(byte a, byte b)
    {
        return a ^ b;
    }

    struct LegacyBox
    {
        public fixed double Dimensions[3]; //fixed-size buffer

        public float Thickness;

        public LegacyBox(double l, double b, double h, float t)
        {
            Dimensions[0] = l;
            Dimensions[1] = b;
            Dimensions[2] = h;
            Thickness = t;
        }
    }

    [DllImport("boxvol")]
    private extern static bool BoxVolume(in LegacyBox info, out double result);

    public static void Main(string[] args)
    {
        if(args[0] == "squares")
        {
            double[] list = args.Skip(1)
                                .Select(double.Parse)
                                .ToArray();
            Console.WriteLine("Sum of Squares = {0}", AddSquares(list));
        } 
        else if(args[0] == "encrypt")
        {
            byte[] data = Encoding.UTF8.GetBytes(args[1]);
            long h = EncryptData(data, data.Length, "#", &XorEncode);
            string text = Encoding.UTF8.GetString(data);
            Console.WriteLine("Encrypted text: {0}", text);
            Console.WriteLine("Signature code: {0:X}", h);
        } 
        else if(args[0] == "box")
        {
            double a = double.Parse(args[1]);
            double b = double.Parse(args[2]);
            double c = double.Parse(args[3]);
            float d = float.Parse(args[4]);
            var box = new LegacyBox(a, b, c, d);
            if(BoxVolume(in box, out double vol))
                Console.WriteLine("Volume = {0}", vol);

        } 
    }
}