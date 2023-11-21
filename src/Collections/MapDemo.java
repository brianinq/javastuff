package Collections;

import Collections.Comparison.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        User u1 = new User("UU1", "e.r");

        Map<String, User> map = new HashMap<>();
        map.put(u1.getEmail(), u1);
        map.put("u1.getEmail()", u1);
        System.out.println(map.get("e.r"));
        System.out.println(map.getOrDefault("unknown", new User("Unknown", "")));

        for(var key: map.keySet()){
            System.out.println(key);
        }
        for(var entry: map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println(entry);
        }
        for(var value: map.values()){
            System.out.println(value);
        }
    }
}
