using Tourism;

namespace BasicWebApp.Controllers;

public class TourController : Controller
{
    private ISiteStore store;

    public TourController(ISiteStore store)
    {
        this.store = store;
    }

    public IActionResult Index()
    {
        Site model = store.Load("CitiZoo");
        return View(model); //default view-name is same as the current method name
    }

    [HttpPost]
    public IActionResult Register(string person)
    {
        Site model = store.Load("CitiZoo");
        Visitor visitor = model.GetVisitor(person);
        visitor.Visit();
        store.Save(model);
        return RedirectToAction("Index");
    }
}