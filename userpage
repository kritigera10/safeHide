package views;

import dao.DataDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.Data;

public class UserView {
   private String email;

   UserView(String email) {
      this.email = email;
   }

   public void home() {
      label68:
      while(true) {
         System.out.println("Welcome " + this.email);
         System.out.println("Press 1 to show hidden files");
         System.out.println("Press 2 to hide a new file");
         System.out.println("Press 3 to unhide a file");
         System.out.println("Press 0 to exit");
         Scanner sc = new Scanner(System.in);
         int ch = Integer.parseInt(sc.nextLine());
         List files;
         Iterator var4;
         Data file;
         PrintStream var10000;
         int var10001;
         switch(ch) {
         case 0:
            System.exit(0);
            break;
         case 1:
            try {
               files = DataDAO.getAllFiles(this.email);
               System.out.println("ID - File Name");
               var4 = files.iterator();

               while(true) {
                  if (!var4.hasNext()) {
                     continue label68;
                  }

                  file = (Data)var4.next();
                  var10000 = System.out;
                  var10001 = file.getId();
                  var10000.println(var10001 + " - " + file.getFileName());
               }
            } catch (SQLException var10) {
               var10.printStackTrace();
               break;
            }
         case 2:
            System.out.println("Enter the file path");
            String path = sc.nextLine();
            File f = new File(path);
            file = new Data(0, f.getName(), path, this.email);

            try {
               DataDAO.hideFile(file);
            } catch (SQLException var8) {
               var8.printStackTrace();
            } catch (IOException var9) {
               var9.printStackTrace();
            }
            break;
         case 3:
            files = null;

            try {
               files = DataDAO.getAllFiles(this.email);
               System.out.println("ID - File Name");
               var4 = files.iterator();

               while(var4.hasNext()) {
                  file = (Data)var4.next();
                  var10000 = System.out;
                  var10001 = file.getId();
                  var10000.println(var10001 + " - " + file.getFileName());
               }

               System.out.println("Enter the id of file to unhide");
               int id = Integer.parseInt(sc.nextLine());
               boolean isValidID = false;
               Iterator var6 = files.iterator();

               while(var6.hasNext()) {
                  Data file = (Data)var6.next();
                  if (file.getId() == id) {
                     isValidID = true;
                     break;
                  }
               }

               if (isValidID) {
                  DataDAO.unhide(id);
               } else {
                  System.out.println("Wrong ID");
               }
            } catch (SQLException var11) {
               var11.printStackTrace();
            } catch (IOException var12) {
               var12.printStackTrace();
            }
         }
      }
   }
}
