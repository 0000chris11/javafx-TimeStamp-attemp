package com.cofii.timestamp.login;

import java.io.File;

import com.cofii.timestamp.data.DATA;
import com.cofii.timestamp.data.SQL;
import com.cofii.timestamp.first.VF;
import com.cofii.timestamp.login.querys.SelectDatabases;
import com.cofii.timestamp.login.querys.SelectUsers;
import com.cofii2.methods.MList;
import com.cofii2.mysql.RootConfigConnection;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class VL extends Application{

    private VLData dt = VLData.getInstance();
    private boolean userOK = true;
    private boolean passwordOK = false;
    private boolean dbOK = true;

    private void querys(){
        MSQLP ms = new MSQLP(new RootConfigConnection());
        ms.selectUsers(new SelectUsers());
        ms.selectDatabases(new SelectDatabases());

        ms.close();        
    }

    private void keyListeners(){
        //USER
        dt.getCbUser().getEditor().setOnKeyReleased(e -> {
            String text = dt.getCbUser().getEditor().getText();
            if(MList.isOnThisArray(dt.getCbUser().getItems().toArray(), text)){
                dt.getLbUser().setTextFill(Color.WHITE);
                userOK = true;
            }else{
                dt.getLbUser().setTextFill(Color.RED);
                userOK = false;
            }

            buttonLoggingControl();
        });
        
        dt.getCbUser().getSelectionModel().selectedItemProperty().addListener(e -> {
            dt.getLbUser().setTextFill(Color.WHITE);
            userOK = true;

            buttonLoggingControl();
        });
        
        //PASSWORD
        dt.getTfPass().setOnKeyReleased(e -> {
            String lbText = dt.getLbPassword().getText();
            if(!lbText.equals("Password")){
                dt.getLbPassword().setText("Password");
            }

            if(!dt.getTfPass().getText().isEmpty()){
                dt.getLbPassword().setTextFill(Color.WHITE);
                passwordOK = true;
            }else{
                dt.getLbPassword().setTextFill(Color.RED);
                passwordOK = false;
            }

            buttonLoggingControl();
        });
        //DB
        dt.getCbDB().getEditor().setOnKeyReleased(e -> {
            String text = dt.getCbDB().getEditor().getText();
            if(MList.isOnThisArray(dt.getCbDB().getItems().toArray(), text)){
                dt.getLbDB().setTextFill(Color.WHITE);
                dbOK = true;
            }else{
                dt.getLbDB().setTextFill(Color.RED);
                dbOK = false;
            }

            buttonLoggingControl();
        });

        dt.getCbDB().getSelectionModel().selectedItemProperty().addListener(e -> {
            dt.getLbDB().setTextFill(Color.WHITE);
            dbOK = true;

            buttonLoggingControl();
        });
    }

    private void buttonLoggingControl(){
        if(userOK && passwordOK && dbOK){
            dt.getButtonLog().setDisable(false);
        }else{
            dt.getButtonLog().setDisable(true);
        }
    }

    private void loging(){
        dt.getButtonLog().setOnAction(e -> {
            String user = dt.getCbUser().getEditor().getText();
            String password = dt.getTfPass().getText();
            String database = dt.getCbDB().getEditor().getText();

            SQL.setCurrentURL(user, password, database);
            new VF();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        dt.setWindow(primaryStage);
        dt.getWindow().setTitle("Login");

        dt.getLbUser().setTextFill(Color.WHITE);
        dt.getLbPassword().setTextFill(Color.RED);
        dt.getLbDB().setTextFill(Color.WHITE);
        /*
        dt.getCkRemember().setTextFill(Color.WHITE);
        dt.getCbUser().getEditor().setBackground(DATA.BG_COLOR_COMP);
        dt.getTfPass().setBackground(DATA.BG_COLOR_COMP);
        dt.getCbDB().getEditor().setBackground(DATA.BG_COLOR_COMP);
        */
        dt.getCbUser().setEditable(true);
        dt.getCbDB().setEditable(true);        

        Region spaceV = new Region();
        VBox.setVgrow(spaceV, Priority.ALWAYS);
        dt.getCbUser().setPrefWidth(Short.MAX_VALUE);
        dt.getTfPass().setPrefWidth(Short.MAX_VALUE);
        dt.getCbDB().setPrefWidth(Short.MAX_VALUE);

        Region spaceH = new Region();
        HBox.setHgrow(spaceH, Priority.ALWAYS);

        //BOTTOM
        HBox layoutBottom = new HBox(10);
        layoutBottom.setPadding(new Insets(8, 4, 4, 4));
        layoutBottom.getChildren().addAll(dt.getButtonLog(), spaceH, dt.getCkRemember());
        //TOP
        VBox layoutTop = new VBox(10);
        layoutTop.setPadding(new Insets(14, 14, 14, 14));
        layoutTop.getChildren().addAll(dt.getLbUser(), dt.getCbUser(), dt.getLbPassword(), dt.getTfPass(), dt.getLbDB(), dt.getCbDB(), spaceV, layoutBottom);
        Scene scene = new Scene(layoutTop, 400, 300);

        querys();

        dt.getCbUser().getSelectionModel().select(0);
        //dt.getCbUser().getEditor().setText(dt.getCbUser().getSelectionModel().getSelectedItem());
        dt.getCbDB().getSelectionModel().select(0);
        //dt.getCbDB().getEditor().setText(dt.getCbDB().getSelectionModel().getSelectedItem());

        buttonLoggingControl();

        keyListeners();
        loging();

        scene.getStylesheets().add((new File("src/resources/Main.css")).toURI().toString());
        dt.getWindow().setScene(scene);
        dt.getWindow().show();
    }

    
}
