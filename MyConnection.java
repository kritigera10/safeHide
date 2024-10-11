package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
   public static Connection connection = null;

   public static Connection getConnection() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false", "root", "kriti");
      } catch (SQLException | ClassNotFoundException var1) {
         var1.printStackTrace();
      }

      System.out.println("Connection ho gya saab");
      return connection;
   }

   public static void closeConnection() {
      if (connection != null) {
         try {
            connection.close();
         } catch (SQLException var1) {
            var1.printStackTrace();
         }
      }

   }
}
