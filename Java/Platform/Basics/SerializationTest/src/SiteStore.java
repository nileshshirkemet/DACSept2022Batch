package tourism;

import java.io.*;

public class SiteStore {

	public boolean save(Site info) {
		String doc = info.name + ".store";
		try(var output = new ObjectOutputStream(new FileOutputStream(doc))){
			output.writeObject(info); //object serialization
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public Site load(String name) {
		String doc = name + ".store";
		try(var input = new ObjectInputStream(new FileInputStream(doc))){
			return (Site)input.readObject(); //object deserialization
		}catch(Exception e){
			return new Site(name);
		}
	}
}

