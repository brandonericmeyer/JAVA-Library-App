/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 8, V2
School:  Regis University
Date:  10, December 2015
Description:  uses the socket to get the username and password, authenticates it 
against hardcoded user username/password and sends boolean back to the client.
 */
package authenticationserver;

import java.io.*;
import java.net.Socket;
import domain.*;


public class SocketMgr implements Runnable
{
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private Socket clientSocket = null;

    public SocketMgr(Socket clientSocket) 
    {              
       this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() 
    {
        boolean evaluate = false;

        try 
        {
            //String credentials = "admin123";
                        
            //Login user1 = new Login(credentials);           
            
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            
            in = new ObjectInputStream(clientSocket.getInputStream());
            
            Login inputUser = (Login)in.readObject();
                     
            //evaluate = user1.equals(inputUser);
            
            if (inputUser.getUsername().equals("admin") && inputUser.getPassword().equals("123")) 
            {
                evaluate = true;
            }

            out.writeObject(evaluate);
                        
            in.close();
            
            out.close();

        } 
        catch (Exception e) 
        {
            System.out.println("Error - Socket Thread Failed!");      

        } 
    } 
}
