package com.httpserver;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {

    ServerSocket server = new ServerSocket();
    Socket client;

    public Connection() throws IOException {
    }

    protected void openConnection(int port) throws IOException {
        server.bind(new InetSocketAddress(port));
    }

    protected void acceptConnection() throws IOException {
        client = server.accept();
    }

    protected void readConnection() throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            System.out.println(line);
        }
        System.out.println("--------------------------------------------");
    }

    protected void returnData() throws IOException {
        OutputStream os = client.getOutputStream();
        String response =
                "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Length: 11\r\n" +
                        "\r\n" +
                        "Hello World";
        os.write(response.getBytes());
        os.flush();
    }

    protected void closeConnection() throws IOException {
        client.close();
    }
}
