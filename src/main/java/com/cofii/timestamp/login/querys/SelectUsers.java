package com.cofii.timestamp.login.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cofii2.myInterfaces.IActions;

public class SelectUsers implements IActions{

    @Override
    public void beforeQuery() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setData(ResultSet rs, int row) throws SQLException {
        
        
    }

    @Override
    public void afterQuery(String query, boolean rsValue) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exception(SQLException ex, String query) {
        // TODO Auto-generated method stub
        
    }
    
}
