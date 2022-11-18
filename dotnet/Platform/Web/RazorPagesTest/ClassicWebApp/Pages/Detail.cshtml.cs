using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace ClassicWebApp.Pages;

using Data;

[Authorize]
[ResponseCache(NoStore = true)]
public class DetailModel : PageModel
{
    private ShopDbContext db;

    public DetailModel(ShopDbContext db) => this.db = db;

    public Customer Current { get; set; }

    public void OnGet()
    {
        Current = db.Customers.Find(User.Identity.Name);
        db.Entry(Current).Collection(p => p.Orders).Load();
    }

    public async Task<IActionResult> OnGetLogout()
    {
        await HttpContext.SignOutAsync();
        return RedirectToPage("Index");
    }
}