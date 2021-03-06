package com.cofii.timestamp.login.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cofii.timestamp.data.SQL;
import com.cofii.timestamp.login.VLData;
import com.cofii2.myInterfaces.IActions;

public class SelectUsers implements IActions {

    private VLData dt = VLData.getInstance();

    @Override
    public void beforeQuery() {
        dt.getCbUser().getItems().clear();
    }

    @Override
    public void setData(ResultSet rs, int row) throws SQLException {
        boolean match = true;
        String user = rs.getString(1);
        for (int a = 0; a < SQL.BAND_USERS.length; a++) {
            if (!SQL.BAND_USERS[a].equalsIgnoreCase(user)) {
                match = false;
            }else{
                match = true;
                break;
            }
        }
        if(!match){
            dt.getCbUser().getItems().add(user);
        }
    }

    

    @Override
    public void afterQuery(String query, boolean rsValue) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exception(SQLException ex, String query) {
        ex.printStackTrace();

    }

}
