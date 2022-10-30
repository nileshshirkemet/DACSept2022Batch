package basic.web.app;

public class GreeterBean implements java.io.Serializable {

	private String person;
	private String period;

	public final String getPerson() { return person; }
	public final void setPerson(String value) { person = value; }

	public final String getPeriod() { return period; }
	public final void setPeriod(String value) { period = value; }

	public String getGreetingMessage() {
		if(person == null)
			return "Welcome Visitor";
		return String.format("Good %s %s", period, person);
	}
}

