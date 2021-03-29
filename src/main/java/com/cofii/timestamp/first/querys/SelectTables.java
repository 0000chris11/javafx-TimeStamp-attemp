package com.cofii.timestamp.first.querys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cofii.timestamp.data.SQL;
import com.cofii.timestamp.first.VFData;
import com.cofii2.methods.MList;
import com.cofii2.myInterfaces.IActions;

public class SelectTables implements IActions{

    private List<String> listTables = new ArrayList<>();
    private VFData dt = VFData.getInstance();

    @Override
    public void beforeQuery() {
        // TODO Auto-generated method stub
    }

    @Override
    public void setData(ResultSet rs, int row) throws SQLException {
        listTables.add(rs.getString(1));
        
    }

    @Override
    public void afterQuery(String query, boolean rsValue) {
        if(rsValue){
            boolean tableNamesExist = MList.isOnThisList(listTables, SQL.TABLE_NAMES, true);
            dt.setTableNamesExist(tableNamesExist);
            
            boolean tableDefaultExist = MList.isOnThisList(listTables, SQL.TABLE_DEFAULT, true);
            dt.setTableDefaultExist(tableDefaultExist);

            boolean tableConfigExist = MList.isOnThisList(listTables, SQL.TABLE_CONFIG, true);
            dt.setTableConfigExist(tableConfigExist);

        }else{
            System.out.println("FATAL ERROR");
        }
        
        System.out.println("Table Names Exist: " + dt.isTableNamesExist());
        System.out.println("Table Default Exist: " + dt.isTableDefaultExist());
        System.out.println("Table Names Exist: " + dt.isTableConfigExist());
    }

    @Override
    public void exception(SQLException ex, String query) {
        ex.printStackTrace();
        
    }
    
}
