package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsMain {
    public static void Main(){
        var list = new GenericLs<String>();
        list.add("a");
        list.add("ba");
//        var iterator = list.iterator();
//        while (iterator.hasNext()){
//            var current = iterator.next();
//            System.out.println(current);
//        }
        for (var item: list){
            System.out.println(item);
        }

        Collection<String> items = new ArrayList<String>();
        items.add("ababa");
        Collections.addAll(items, "a", "b", "c");
        System.out.println(items.size());
        System.out.println(items);
        String[] normalArray = items.toArray(new String[0]);
        //normalArray[0].toLowerCase();
        //add all
        Collection<String> otherCollection = new ArrayList<>();
        otherCollection.addAll(items);
        ListDemo.show();
    }
}
