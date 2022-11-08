namespace Finance;

[AttributeUsage(AttributeTargets.Method)]
public class MaxDurationAttribute : Attribute
{
    public int Limit { get; set; }

    public MaxDurationAttribute(int value = 5)
    {
        Limit = value;
    }
}