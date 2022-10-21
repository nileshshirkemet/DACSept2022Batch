package tourism;

import java.util.*;

public class Site implements java.io.Serializable {

	String name;
	private List<Visitor> visitors;

	Site(String name) {
		this.name = name;
		visitors = new ArrayList<>();
	}

	public final String getName() { return name; }

	public final List<Visitor> getVisitors() { return visitors; }

	public Visitor getVisitor(String id) {
		return visitors.stream()
				.filter(v -> v.id.equals(id))
				.findFirst()
				.orElseGet(() -> {
					Visitor v = new Visitor(id);
					visitors.add(v);
					return v;
				});
	}

	static final long serialVersionUID = 1L;
}


