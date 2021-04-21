package com.cofii.timestamp.data;

import com.cofii2.mysql.RootConfigConnection;

public class SQL {
    // BAND WORDS
    public static final String[] BAND_USERS = new String[] { "mysql.infoschema", "mysql.session", "mysql.sys" };
    public static final String[] BAND_DBS = new String[] { "information_schema", "mysql", "performance_schema", "sys" };
    // DEFAULT TABLES
    public static final String TABLE_NAMES = "table_names";
    public static final String TABLE_DEFAULT = "default_table";
    public static final String TABLE_CONFIG = "table_config";

    // ARGS
    private static String url;
    private static String user;
    private static String password;
    private static String database;
    private static String table;
    
    private static boolean wrongPassword = false;

    public static void setCurrentURL(String user, String password, String database) {
        SQL.url = "jdbc:mysql://localhost:3306/" + database + RootConfigConnection.CONNECTION_PROPS;
        SQL.user = user;
        SQL.password = password;
        SQL.database = database;
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

    public static boolean isWrongPassword() {
        return wrongPassword;
    }

    public static void setWrongPassword(boolean wrongPassword) {
        SQL.wrongPassword = wrongPassword;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getTable() {
        return table;
    }

    public static void setTable(String table) {
        SQL.table = table;
    }
}
