package service;

import dao.UserDAO;
import java.sql.SQLException;
import model.User;

public class UserService {
   public static Integer saveUser(User user) {
      try {
         return UserDAO.isExists(user.getEmail()) ? 0 : UserDAO.saveUser(user);
      } catch (SQLException var2) {
         var2.printStackTrace();
         return null;
      }
   }
}
