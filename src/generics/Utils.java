package generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second){
        return first.compareTo(second) > 0?first: second;
    }
    public static <K, V> void printKeyValue(K key, V value){
        System.out.println(key + "="+ value);
    }

    // using wildcards use extends when we want to read from the list
    public static void printUsers(
            GenericList<? extends User> users
    ){
        var x = users.get(0);
        System.out.println("printing users");
    }

    // using wildcards with Super class *use when you want to add to the list
    public static void printUsersQ(
            GenericList<? super User> users
    ){
        users.add(new User(67));
        System.out.println("printing users");
    }
}
