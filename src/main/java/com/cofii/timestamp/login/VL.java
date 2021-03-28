package com.cofii.timestamp.login;

import com.cofii.timestamp.data.DATA;
import com.cofii.timestamp.login.querys.SelectDatabases;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class VL extends Application{

    private VLData dt = VLData.getInstance();

    private void querys(){
        MSQLP ms = new MSQLP(new DefaultConnection());
        ms.selectUsers(new SelectUsers());
        ms.selectDatabases(new SelectDatabases());

        ms.close();        
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        dt.setWindow(primaryStage);
        dt.getWindow().setTitle("Login");

        dt.getLbUser().setTextFill(Color.WHITE);
        dt.getLbPassword().setTextFill(Color.WHITE);
        dt.getLbDB().setTextFill(Color.WHITE);
        dt.getCkRemember().setTextFill(Color.WHITE);
        dt.getCbUser().getEditor().setBackground(DATA.BG_COLOR_COMP);
        dt.getTfPass().setBackground(DATA.BG_COLOR_COMP);
        dt.getCbDB().getEditor().setBackground(DATA.BG_COLOR_COMP);
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
        layoutTop.setBackground(DATA.BG_COLOR);
        layoutTop.setPadding(new Insets(14, 14, 14, 14));
        layoutTop.getChildren().addAll(dt.getLbUser(), dt.getCbUser(), dt.getLbPassword(), dt.getTfPass(), dt.getLbDB(), dt.getCbDB(), spaceV, layoutBottom);
        Scene scene = new Scene(layoutTop, 400, 300);

        querys();

        dt.getWindow().setScene(scene);
        dt.getWindow().show();
    }

    
}
