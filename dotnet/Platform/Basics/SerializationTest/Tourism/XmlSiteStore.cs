using System.Xml;
using System.Xml.Serialization;

namespace Tourism;

public class XmlSiteStore : ISiteStore
{
    public bool Save(Site info)
    {
        var serializer = new XmlSerializer(typeof(Site));
        try
        {
            using var writer = XmlWriter.Create(info.Id + ".xml", new XmlWriterSettings { Indent = true });
            serializer.Serialize(writer, info);
            return true;
        }
        catch
        {
            return false;
        }
    }

    public Site Load(string name)
    {
        var serializer = new XmlSerializer(typeof(Site));
        try
        {
            using var reader = XmlReader.Create(name + ".xml");
            return (Site)serializer.Deserialize(reader)!;
        }
        catch
        {
            return new Site { Id = name };
        }
    }
}