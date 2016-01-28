/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 5
School:  Regis University
Date:  17, November 2015
Description:  Book service implementation  for the Library application.
 */
package library.services;
import java.io.*;
import library.domain.*;

public class BookSvcSerializedIOImpl implements IBookSvc
{
    @Override
    public Book storeBook(Book book)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("somefile.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);  
            oos.writeObject(book);
            oos.flush();
        }
        catch(Exception e)
        {
              System.out.println("Error - Could not write object to OutputStream");      
        }
        return book;
   }
}
