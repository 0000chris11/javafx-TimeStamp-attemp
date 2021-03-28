package com.cofii.timestamp.login;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VLData {
    
    private static VLData instance;

    private Stage window;

    private Label lbUser = new Label("User");
    private Label lbPassword = new Label("Password");
    private Label lbDB = new Label("Database");

    private ComboBox<String> cbUser = new ComboBox<>();
    private PasswordField tfPass = new PasswordField();
    private ComboBox<String> cbDB = new ComboBox<>();

    private Button buttonLog = new Button("Login");
    private CheckBox ckRemember = new CheckBox("Remember logging");

    private VLData(){

    }

    public static VLData getInstance(){
        if(instance == null){
            instance = new VLData();
        }
        return instance;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public Label getLbUser() {
        return lbUser;
    }

    public void setLbUser(Label lbUser) {
        this.lbUser = lbUser;
    }

    public Label getLbPassword() {
        return lbPassword;
    }

    public void setLbPassword(Label lbPassword) {
        this.lbPassword = lbPassword;
    }

    public Label getLbDB() {
        return lbDB;
    }

    public void setLbDB(Label lbDB) {
        this.lbDB = lbDB;
    }

    public ComboBox<String> getCbUser() {
        return cbUser;
    }

    public void setCbUser(ComboBox<String> cbUser) {
        this.cbUser = cbUser;
    }

    public PasswordField getTfPass() {
        return tfPass;
    }

    public void setTfPass(PasswordField tfPass) {
        this.tfPass = tfPass;
    }

    public ComboBox<String> getCbDB() {
        return cbDB;
    }

    public void setCbDB(ComboBox<String> cbDB) {
        this.cbDB = cbDB;
    }

    public Button getButtonLog() {
        return buttonLog;
    }

    public void setButtonLog(Button buttonLog) {
        this.buttonLog = buttonLog;
    }

    public CheckBox getCkRemember() {
        return ckRemember;
    }

    public void setCkRemember(CheckBox ckRemember) {
        this.ckRemember = ckRemember;
    }
}
