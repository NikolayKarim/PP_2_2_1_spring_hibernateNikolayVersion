package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      Car car1 = new Car("BMW", 5);
//      Car car2 = new Car("AUDI R", 8);
//      Car car3 = new Car("Doodge Chalenger", 1);
//
//      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
//      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
//      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
//
//      user1.setCar(car1);
//      user2.setCar(car2);
//      user3.setCar(car3);
//
//      userService.add(user1);
//      userService.add(user2);
//      userService.add(user3);

      System.out.println(userService.getUserByModelCar("BMW",5).toString()+"****************************");





//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
////        System.out.println(("Car model "+user.getCar().toString()));
//         System.out.println();
//      }

//      List<Car> cars = carService.listCars();
//      for (Car car : cars) {
//         System.out.println("Id = "+car.getId());
//         System.out.println("First Model = "+car.getModel());
//         System.out.println("Car Series = "+car.getSeries());
//         System.out.println();
//      }

      context.close();

   }
}
