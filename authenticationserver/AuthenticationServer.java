/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 7
School:  Regis University
Date:  30, November 2015
Description:  Authentication Server application for book service.
 */
package authenticationserver;

import java.io.IOException;

public class AuthenticationServer 
{

    public static void main(String[] args) throws IOException 
    {
        ConnectionMg newConnection = new ConnectionMg();        
        
        newConnection.listen();
        
    }
    
}
