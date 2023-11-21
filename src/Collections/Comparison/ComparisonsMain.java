package Collections.Comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparisonsMain {

    public static void main(String[] args) {
        List<User> customers = new ArrayList<>();
        customers.add(new User("A", "e3" ));
        customers.add(new User("C", "e1" ));
        customers.add(new User("B", "e2" ));
        System.out.println(customers);
        Collections.sort(customers);
        System.out.println(customers);
        Collections.sort(customers, new EmailComparator()); // customers.sort(collection, comparator)
        System.out.println(customers);
    }
}
