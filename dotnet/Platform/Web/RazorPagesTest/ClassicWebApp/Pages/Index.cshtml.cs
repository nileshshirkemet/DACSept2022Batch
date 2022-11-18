using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Mvc.RazorPages;
using System.Security.Claims;

namespace ClassicWebApp.Pages;

using Data;

public class IndexModel : PageModel
{
    private ShopDbContext db;

    public IndexModel(ShopDbContext db) => this.db = db;

    [BindProperty]
    public Customer Current { get; set; }

    public void OnGet()
    {
        Current = new Customer();
    }

    public async Task<IActionResult> OnPostAsync()
    {
        var customer = db.Customers.Find(Current.Id);
        if(customer?.Password == Current.Password)
        {
            var identity = new ClaimsIdentity("Cookies");
            identity.AddClaim(new Claim(ClaimTypes.Name, Current.Id));
            await HttpContext.SignInAsync(new ClaimsPrincipal(identity));
            return RedirectToPage("Detail");
        }
        ModelState.AddModelError("Current", "Invalid Customer ID or Password");
        return Page();

    }
}