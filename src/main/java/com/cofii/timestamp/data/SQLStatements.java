package com.cofii.timestamp.data;

public class SQLStatements {

    public static final String CREATE_TABLE_NAMES = "CREATE TABLE table_names(" + "id INT NOT NULL AUTO_INCREMENT, "
            + "Name CHAR(100) NOT NULL, " + "Dist CHAR(100) NOT NULL, " + "Dist2 CHAR(100) NOT NULL, "
            + "ImageC CHAR(2) NOT NULL, " + "ImageC_Path VARCHAR(500) NOT NULL, " + "Tag CHAR(100) NOT NULL, "
            + "Clock CHAR(2) NOT NULL, " + "PRIMARY KEY(id))";

    public static final String CREATE_TABLE_DEFAULT = "CREATE TABLE default_table(" + "id INT NOT NULL AUTO_INCREMENT, "
            + "Name CHAR(100) NOT NULL, " + "Dist CHAR(100) NOT NULL, " + "Dist2 CHAR(100) NOT NULL, "
            + "ImageC CHAR(2) NOT NULL, " + "ImageC_Path VARCHAR(500) NOT NULL, " + "Tag CHAR(100) NOT NULL, "
            + "Clock CHAR(2) NOT NULL, " + "FOREIGN KEY(id) REFERENCES table_names(id))";

    public static final String CREATE_TABLE_CONFIG = "CREATE TABLE table_config(" + "id INT NOT NULL, "
            + "Name CHAR(50) NOT NULL, " + "VALUE BOOLEAN NOT NULL)";

    public static String SELECT_KEYS = "SELECT " + "t.table_name, " + "t.constraint_type, " + "k.ORDINAL_POSITION, "
            + "k.column_name, " + "k.REFERENCED_TABLE_NAME, " + "k.REFERENCED_COLUMN_NAME "
            + "FROM information_schema.table_constraints t JOIN information_schema.key_column_usage k "
            + "USING(constraint_name,table_schema,table_name) "
            + "WHERE (t.constraint_type='PRIMARY KEY' OR t.constraint_type= 'FOREIGN KEY') " + "AND t.table_schema ='"
            + SQL.getDatabase() + "' ORDER BY t.table_name";

    public static String SELECT_KEYS_FROM_CURRENT = "SELECT " + "t.table_name, " + "t.constraint_type, "
            + "k.ORDINAL_POSITION, " + "k.column_name, " + "k.REFERENCED_TABLE_NAME, " + "k.REFERENCED_COLUMN_NAME "
            + "FROM information_schema.table_constraints t JOIN information_schema.key_column_usage k "
            + "USING(constraint_name,table_schema,table_name) "
            + "WHERE (t.constraint_type='PRIMARY KEY' OR t.constraint_type= 'FOREIGN KEY') " + "AND t.table_schema ='"
            + SQL.getDatabase() + "' AND t.table_name = '" + SQL.getTable() + "' ORDER BY t.table_name";

    private SQLStatements() {

    }
}
