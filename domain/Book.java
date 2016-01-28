/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 5
School:  Regis University
Date:  17, November 2015
Description:  Modifing the week 2 Book class to accommodate multiple authors 
using one of the components from the Java Collection Framework.
 */
package library.domain;
import java.io.Serializable;
import java.util.*;


public class Book implements Serializable
{
    private ArrayList<String> authorList; // New Array to hold multiple authors.
    private String isbn;      // Holds isbn number.   
    
    public Book(String isbn, ArrayList<String> authorList)
    {
        this.isbn = isbn;
        
        this.authorList = authorList; // Add to author list array.
    }
    
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    
    public String getIsbn()
    {
        return isbn;
    }
    
    public ArrayList<String> getAuthorList()
    {
        return authorList;
    }

    public void setAuthorList(ArrayList<String> authorList)
    {
        this.authorList = authorList;
    }
    
    public boolean equals(Object obj)
    {
        if (this == obj) return true;

        if ( ! (obj instanceof Book)) return false;

        // if the passed parameter is a Book type,

        Book item = (Book)obj;

        // Otherwise, obj is cast to a Book

        if (!this.isbn.equals(item.isbn)) return false;
        
        if (!this.authorList.equals(item.authorList)) return false;
        
        return true;
    }  
        
    public boolean validate()
    {        
        if(authorList == null || authorList.equals("")) return false;
        
        if (isbn.equals("") || isbn == null) return false;
        
        return true;
    }
    
        @Override
    public String toString() 
    { 
        return isbn + " " + authorList;
    } 
}
