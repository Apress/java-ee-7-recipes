
package org.javaeerecipes.chapter15.rest.service;

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.xml.ws.Response;

/**
 *
 * @author Juneau
 */
public class RestClient {
    
    public static void main(String[] args){
        // Obtain an instance of the client
        Client client = ClientBuilder.newClient();
        
        WebTarget wt = client.target("http://localhost:8080/JavaEERecipes/rest/simplerest");
        Response res = (Response) wt.request("application/xml").get();
        try {
            System.out.println((String) res.get());
        } catch (InterruptedException ex) {
            Logger.getLogger(RestClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(RestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
