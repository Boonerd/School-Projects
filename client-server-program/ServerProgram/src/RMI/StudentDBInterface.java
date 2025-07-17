/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author HP
 */
public interface StudentDBInterface extends Remote {
    void insert(String studentData) throws RemoteException;
    void update(String studentData) throws RemoteException;
    void delete(int studentId) throws RemoteException;
    void select(int studentId) throws RemoteException;
    
}
