/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 8 V2
School:  Regis University
Date:  10, December 2015
Description:  Listens and responds to incoming requests.
 */
package authenticationserver;

import java.io.IOException;
import java.net.*;

public class ConnectionMg 
{
    private ServerSocket server = null;
    private Socket socket = null;
    
    public Socket listen() throws IOException
    {
        try 
        {
            server = new ServerSocket(8000, 100);

            socket = server.accept(); // accept the next connection request
            
            SocketMgr socketMgr = new SocketMgr(socket);
            
            Thread thread = new Thread(socketMgr); 
        
            thread.start(); 
        
            //socket.close();

        } 
        catch (Exception e) 
        {
            // log the exception
        } 
        finally 
        {
            server.close();
        } 
        
        return socket;
    }
    
    
}
