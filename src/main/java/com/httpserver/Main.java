package com.httpserver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Connection con = new Connection();
        System.out.println("Enter port to open it for connections");
        Scanner sc = new Scanner(System.in);
        int port = sc.nextInt();
        con.openConnection(port);
        while(true){
            con.acceptConnection();
            con.readConnection();
            con.returnData();
            con.closeConnection();
            con.client.close();
        }
    }
}