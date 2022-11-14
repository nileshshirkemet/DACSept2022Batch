readonly record struct ItemInfo(double Price, int Stock)
{
    public static ItemInfo Parse(string source)
    {
        string[] parts = source.Split(',');
        double p = double.Parse(parts[0].Substring(6));
        int s = int.Parse(parts[1].Substring(6));
        return new ItemInfo(p, s);
    }
}
