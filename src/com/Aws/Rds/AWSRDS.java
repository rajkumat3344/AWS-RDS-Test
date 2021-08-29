package com.Aws.Rds;

import java.sql.*;

//1.Import --> java.sql
//2.Load and Register the driver --> com.mysql.jdbc.Driver
//3.Create Connection --> Connection
//4.Create statement --> Statement
//5.Execute the query
//6.Process the results
//7.Close

public class AWSRDS {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://rdsdb.cvcmllrpk9ld.ap-south-1.rds.amazonaws.com:3306/AwsRdsNew";
        String userName = "admin";
        String passWord = "Radhika12";
        String query = "SELECT * FROM user";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, passWord);
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet Data = ps.executeQuery();


        //DB_Column
        while(Data.next()) {
            String CustomerName = Data.getString("username");
            String CustomerEmail = Data.getString("email");
            String CustomerPass = Data.getString("password");

            System.out.println(CustomerName+ " | "+ CustomerEmail +" | "+ CustomerPass);
        }


        ps.close();
        con.close();

    }
}
