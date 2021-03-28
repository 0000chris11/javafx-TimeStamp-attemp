package com.cofii.timestamp.login.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cofii.timestamp.data.SQL;
import com.cofii.timestamp.login.VLData;
import com.cofii2.methods.MList;
import com.cofii2.myInterfaces.IActions;

public class SelectDatabases implements IActions{

    private VLData dt = VLData.getInstance();

    @Override
    public void beforeQuery() {
        dt.getCbDB().getItems().clear();
        
    }

    @Override
    public void setData(ResultSet rs, int row) throws SQLException {
        String db = rs.getString(1);
        if(!MList.isOnThisArray(SQL.BAND_DBS, db)){
            dt.getCbDB().getItems().add(db);
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
