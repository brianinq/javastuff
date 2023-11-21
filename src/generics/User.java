package generics;

public class User implements Comparable<User> {
    private final int age;

    public User(int age){
        this.age = age;
    }

    @Override
    public int compareTo(User otherUser) {
        return age - otherUser.age;
    }
}
