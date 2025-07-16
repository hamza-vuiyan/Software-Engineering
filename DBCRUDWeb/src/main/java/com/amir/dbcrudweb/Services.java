package com.amir.dbcrudweb;

import java.sql.*;
import java.util.ArrayList;

public class Services {
    static String insertQuery = "insert into studentWeb (id, name, email) values (?, ?, ?)";
    static String deleteQuery = "delete from studentWeb where id = ?";
    static String viewQuery = "select *from studentWeb";
    static String updateQuery = "update studentWeb set name = ? ,email = ? where id = ?";

//    static String updateQuery = "update studentWeb set name = ? ,email = ? where id = ?";


    public static String insertData(String id, String name, String email) {
           if(id == null || id.trim().equals("")){
                return "ID cannot be null or empty.";
            }
            if(name == null || name.trim().equals("")){
                return "Name cannot be null or empty.";
            }
            if(email == null || email.trim().equals("")){
                return "Email cannot be null or empty.";
            }
            if(!email.contains("@")){
                return "Invalid email format.";
           }


            try (Connection connection = DBConnection.getConnection();
                 PreparedStatement ps = connection.prepareStatement(insertQuery)) {
                 ps.setString(1, id);
                 ps.setString(2, name);
                 ps.setString(3, email);

                 int result = ps.executeUpdate();
                 if (result > 0) {
                     return "Data inserted successfully!";
                 } else {
                     return  "Failed to insert data.";
                 }
            } catch (SQLException | NullPointerException e) {
                System.out.println("Error inserting data: " + e.getMessage());
            }
        return "Error occurred while inserting data.";
    }

    // Method to delete data from the database
    public static String deleteData(String id){
            if(id == null || id.trim().equals("") || id.isEmpty()){
                return "ID cannot be null or empty.";
            }

            try(Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(deleteQuery)) {
                ps.setString(1, id);
                int result = ps.executeUpdate();

                if (result > 0) {
                    return  "Data deleted successfully!";
                } else {
                    return "Failed to delete data.";
                }
            }catch (SQLException e){
                System.out.println("Error deleting data: " + e.getMessage());
            }
        return "Error occurred while deleting data.";
    }


    // Method to view all students in the database
    public static ArrayList<ModelView> viewAll (){
        ArrayList<ModelView> students = new ArrayList<>();

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(viewQuery)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelView obj = new ModelView(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                students.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
        return students;


    }

    // Method to update a student's name by ID
    public static String updateQuery(String  id, String newName, String newEmail) {
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(updateQuery)) {
            ps.setString(1, newName);
            ps.setString(2, newEmail);
            ps.setString(3, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                return  "Data updated successfully!";
            } else {
                return  "Failed to insert data.";
            }
        }catch (SQLException e) {
            System.out.println("Error updating data: " + e.getMessage());
        }
        return  "Error occurred while updating data.";
    }
}
