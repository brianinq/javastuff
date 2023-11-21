package Collections.Comparison;

public class User implements Comparable<User> {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(User o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
