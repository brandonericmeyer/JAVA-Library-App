/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 8 V2
School:  Regis University
Date: 10, December 2015
Description:  Connects to the Server passing username and password.
 */
package library.services;

import java.io.*;
import java.net.*;
import domain.*;

public class AuthenticationSvcSocketImpl implements IAuthenticationSvc 
{
    public boolean authenticate(Login login) 
    {
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        Boolean authenticateFromServer = false;
        try 
        {
            socket = new Socket(InetAddress.getLocalHost(), 8000);
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(login);
            authenticateFromServer = (Boolean)in.readObject();
        } 
        catch (Exception e) 
        {
            // log the error
            System.out.println("Exception AuthenticationSvcSocketImpl " + e.getMessage());
        } 
          
        return authenticateFromServer;
    }
    
}
