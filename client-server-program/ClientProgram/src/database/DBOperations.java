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
public class DBOperations {
    DBConnection db = new DBConnection();

    // INSERT Method
    public boolean insert(String id, String name, String course) {
        try {
            String query = "INSERT INTO students (student_id, student_name, student_course) VALUES (?,?,?)";
            PreparedStatement pst = db.con.prepareStatement(query);

            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, course);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;  // Return true if the insert was successful
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;  // Return false if there was an error
        }
    }

    // SELECT Method
    public String select(String id) {
        String output = null;  // variable to hold db details or error

        try {
            String query = "SELECT * FROM students WHERE student_id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();

            // Process ResultSet
            if (rs.next()) {
                String sid = rs.getString("student_id");
                String sname = rs.getString("student_name");
                String scourse = rs.getString("student_course");

                output = sid + " " + sname + " " + scourse;
            } else {
                output = "No student found with ID: " + id;
            }
        } catch (SQLException sqle) {
            output = sqle.getMessage();
        }
        return output;
    }

    // UPDATE Method
    public boolean update(String strId, String strName, String strCourse) {
        try {
            String query = "UPDATE students SET student_name = ?, student_course = ? WHERE student_id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);

            pst.setString(1, strName);
            pst.setString(2, strCourse);
            pst.setString(3, strId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;  // Return true if the update was successful
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;  // Return false if there was an error
        }
    }

    // DELETE Method
    public boolean delete(String strId) {
        try {
            String query = "DELETE FROM students WHERE student_id = ?";
            PreparedStatement pst = db.con.prepareStatement(query);
            pst.setString(1, strId);

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;  // Return true if the delete was successful
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;  // Return false if there was an error
        }
    }
}