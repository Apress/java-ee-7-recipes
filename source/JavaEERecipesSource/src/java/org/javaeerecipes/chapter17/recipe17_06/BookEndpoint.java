/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaeerecipes.chapter17.recipe17_06;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser.Event;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;
import org.javaeerecipes.jpa.entity.Book;
import org.javaeerecipes.jpa.entity.BookAuthor;
import org.javaeerecipes.jpa.session.BookAuthorFacade;
import org.javaeerecipes.jpa.session.BookFacade;

/**
 *
 * @author Juneau
 */
@ServerEndpoint("/bookEndpoint")
public class BookEndpoint {

    @EJB
    BookFacade bookFacade;
    @EJB
    BookAuthorFacade bookAuthorFacade;

    @OnMessage
    public String onMessage(String message) {
        System.out.println("At the endpoint: " + message);
        String lastname = parseObject(message);
        System.out.println(lastname);
        if (lastname.contains(";")){
            // handle many authors...
        }
        BookAuthor chosenAuthor = null;
        //List<BookAuthor> authorList = bookAuthorFacade.findAuthorByLast(lastname);
        //System.out.println("Number of authors: " + authorList.size());
        // Take last from list for this exercise
        //for (BookAuthor author : authorList) {
        //    chosenAuthor = author;
        //}
        //List<Book> bookList = bookFacade.findBooksByAuthor(chosenAuthor);
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setId(BigDecimal.valueOf(1.0));
        book1.setTitle("Java EE 7 Recipes");
        book1.setDescription("Java EE 7 Recipes Book Description");
        bookList.add(book1);
        Book book2 = new Book();
        book2.setTitle("Java 7 Recipes");
        book2.setDescription("Java 7 Recipes Book Description");
        book2.setId(BigDecimal.valueOf(2.0));
        bookList.add(book2);
        Book book3 = new Book();
        book3.setId(BigDecimal.valueOf(3.0));
        book3.setTitle("Oracle PL/SQL Recipes");
        book3.setDescription("Oracle PL/SQL Recipes Book Description");
        bookList.add(book3);
        Book book4 = new Book();
        book4.setId(BigDecimal.valueOf(4.0));
        book4.setTitle("The Definitive Guide to Jython");
        book4.setDescription("Jython Book Description");
        bookList.add(book4);
        buildObject(bookList);
        System.out.println(bookList);
        return bookList.toString();
    }

    public JsonObject buildObject(List<Book> books) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        StringBuilder json = new StringBuilder();
        JsonObjectBuilder object = null;
        JsonObject result = null;

        for (Book book : books) {

            builder.add("book", Json.createObjectBuilder()
                    .add("bookId", book.getId())
                    .add("bookTitle", book.getTitle())
                    .add("bookDescription", book.getDescription()));

        }
        result = builder.build();

        return result;
    }

    public String parseObject(String authors) {
        InputStream in = new ByteArrayInputStream(authors.getBytes());
        String last = null;
        javax.json.stream.JsonParser parser = Json.createParser(in);
        javax.json.stream.JsonParser.Event ev = null;
        System.out.println("in the parser");
        // Read the authors object
        if(parser.hasNext()){
            ev = parser.next();
        }
        while (ev != Event.END_OBJECT) {
            switch (ev) {
                case KEY_NAME: {
                    System.out.println(parser.getString());
                    if (parser.getString().equals("authorLast")) {
                        ev = parser.next();
                        // Check to see if there are any other last names
                        if (last != null)
                            last = "; " + parser.getString();
                        else 
                            last = parser.getString();
                    }
                    break;
                }
               
            }
            ev = parser.next();
        }
        return last;

    }
}
