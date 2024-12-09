package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car1 = new Car("Tesla", 700);
      Car car2 = new Car("BMW", 800);
      Car car3 = new Car("Audi", 900);
      Car car4 = new Car("Mercedes", 1000);

      User user1 = new User("User5", "Lastname5", "user5@mail.ru");
      user1.setCar(car1);
      userService.add(user1);

      User user2 = new User("User6", "Lastname6", "user6@mail.ru");
      user2.setCar(car2);
      userService.add(user2);

      User user3 = new User("User7", "Lastname7", "user7@mail.ru");
      user3.setCar(car3);
      userService.add(user3);

      User user4 = new User("User8", "Lastname8", "user8@mail.ru");
      user4.setCar(car4);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar().getModel() + ", " + user.getCar().getSeries());
         } else {
            System.out.println("Car = null");
         }
         System.out.println();
      }

      context.close();
   }
}
