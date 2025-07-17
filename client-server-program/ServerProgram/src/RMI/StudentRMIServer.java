/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author HP
 */
public class StudentRMIServer {
    public static void main(String[] args){
        try {
            StudentDBImpl dbImpl = new StudentDBImpl();
            
            Registry registry = LocateRegistry.createRegistry(1172);
            registry.bind("StudentDB", (Remote) dbImpl);
            
            System.out.println("RMI server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
}
