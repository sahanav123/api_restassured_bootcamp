package apiutilities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PutStoringFields {
	
	private static final Map<String, Object> store = new ConcurrentHashMap<>();

    public static void put(String key, Object value) {
        store.put(key, value);
    }

    public static Object get(String key) {
        return store.get(key);
    }

    public static String getString(String key) {
        Object value = store.get(key);
        return value != null ? value.toString() : null;
    }

    public static Integer getInt(String key) {
        Object value = store.get(key);
        return value instanceof Integer ? (Integer) value : null;
    }

}
