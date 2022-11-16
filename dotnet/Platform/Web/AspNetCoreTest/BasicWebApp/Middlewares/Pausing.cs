namespace BasicWebApp.Middlewares;

public class Pausing
{
    private RequestDelegate next;
    private TimeSpan delay;
    private DateTime recent;

    public Pausing(RequestDelegate next, int interval)
    {
        this.next = next;
        delay = TimeSpan.FromSeconds(interval);
    }

    public async Task Invoke(HttpContext context)
    {
        var current = DateTime.Now;
        if(current - recent >= delay)
        {
            recent = current;
            await next.Invoke(context);
        }
        else
        {
            await context.Response.WriteAsync("Server is busy, please try after some time...");
        }
    }
}