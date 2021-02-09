import config.AppConfing;
import java.util.List;
import models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfing.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Vova",
                "Vova", "big@net.ua"));
        userService.add(new User("Jora",
                "Jora", "Jora@net.ua"));
        userService.add(new User("Jan",
                "Jan", "Jan@net.ua"));
        userService.add(new User("X Æ A-12",
                "Musk", "musk@net.ua"));

        List<User> users = userService.listUsers();
        for (User user: users) {
            System.out.println(user.toString());
        }
    }
}
