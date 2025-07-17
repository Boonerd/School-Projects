package client;

import database.DBOperations;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class GUIOne extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create nodes
        Label titleLb = new Label("AMS Lite");
        titleLb.setFont(new Font("times new roman", 27));
        titleLb.setId("title");

        Label idLb = new Label("Enter Student Id");
        idLb.setFont(new Font("times new roman", 20));

        TextField idTf = new TextField();
        idTf.setFont(new Font("times new roman", 20));
        idTf.setAlignment(Pos.CENTER);
        idTf.setPrefWidth(480);
        idTf.getStyleClass().add("text-field");

        Label nameLb = new Label("Enter Student Name");
        nameLb.setFont(new Font("times new roman", 20));

        TextField nameTf = new TextField();
        nameTf.setFont(new Font("times new roman", 20));
        nameTf.setAlignment(Pos.CENTER);
        nameTf.setPrefWidth(480);
        nameTf.getStyleClass().add("text-field");

        Label courseLb = new Label("Enter Student Course");
        courseLb.setFont(new Font("times new roman", 20));

        TextField courseTf = new TextField();
        courseTf.setFont(new Font("times new roman", 20));
        courseTf.setAlignment(Pos.CENTER);
        courseTf.setPrefWidth(480);
        courseTf.getStyleClass().add("text-field");

        // Buttons
        Button searchBtn = new Button("SELECT");
        Button insertBtn = new Button("INSERT");
        Button updateBtn = new Button("UPDATE");
        Button deleteBtn = new Button("DELETE");

        for (Button btn : new Button[]{searchBtn, insertBtn, updateBtn, deleteBtn}) {
            btn.setFont(new Font("times new roman", 20));
            btn.setPrefWidth(480);
            btn.getStyleClass().add("button");
        }

        // SELECT
        searchBtn.setOnAction((ActionEvent event) -> {
            String strId = idTf.getText();
            String output = new DBOperations().select(strId);
            JOptionPane.showMessageDialog(null, output);
        });

        // INSERT
        insertBtn.setOnAction((ActionEvent event) -> {
            try {
                int id = Integer.parseInt(idTf.getText());
                String name = nameTf.getText();
                String course = courseTf.getText();
                boolean success = new DBOperations().insert(String.valueOf(id), name, course);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Student inserted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert student.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid ID");
            }
        });

        // UPDATE
        updateBtn.setOnAction((ActionEvent event) -> {
            String strId = idTf.getText();
            String strName = nameTf.getText();
            String strCourse = courseTf.getText();
            boolean success = new DBOperations().update(strId, strName, strCourse);
            if (success) {
                JOptionPane.showMessageDialog(null, "Student updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update student.");
            }
        });

        // DELETE
        deleteBtn.setOnAction((ActionEvent event) -> {
            String strId = idTf.getText();
            boolean success = new DBOperations().delete(strId);
            if (success) {
                JOptionPane.showMessageDialog(null, "Student deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete student.");
            }
        });

        // Layout
        VBox root = new VBox();
        root.getChildren().addAll(
                titleLb, idLb, idTf,
                nameLb, nameTf,
                courseLb, courseTf,
                searchBtn, insertBtn, updateBtn, deleteBtn
        );
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("AMS Lite - CRUD GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
    