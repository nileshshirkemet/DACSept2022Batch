using System.Text.Json;

namespace Tourism;

public class JsonSiteStore : ISiteStore
{

    public bool Save(Site info)
    {
        try
        {
            using var writer = File.OpenWrite(info.Id + ".json");
            JsonSerializer.Serialize(writer, info, new JsonSerializerOptions { WriteIndented = true });
            return true;
        }
        catch
        {
            return false;
        }
    }

    public Site Load(string name)
    {
        try
        {
            using var reader = File.OpenRead(name + ".json");
            return JsonSerializer.Deserialize<Site>(reader)!;
        }
        catch
        {
            return new Site { Id = name };
        }
    }
}