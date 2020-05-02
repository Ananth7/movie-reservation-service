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


//    public static ResultSet executeReads(String sqlQuery) throws Exception {
//        Statement statement = connection.createStatement();
//        ResultSet res = statement.executeQuery(sqlQuery);
//        statement.close();
//        return res;
//    }
//
//
//    public static int executeWrites(String sqlQuery) throws Exception {
//        Statement stmt = connection.createStatement();
//        int count =  stmt.executeUpdate(sqlQuery);
//        stmt.close();
//        return count;
//    }



    private static Statement createStatement() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo","root", "");
        Statement stmt = con.createStatement();
        return stmt;
    }

    public static ResultSet execReads(String sqlQuery) throws Exception {
        Statement stmt = createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);
        return rs;
    }

    public static int execWrites(String sqlQuery) throws Exception {
        Statement stmt = createStatement();
        int count =  stmt.executeUpdate(sqlQuery);
        stmt.getConnection().close();
        return count;
    }
}

