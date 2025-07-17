/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
/**
 *
 * @author HP
 */
public class DBConnection {
    // variable that will hold our connection
    public Connection con = null;
    
    public DBConnection(){
        
        // Step 1: Load Driver and Handle Exception
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded succesfully"); //success output
        }catch(ClassNotFoundException cnfe){
            // failed output
            System.out.println("Driver failed to load : " +cnfe.getMessage());
        }
        
        // Step 2: Establish connection & assign to con
        try{
            String url = "jdbc:postgresql://10.51.44.101:5432/student_database";
            String user = "postgres";
            String pass  = "postgres";
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connection successful");
        } catch (SQLException sqle) {
            System.out.println(" Database cnnection failed : "+sqle.getMessage());
        }
    }
    
    public static void main(String[] args){
        new DBConnection();
    }
    
    
}
