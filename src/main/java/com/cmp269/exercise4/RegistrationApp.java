package com.cmp269.exercise4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RegistrationApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        // 1) Student Name
        Label nameLabel = new Label("Student Name:");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        // 2) Course Code
        Label courseLabel = new Label("Course Code:");
        ComboBox<String> courseBox = new ComboBox<>();
        courseBox.getItems().addAll("CMP 269", "CMP 167", "CMP 168", "CIS 212");
        courseBox.setPromptText("Select a course");

        // 3) Register Button
        Button registerBtn = new Button("Register");

        // 4) Status Label (bottom)
        Label statusLabel = new Label();

        // 5) Lambda (button click behavior)
        registerBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String course = courseBox.getValue();

            if (name.isEmpty() || course == null) {
                statusLabel.setText("Please enter your name and select a course.");
            } else {
                statusLabel.setText("Registration Successful for " + name + " in " + course + "!");
            }
        });

        // Add nodes to grid (col, row)
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        grid.add(courseLabel, 0, 1);
        grid.add(courseBox, 1, 1);

        grid.add(registerBtn, 1, 2);

        // span status across 2 columns
        grid.add(statusLabel, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Lehman Course Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
