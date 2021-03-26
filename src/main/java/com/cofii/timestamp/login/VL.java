package com.cofii.timestamp.login;

import com.cofii.timestamp.login.querys.SelectUsers;
import com.cofii2.mysql.DefaultConnection;
import com.cofii2.mysql.MSQLP;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class VL extends Application{

    private Stage window;

    private Label lbUser = new Label("User");
    private Label lbPassword = new Label("Password");
    private Label lbDB = new Label("Database");

    private ComboBox<String> cbUser = new ComboBox<>();
    private TextField tfPass = new TextField();
    private ComboBox<String> cbDB = new ComboBox<>();

    private Button buttonLog = new Button("Login");
    private CheckBox ckRemember = new CheckBox("Remember logging");

    private void querys(){
        MSQLP ms = new MSQLP(new DefaultConnection());
        ms.selectUsers(new SelectUsers());
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Login");

        cbUser.setEditable(true);
        cbDB.setEditable(true);

        Region spaceV = new Region();
        VBox.setVgrow(spaceV, Priority.ALWAYS);
        cbUser.setPrefWidth(Short.MAX_VALUE);
        tfPass.setPrefWidth(Short.MAX_VALUE);
        cbDB.setPrefWidth(Short.MAX_VALUE);

        Region spaceH = new Region();
        HBox.setHgrow(spaceH, Priority.ALWAYS);

        //BOTTOM
        HBox layoutBottom = new HBox(10);
        layoutBottom.setPadding(new Insets(8, 4, 4, 4));
        layoutBottom.getChildren().addAll(buttonLog, spaceH, ckRemember);
        //TOP
        VBox layoutTop = new VBox(10);
        layoutTop.setPadding(new Insets(14, 14, 14, 14));
        layoutTop.getChildren().addAll(lbUser, cbUser, lbPassword, tfPass, lbDB, cbDB, spaceV, layoutBottom);
        Scene scene = new Scene(layoutTop, 400, 300);

        window.setScene(scene);
        window.show();
    }

    
}
