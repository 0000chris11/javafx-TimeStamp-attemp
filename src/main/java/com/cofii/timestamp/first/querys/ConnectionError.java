package com.cofii.timestamp.first.querys;

import java.sql.SQLException;

import com.cofii.timestamp.data.SQL;
import com.cofii.timestamp.login.VLData;
import com.cofii2.mysql.interfaces.IConnectionException;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ConnectionError implements IConnectionException{

    @Override
    public void exception(SQLException ex) {
        if (ex.getMessage().contains("password")) {
            Label lb = VLData.getInstance().getLbPassword();
            lb.setText(lb.getText() + " - Wrong Password");
            lb.setTextFill(Color.RED);

            SQL.setWrongPassword(true);
        }
        
    }

    @Override
    public void succes() {
        SQL.setWrongPassword(false);
        
    }
    
}
