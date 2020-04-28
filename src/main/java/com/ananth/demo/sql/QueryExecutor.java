package com.ananth.demo.sql;
import java.sql.*;
public class QueryExecutor{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo","root","rootpassword");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    private static Statement createStatement() throws Exception     {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/demo","root","rootpassword");
        Statement stmt=con.createStatement();
        return stmt;
    }

    public static ResultSet execReads(String sqlQuery) throws Exception {
        Statement stmt = createStatement();
        ResultSet rs=stmt.executeQuery(sqlQuery);
        stmt.getConnection().close();
        return rs;
    }

    public static int execWrites(String sqlQuery) throws Exception {
        Statement stmt = createStatement();
        int count =  stmt.executeUpdate(sqlQuery);
        stmt.getConnection().close();
        return count;
    }
}

