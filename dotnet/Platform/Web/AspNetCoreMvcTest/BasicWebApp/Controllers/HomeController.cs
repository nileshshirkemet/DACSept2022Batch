namespace BasicWebApp.Controllers;

public class HomeController : Controller
{
    public IActionResult Index(string id = "Visitor")
    {
        return Content($"Greetings {id}");
    }
}
