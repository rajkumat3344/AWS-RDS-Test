package com.Aws.Rds;

import java.sql.*;
import java.util.Scanner;

public class AWSRDSInsert {

    public static void main(String[] args) throws Exception {

        //Connection Part
        String url = "jdbc:mysql://rdsdb.cvcmllrpk9ld.ap-south-1.rds.amazonaws.com:3306/AwsRdsNew";
        String userName = "admin";
        String passWord = "Radhika12";

        //Scanner...SQL Columns...
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of customer you want to add");
        int userCount = sc.nextInt();

        //Connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, passWord);

        //SQL Statement
        PreparedStatement query = con.prepareStatement("INSERT INTO user VALUES(?, ?, ?)");


        //Iterate to add Users Data
        for (int i = 0; i < userCount; i++) {
            //username
            System.out.println("username");
            String username = sc.next();

            //email
            System.out.println("email");
            String email = sc.next();

            //password
            System.out.println("password");
            String password = sc.next();


            //Set parametere
            query.setString(1, username);
            query.setString(2, email);
            query.setString(3, password);


            //Execute the Query
            int data = query.executeUpdate();

            //Process the data
            if (data == 0) {
                System.out.println("Not Inserted");
            } else {
                System.out.println("Successfuly Inserted");
            }
        }
        query.close();
        con.close();
      }
    }

