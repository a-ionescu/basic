package com.example.aionescu3.basic;

import android.content.Context;
import android.provider.Settings;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by AIonescu on 7/21/2017.
 */

public class Server {
    private static final int portNumber = 6000;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Server starting at port number" + portNumber);
            //Toast.makeText(this,"Server starting at port number" + portNumber,Toast.LENGTH_LONG).show();
            serverSocket = new ServerSocket(portNumber);

            //Client connecting

            System.out.println("Waiting for client");
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            //Send a message to the client
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("Message from the server");
            //Insert new line \n
            bw.newLine();
            //Send the message
            bw.flush();


            //Receive a message from client
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Message from the client: " + br.readLine());
            System.out.println("Server has ended");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
