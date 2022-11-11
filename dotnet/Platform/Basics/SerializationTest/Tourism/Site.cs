namespace Tourism;

public class Site
{
    public string? Id { get; set; }

    public List<Visitor> Visitors { get; set; } = new();

    public Visitor GetVisitor(string name)
    {
        Visitor? visitor = Visitors.Find(v => v.Id == name);
        if(visitor is null)
        {
            visitor = new Visitor { Id = name };
            Visitors.Add(visitor);
        }
        return visitor;
    }
}