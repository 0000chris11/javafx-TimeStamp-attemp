package com.cofii.main;

import com.cofii.listeners.ButtonAction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{

    private Stage window;
    private Label label = new Label("");
    private Button button = new Button();

    public static void main( String[] args ){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        stage.setTitle("Test Window for TimeStamp");
        button.setText("Press");
        button.setOnAction(new ButtonAction());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene sc = new Scene(layout, 300, 200);
        stage.setScene(sc);
        stage.show();
    }
}
