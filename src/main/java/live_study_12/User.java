package live_study_12;



public class User {

    @Info("kjj")
    private String name;

    @Info("seoul")
    private String local;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", local='" + local + '\'' +
                '}';
    }
}
