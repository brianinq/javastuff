package generics;

public class GenericsMain {
    public static void Main(){
        var genList = new GenericList<Integer>();
        genList.add(9);
        genList.add(90);
        System.out.println(genList.get(0));


        //compare users using comparable interface
        var user1 = new User(1);
        var user2 = new User(10);
        if(user1.compareTo(user2) < 0){
            System.out.println("User 2 is older than user1");
        }else if(user1.compareTo(user2) == 0){
            System.out.println("Users are of the same age");
        }else {
            System.out.println("User1 us older");
        }

        System.out.println(Utils.max(23, 45));
        System.out.println(Utils.max(user1, user2));

        // generic params
        Utils.printKeyValue("name", "Brian");
        Utils.printKeyValue("age", 22);
    }
}
