if(args[0] == "items")
{
    Item[] items = Shop.GetItems();
    items.Capitalize()
        .PrintEachWith(Console.WriteLine);
}