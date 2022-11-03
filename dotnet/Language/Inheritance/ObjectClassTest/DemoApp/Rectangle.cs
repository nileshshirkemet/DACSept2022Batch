struct Rectangle
{
    public double Length;

    public double Breadth;

    public Rectangle(double l, double b)
    {
        Length = l;
        Breadth = b;
    }

    public override string ToString()
    {
        return Length + " x " + Breadth; 
    }
}