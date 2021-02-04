package live_study_12;

import java.util.function.Function;

public class MainRunner {

    @SuppressWarnings(value = "all")
    public static void main(String[] args) {
        User user = InstanceService.getObject(User.class);
        System.out.println(user);
    }
}
