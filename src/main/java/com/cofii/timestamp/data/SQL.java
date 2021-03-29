package com.cofii.timestamp.data;

import com.cofii2.mysql.DefaultConnection;

public class SQL {
    // BAND WORDS
    public static final String[] BAND_USERS = new String[] { "mysql.infoschema", "mysql.session", "mysql.sys" };
    public static final String[] BAND_DBS = new String[] { "information_schema", "mysql", "performance_schema", "sys" };
    // DEFAULT TABLES
    public static final String TABLE_NAMES = "table_names";
    public static final String TABLE_DEFAULT = "default_table";
    public static final String TABLE_CONFIG = "table_config";

    public static final String CREATE_TABLE_NAMES = "CREATE TABLE table_names(" 
        + "id INT NOT NULL AUTO_INCREMENT, " 
        + "Name CHAR(100) NOT NULL, "
        + "Dist CHAR(100) NOT NULL, "
        + "Dist2 CHAR(100) NOT NULL, "
        + "ImageC CHAR(2) NOT NULL, "
        + "ImageC_Path VARCHAR(500) NOT NULL, "
        + "Tag CHAR(100) NOT NULL, "
        + "Clock CHAR(2) NOT NULL, "
        + "PRIMARY KEY(id))";
    // ARGS
    private static String url;
    private static String user;
    private static String password;

    public static void setCurrentURL(String user, String password, String database) {
        SQL.url = "jdbc:mysql://localhost:3306/" + database + DefaultConnection.CONNECTION_PROPS;
        SQL.user = user;
        SQL.password = password;
    }

    private SQL() {

    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
