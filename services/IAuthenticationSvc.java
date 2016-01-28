/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 7
School:  Regis University
Date:  30, November 2015
Description:  Authentication service.
 */
package library.services;

import domain.*;

public interface IAuthenticationSvc extends IService
{
    public boolean authenticate(Login login);
}
