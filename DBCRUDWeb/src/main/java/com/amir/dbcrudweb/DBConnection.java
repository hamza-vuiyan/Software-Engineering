package com.amir.dbcrudweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url = "jdbc:mysql://urowmyrks8sa1rih:RsKRqsn19uGmkebas6WR@b3p5m8nhncgiqy1daeus-mysql.services.clever-cloud.com:3306/b3p5m8nhncgiqy1daeus";
    private static String user = "urowmyrks8sa1rih";
    private static String password = "RsKRqsn19uGmkebas6WR";

    public static Connection getConnection(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e){
                System.out.println("Error connecting to the database: " + e.getMessage());
            }

            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
            return null;
    }


}
