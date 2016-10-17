/*
 * JAX-WS web service endpoint class
 * 
 */
package org.javaeerecipes.chapter15.recipe15_01.endpoint;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.javaeerecipes.chapter15.recipe15_01.endpointinterface.BookstoreEndpoint;
import org.javaeerecipes.jpa.entity.Contact;
import org.javaeerecipes.jpa.session.ContactFacade;


@WebService(serviceName="BookstoreService", 
            endpointInterface="org.javaeerecipes.chapter15.recipe15_01.endpointinterface.BookstoreEndpoint")
//@WebService(serviceName="BookstoreService")
//@WebServiceClient(name="BookstoreService",
//                  targetNamespace="http://localhost:8080",
//                  wsdlLocation="http://localhost:8080/JavaEERecipes/BookstoreService?WSDL")
public class BookstoreService implements BookstoreEndpoint {
    
    
    @EJB
    ContactFacade contactFacade;
    
    public void BookstoreService(){
        
    }
    
    @Override
  //  @WebMethod - Uncomment if not specifying an endpoint interface
    public String obtainCompleteContactList(){
        StringBuilder sb = new StringBuilder();
        sb.append("Here is the new JAX-WS Web Service\n");
        List<Contact> contacts = contactFacade.findAll();
        for(Contact contact: contacts){
            sb.append(contact.getEmail() + "\n");
        }
        return sb.toString();
    }
}
