package micro.log.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum BrokerType {
    Admin,
    System;

    private final static Map<String, BrokerType> namesMap = new HashMap<>();
    private final static Map<BrokerType, String> reverseMap = new HashMap<>();

    static {
        namesMap.put("admin", Admin);
        reverseMap.put(Admin, "admin");
        namesMap.put("system", System);
        reverseMap.put(System, "system");
    }

    @JsonCreator
    public static BrokerType forValue(String value) {
        return namesMap.get(value);
    }

    @JsonValue
    public String toValue() {
        return reverseMap.get(this);
    }
}
