package com.ananth.demo;
import java.sql.*;
import java.util.List;

public class QueryExecutor {

    private static Connection connection;

    public static Connection getDBConnection() {
        try {
            if (connection == null) connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "root", "");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }

    public static void closeDBConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Statement createStatement() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("JDBC connection failed because of missing driver.!");
        }
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo","root", "");
        Statement stmt = con.createStatement();
        return stmt;
    }

    public static ResultSet execReads(String sqlQuery) throws SQLException {
        Statement stmt = createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);
        return rs;
    }

    public static int execWrites(String sqlQuery) throws SQLException {
        Statement stmt = createStatement();
        int count =  stmt.executeUpdate(sqlQuery);
        stmt.getConnection().close();
        return count;
    }
}

