/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 8 V2
School:  Regis University
Date:  10, December 2015
Description:  LoginUI instantiates an AuthenticationMgr and invokes its boolean 
authenticate (Login login) method.  It display a successful or unsuccessful 
authentication message based on the returned boolean.
 */
package library.business;

import domain.Login;
import library.services.*;

public class AuthenticationMgr 
{
    public boolean authenticate(Login login) 
    {
       AuthenticationSvcSocketImpl user = new AuthenticationSvcSocketImpl();
       
       return user.authenticate(login);
       
//       User user = null;
//       
//       try {
//          Factory factory = new Factory();
//          IUserSvc userSvc = (IUserSvc)factory.getService("IUserSvc");
//          user =  userSvc.findUser(login.getUsername());
//       } catch (Exception e) 
//       {
//          System.out.println("Exception AuthenticationMgr " + e.getMessage());
//       }
//
//       if (user == null) return false;
//       return true;
    }
}
