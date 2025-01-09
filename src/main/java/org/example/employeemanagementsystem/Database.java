package org.example.employeemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/employee";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

   public Connection connectDB()  {
     try {
         Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         System.out.println("Connected to the PostgreSQL server successfully.");
         return  conn;
     }
     catch (Exception e){
         e.printStackTrace();
     }
       return null;
   }

}

