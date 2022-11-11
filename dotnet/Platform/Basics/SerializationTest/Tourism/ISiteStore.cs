namespace Tourism;

public interface ISiteStore
{
    bool Save(Site info);

    Site Load(string name);
    
}