package csms.manager;

import java.util.HashMap;
import java.util.Map;

public class MapManager {

	public Map<String, String> MakeMap(String string1, String string2, String name1, String name2) {
		Map<String, String> map = new HashMap<>();
		map.put(name1, string1);
		map.put(name2, string1);
		return map;
	}

	public Map<String, String> MakeMap(String string1, String string2, String string3, String name1, String name2,
			String name3) {
		Map<String, String> map = new HashMap<>();
		map.put(name1, string1);
		map.put(name2, string2);
		map.put(name3, string3);
		return map;
	}
	public Map<String, String> MakeMap(String string1, String string2, String string3, String string4, String name1, String name2,
			String name3, String name4) {
		Map<String, String> map = new HashMap<>();
		map.put(name1, string1);
		map.put(name2, string2);
		map.put(name3, string3);
		map.put(name4, string4);
		return map;
	}

}