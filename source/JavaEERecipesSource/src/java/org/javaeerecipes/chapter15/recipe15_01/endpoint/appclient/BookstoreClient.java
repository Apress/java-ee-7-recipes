/*
 * Web service client that consumes JAX-WS and JAX-RS services
 */
package org.javaeerecipes.chapter15.recipe15_01.endpoint.appclient;

import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.javaeerecipes.chapter15.recipe15_01.endpoint.BookstoreService;
import org.javaeerecipes.chapter15.recipe15_01.endpointinterface.BookstoreEndpoint;
import org.javaeerecipes.jpa.entity.Contact;

/**
 *
 * @author juneau
 */
public class BookstoreClient {


    public static void main(String[] args) {
        List<Contact> contacts = obtainList();
    }

    public static List<Contact> obtainList() {
        try {
            URL url = new URL("http://localhost:8080/JavaEERecipesJPA/BookstoreService?wsdl");

            QName qname = new QName("http://endpoint.recipe15_01.chapter15.javaeerecipes.org/", "BookstoreService");
            Service service = Service.create(url, qname);
            BookstoreEndpoint bookstore = service.getPort(BookstoreEndpoint.class);
            System.out.println(bookstore.obtainCompleteContactList());
        } catch (Exception e) {
            System.out.println("Exception: "+ e);
        }

        return null;
    }
}
