/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 5
School:  Regis University
Date:  17, November 2015
Description:  A Book service interface for the Library application.
 */
package library.services;
import library.domain.*;

public interface IBookSvc extends IService
{
    public Book storeBook(Book book) throws Exception ;

}
