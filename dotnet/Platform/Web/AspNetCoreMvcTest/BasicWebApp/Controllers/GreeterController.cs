namespace BasicWebApp.Controllers;

public class GreeterController : Controller
{
    public IActionResult Greet(string id, [FromServices] Services.ICounter counter)
    {
        ViewBag.GuestName = id ?? "Visitor";
        int count = counter.CountNext(id);
        if((count % 2) == 1)
            return View("Welcome"); //renders /Views/Greeter/Welcome.cshtml
        return View("Hello");
    }
}