package micro.log.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum LogReference {
    Chef,
    Food;

    private final static Map<String, LogReference> namesMap = new HashMap<>();
    private final static Map<LogReference, String> reverseMap = new HashMap<>();

    static {
        namesMap.put("chef", Chef);
        reverseMap.put(Chef, "chef");
        namesMap.put("food", Food);
        reverseMap.put(Food, "food");
    }

    @JsonCreator
    public static LogReference forValue(String value) {
        return namesMap.get(value);
    }

    @JsonValue
    public String toValue() {
        return reverseMap.get(this);
    }
}
