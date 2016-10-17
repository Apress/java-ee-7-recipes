
package org.javaeerecipes.chapter15.recipe15_10;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * Recipe 15-10:  Asynchronous Processing
 * @author Juneau
 */
@Path("/asynchronous/asyncResource")
public class AsyncResource {
    
    @Resource(name = "concurrent/__defaultManagedExecutorService")
    ManagedExecutorService mes;
    
    @GET
    public void asyncOperation(@Suspended final AsyncResponse ar){
        mes.submit(
                new Runnable() {
                    public void run(){
                        // Perform long running operation
                        longRunningOperation();
                        ar.resume("Performing asynchronous operation");
                    }
                });
    }
    
    public void longRunningOperation(){
        // This is a method that contains a long-running operation
        System.out.println( "Performing long running task...");
    }
    
}
