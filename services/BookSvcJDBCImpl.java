/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 6
School:  Regis University
Date:  23, November 2015
Description:  JDBC Book service implementation for the Library application.
 */
package library.services;
import library.domain.*;
import java.sql.*;

public class BookSvcJDBCImpl implements IBookSvc 
{
	private final String meyerlibrary = 
		"jdbc:mysql://localhost/meyerlibrary?user=root&password=admin";

	private Connection getConnection() throws Exception 
        {
		return DriverManager.getConnection(meyerlibrary);
	}

        @Override
	public Book storeBook(Book book) throws Exception 
        {
		Connection conn = getConnection();
                
		try 
                {
//                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO book"
//                    + " (isbn, author) VALUES (?, ?)");
//                    pstmt.setString(1, book.getIsbn());
//                    for (String s: book.getAuthorList()) 
//                    {           
//                        pstmt.setString(2, s);
//                    }
//                    pstmt.executeUpdate();
//                    pstmt.close();
                    Statement stmt = conn.createStatement();
			String sql = "INSERT INTO book (isbn, author) " + 
			  "VALUES ('" + book.getIsbn() + "', '" + book.getAuthorList() + "' )";
			stmt.executeUpdate(sql);

		} 
                catch (Exception e) 
                {
		   throw e;
		} 
                finally 
                {
		  if (conn != null) conn.close();
		}
                
                return book;
        }
}
