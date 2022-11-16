namespace BasicWebApp.Services;

public class NamedCounter : ICounter
{
    private Dictionary<string, int> store = new();

    public int CountNext(string key)
    {
        lock(store)
        {
            store.TryGetValue(key, out int value);
            store[key] = ++value;
            return value;
        }
    }
}
