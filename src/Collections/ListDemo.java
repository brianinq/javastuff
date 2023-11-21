package Collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void show() {
        List<String> items =  new ArrayList<>();
        items.add(0, "a");
        items.add(1, "po");
        System.out.println(items);
    }
}
