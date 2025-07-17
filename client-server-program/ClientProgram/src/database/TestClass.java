package database;

import database.DBOperations;

public class TestClass {
    public static void main(String[] args) {
        DBOperations dbOps = new DBOperations();

        // Test INSERT
        System.out.println("Testing INSERT operation...");
        dbOps.insert("123", "John Doe", "Computer Science");

        // Test UPDATE
        System.out.println("Testing UPDATE operation...");
        dbOps.update("123", "John Smith", "Software Engineering");

        // Test DELETE
        System.out.println("Testing DELETE operation...");
        dbOps.delete("123");
    }
}
