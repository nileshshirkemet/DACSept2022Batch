using Microsoft.AspNetCore.Razor.TagHelpers;

namespace BasicWebApp.Tags;

[HtmlTargetElement("span", Attributes = "time-display-format")]
public class ClockTagHelper : TagHelper
{
    public string TimeDisplayFormat { get; set; }

    public override void Process(TagHelperContext context, TagHelperOutput output)
    {
        string time = DateTime.Now.ToString(TimeDisplayFormat);
        output.Content.SetContent(time);
    }
}
