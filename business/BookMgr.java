/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 4
School:  Regis University
Date:  12, November 2015
Description:  A user interface for adding a book with isbn and author list.
 */

package library.business;

import library.domain.*;
import library.services.*;

public class BookMgr 
{   
    public Book storeBook(Book book) throws Exception 
    {
      Factory factory = new Factory();
      
      IBookSvc bookSvc = (IBookSvc)factory.getService("IBookSvc");
      
      return bookSvc.storeBook(book);
   }

}

