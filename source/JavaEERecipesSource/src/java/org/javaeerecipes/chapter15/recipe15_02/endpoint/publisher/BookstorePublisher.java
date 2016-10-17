
package org.javaeerecipes.chapter15.recipe15_02.endpoint.publisher;

import javax.xml.ws.Endpoint;
import org.javaeerecipes.chapter15.recipe15_01.endpoint.BookstoreService;

 
//Endpoint publisher
public class BookstorePublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8085/JavaEERecipesJPA/BookstoreServicePub", new BookstoreService());
    }
 
}