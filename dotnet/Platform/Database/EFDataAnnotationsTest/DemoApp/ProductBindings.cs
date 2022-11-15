using System.ComponentModel;

namespace DemoApp;

using Shopping;

public class ProductBindings : INotifyPropertyChanged
{
    private ShopDbContext _db = new ShopDbContext();
    private Product _currentProduct;

    public event PropertyChangedEventHandler PropertyChanged;

    public IEnumerable<Product> Products => _db.Products.ToList();

    public Product CurrentProduct
    {
        get => _currentProduct;
        set
        {
            _currentProduct = value;
            _db.Entry(_currentProduct).Collection(p => p.Orders).Load();
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs("CurrentProduct"));
        }
    }
}
