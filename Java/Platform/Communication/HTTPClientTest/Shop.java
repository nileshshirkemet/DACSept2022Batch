import java.util.Properties;

class Shop {

	private Properties store;

	private Shop(Properties store) {
		this.store = store;
	}

	public static Shop open(String doc) throws java.io.IOException {
		var items = new Properties();
		try(var input = new java.io.FileInputStream(doc)){
			items.loadFromXML(input);
		}
		return new Shop(items);
	}

	public String getItemInfo(String key) {
		return store.getProperty(key);
	}
}

