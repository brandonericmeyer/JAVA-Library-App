/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 8 V2
School:  Regis University
Date:  10, December 2015
Description:  Used in Authentication Service, supplies login objects for compar
-ison.
 */
package domain;

import java.io.Serializable;

public class Login implements Serializable
{
    private String username = null;
    private String password = null;

//    @Override
//    public boolean equals(Object obj)
//    {
//        if (this == obj) return true;
//
//        if ( ! (obj instanceof Login)) return false;
//
//        Login item = (Login)obj;
//
//        if (!this.credentials.equals(item.credentials)) return false;
//                
//        return true;
//    } 
    
    public void setUsername(String isbn)
    {
       this.username = username;
    }
    
    public void setPassword(String isbn)
    {
       this.password = password;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
}
