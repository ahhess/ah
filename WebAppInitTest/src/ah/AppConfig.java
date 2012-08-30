package ah;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class AppConfig extends Properties {
//	public class AppConfig extends HashMap<String, String> {

	/* Here is the instance of the Singleton */
	private static AppConfig instance_;

	/* Need the following object to synchronize a block */
	private static Object syncObject_ = new Object();

	/* Prevent direct access to the constructor */
	private AppConfig() {
		super();
		System.out.println("AppConfig init");
		initFromSystemEnv();
	}

	public static AppConfig getInstance() {

		/* in a non-thread-safe version of a Singleton */
		/* the following line could be executed, and the */
		/* thread could be immediately swapped out */
		if (instance_ == null) {
			synchronized (syncObject_) {
				if (instance_ == null) {
					instance_ = new AppConfig();
				}
			}
		}
		return instance_;
	}

	public void initFromSystemEnv() {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			String val = env.get(envName);
			System.out.println("AppConfig.initFromSystemEnv: envName="
					+ envName + ":" + val);
			this.put(envName, val);
		}
	}

	public List<String> getSortedPropertiesKeys() {
//		List<String> list = new ArrayList<String>(this.keySet());
//		Collections.sort(list);
		return AppConfig.getSortedPropertiesKeys(this);
	}
	
	public static List<String> getSortedPropertiesKeys(Properties p) {
		List<String> list = new ArrayList<String>();
		for(Object obj : p.keySet()) {
			list.add(String.valueOf(obj));
		}
		Collections.sort(list); 
		return list;
	}
	
}
