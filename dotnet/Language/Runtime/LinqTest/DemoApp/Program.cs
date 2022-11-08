
if(args[0] == "items")
{
    Item[] items = Shop.GetItems();
    items.Where(i => i.Brand == args[1])
        .Select(i => i.Name)
        .Capitalize()
        .PrintEachWith(Console.WriteLine);
}
else if(args[0] == "customers")
{
    decimal min = decimal.Parse(args[1]);
    ICollection<Customer> customers = Shop.GetCustomers();
    var selection = from c in customers
                    where c.Payment >= min
                    orderby c.Id
                    select new
                    {
                        Name = c.Id,
                        Stars = new string('*', c.Rating)
                    };
    foreach(var entry in selection)
        Console.WriteLine("{0, -12}{1, 6}", entry.Name, entry.Stars);

}