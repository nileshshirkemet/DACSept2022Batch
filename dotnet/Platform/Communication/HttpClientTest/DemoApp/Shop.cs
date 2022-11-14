using System.Xml.Linq;

class Shop
{
    private XElement root;

    private Shop(string doc)
    {
        root = XElement.Load(doc);
    }

    public static Shop Open(string doc)
    {
        return new Shop(doc);
    }

    public string GetItemInfo(string name)
    {
        return root.Elements("item")
                .Where(e => (string)e.Attribute("key") == name)
                .Select(e => e.Value)
                .FirstOrDefault();
    }
}