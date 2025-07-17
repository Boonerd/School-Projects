/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.sql.*;


/**
 *
 * @author HP
 */
public class DBOperations {
    DBConnection db = new DBConnection();
    
    public void insert(int id, String name, String course){
        
        try{
            String query = "INSERT INTO students (student_id, student_name, student_course) VALUES (?,?,?)";

            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, course);
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }
    
    public String select(int id){
        String output = null;// variable to hold db details or error
        
        try{
            // Step 3: Create Statement
            String query = "SELECT * FROM students WHERE student_id = ?";

            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setInt(1, id);
            
            // Step 4: Execute Statement
            ResultSet rs = pst.executeQuery();
            
            // Step 5: Prcess ResultSet
            while(rs.next()){
                String sid = rs.getString("student_id");
                String sname = rs.getString("student_name");
                String scourse = rs.getString("student_course");
                
                output = sid+" "+sname+" "+scourse;
            }
            // Step 6: Close connection
            db.con.close();
                 
        }catch (SQLException sqle){
           output = sqle.getMessage();
        }
        
        return output;
    }
    
    public String update(){
        return null;
    }
    
    public String delete(){
        return null;
    }

    
    
    
}