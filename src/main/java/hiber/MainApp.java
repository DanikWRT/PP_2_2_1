package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User(
//              "User1", "Lastname1", "user1@mail.ru", new Car("TOYOTA", 1)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("KIA", 2)));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("bajaj", 3)));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Jarvus", 4)));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
      User user1 = new User("usr1", "lastusr1", "example1@mail.ru");
      User user2 = new User("usr2", "lastusr2", "example2@yandex.ru");
      User user3 = new User("usr3", "lastusr3", "example3@inbox.ru");
      User user4 = new User("usr4", "lastusr4", "example4@gmail.com");

      Car car1 = new Car("KIA", 2013);
      Car car2 = new Car("bajaj", 2023);
      Car car3 = new Car("Jarvus", 1997);
      Car car4 = new Car("TOYOTA", 1995);

      userService.add(user1.setCar(car4).setUser(user1));
      userService.add(user2.setCar(car3).setUser(user2));
      userService.add(user3.setCar(car2).setUser(user3));
      userService.add(user4.setCar(car1).setUser(user4));


      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println("=================================================================");
      }

      System.out.println(userService.getUserByCar("bajaj", 2023));
      System.out.println("=================================================================");
      context.close();
   }
}
