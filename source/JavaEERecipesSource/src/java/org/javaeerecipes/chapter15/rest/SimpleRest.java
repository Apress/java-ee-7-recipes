package org.javaeerecipes.chapter15.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.javaeerecipes.chapter15.recipe15_07.MessageWrapper;

// Set the PATH to http://host:port/application/rest/simplerest/
@Path("/simplerest")
public class SimpleRest {
    
    private String message = "Hello from a simple REST Service";
    private String htmlMessage = "<p><b>" + message + "</b></p>";
    
    @GET
    // Produces plain text message
    @Produces("text/plain")
    public String getPlainMessage() {
        return message;
    }
    
    @GET
    // Produces plain text message
    @Produces("text/html")
    public String getHTMLMessage() {
        return htmlMessage;
    }
    
    @GET
    // Produces plain text message
    @Produces("application/xml")
    public MessageWrapper getXMLMessage() {
        return new MessageWrapper(message);
    }
    
    @POST
    @Path("add")
    @Consumes("text/plain")
    public String add(@QueryParam("text") String text){
        this.message = text;
        return message;
    }
}