/*
Student:  Brandon Meyer
AssignName:  BookClass
Assignment:  Week 4
School:  Regis University
Date:  12, November 2015
Description:  A user interface for adding a book with isbn and author list.
 */

package library.presentation;
import library.business.*;
import library.domain.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class AddBook extends JFrame
{
    private JTextArea authorList;
    private JTextField isbnNumber;
    private JButton addButton;
    private JButton resetButton;
    private JButton exitButton;
    private JLabel bookResults;

    
    public AddBook()
    {
        super("Add Book");
        setBounds(0,0, 500, 300);
        
        // Top Panel
        JPanel topPanel = new JPanel(new FlowLayout(0)); // Will hold serenity text.
        JLabel serenityLabel = new JLabel("Add Book");
        serenityLabel.setForeground(Color.WHITE);
        serenityLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.add(serenityLabel);
        
        // Bottom Panel
        JPanel bottomPanel = new JPanel(new FlowLayout(0, 50, 10));
        bottomPanel.setBackground(Color.LIGHT_GRAY);
        addButton = new JButton("Add");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
        addButton.setPreferredSize(new Dimension(80, 20));
        resetButton.setPreferredSize(new Dimension(80, 20));
        exitButton.setPreferredSize(new Dimension(80, 20));
        bottomPanel.add(addButton);
        bottomPanel.add(resetButton);
        bottomPanel.add(exitButton);
        
        // Center Panel
        JPanel textPanel = new JPanel(new FlowLayout(0, 100, 10));
        JLabel isbnLabel = new JLabel("ISBN: ");
        isbnNumber = new JTextField();
        isbnNumber.setText("Enter ISBN Number Here...");
        isbnNumber.setPreferredSize(new Dimension(200, 30));
        authorList = new JTextArea();
        authorList.setPreferredSize(new Dimension(200, 80));
        authorList.setLineWrap(true);
        authorList.setEditable(true);
        bookResults = new JLabel("Enter author(s) below: ");
        textPanel.add(isbnLabel);
        textPanel.add(isbnNumber);
        textPanel.add(authorList);
        textPanel.add(bookResults);
        
        // Scroll panes
        JScrollPane outputPane = new JScrollPane(authorList);
        textPanel.add(outputPane);
        
        // Panel placement
        add(topPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Mouse Action Listeners
        isbnNumber.addMouseListener(new MouseHandler());
        
        // Individual Listeners
        addButton.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent ex)
        {
            try 
            {
                ArrayList<String> newAuthorList = new ArrayList<>();
                
                newAuthorList.add(authorList.getText());

                Book book = new Book(isbnNumber.getText(), newAuthorList);
                
                BookMgr newBook = new BookMgr();
                
                if (book.validate())
                {                   
                   bookResults.setText(newBook.storeBook(book) + " has been added!");
                                                                            
                   textPanel.validate();
                   
                   textPanel.repaint();                   
                }
                else
                {
                    Exception e = new Exception("Error - Could not add book.");

                    throw e;
                }

            } 
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }
        }); 
        resetButton.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent ex)
        {
            isbnNumber.setText("");
            authorList.setText("");
        }
        }); 
        exitButton.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent ex)
        {
            System.exit(0);               
        }
        }); 
    }
    
    // Mouse Listener Class
    private class MouseHandler implements MouseListener
    {
        private boolean firstRun = false;
        
        public void mousePressed(MouseEvent e)
        {
            // intentionally blank.
        }
        public void mouseReleased(MouseEvent e)
        {
            // intentionally blank.
        }
        public void mouseClicked(MouseEvent e)
        {
            if(firstRun == false)
                isbnNumber.setText("");
            firstRun = true;            
        }
        public void mouseEntered(MouseEvent e)
        {
            // intentionally blank.
        }
        public void mouseExited(MouseEvent e)
        {
            // intentionally blank.

        }
    }  
    
    public static void main(String[] args)
    {      
        JFrame frame = new AddBook();

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
