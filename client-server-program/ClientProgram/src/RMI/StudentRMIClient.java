/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author HP
 */
public class StudentRMIClient {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.getRegistry("10.51.44.101", 1199);
            StudentDBInterface stub = (StudentDBInterface) registry.lookup("StudentDB");
            
            String studentData = "John Doe, Computer Science";
            
            stub.select(10);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
