namespace Tourism;

public class Visitor
{
    public string Id { get; set; } = string.Empty;

    public int VisitCount { get; set; }

    public DateTime LastVisit { get; set; }

    public long Visit()
    {
        VisitCount += 1;
        LastVisit = DateTime.Now;
        return LastVisit.Ticks % 1000000;
    }
}