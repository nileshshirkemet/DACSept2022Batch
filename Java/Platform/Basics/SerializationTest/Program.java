import tourism.*;

class Program {
	
	public static void main(String[] args) throws Exception {
		var store = new SiteStore();
		var site = store.load("CitiZoo");
		if(args.length > 0){
			var visitor = site.getVisitor(args[0]);
			visitor.visit();
			store.save(site);
			System.out.printf("Welcome %s, your ticket number is %d%n", visitor.getId(), visitor.getTicket());
		}else{
			for(var visitor : site.getVisitors())
				System.out.printf("%s\t%d\t%s%n", visitor.getId(), visitor.getVisitCount(), visitor.getLastVisit());
		}
	}
}

