static class Printable
{
    //a fluent function is a method which returns a type to
    //which such other functions can be applied
    public static IEnumerable<string> Capitalize<T>(this IEnumerable<T> source)
    {
        foreach(T item in source)
            yield return item.ToString().ToUpper();
    } 

    public static void PrintEachWith<T>(this IEnumerable<T> source, Action<T> write)
    {
        foreach(T item in source)
            write(item);
    }
}