
package org.javaeerecipes.chapter13.recipe13_06;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author juneau
 */
@ManagedBean
@ApplicationScoped
public class Example13_06 {

    @Resource(name = "jms/javaEERecipesConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "jms/javaEERecipesQueue")
    private Queue myQueue;
    private Connection connection;
    private String displayMessage = "No messages as yet...";
    /**
     * Creates a new instance of Example13_04
     */
    public Example13_06() {
    }


    public void createConnection() {
        try {
            connection = connectionFactory.createConnection();

        } catch (JMSException ex) {
            Logger.getLogger(Example13_06.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void closeConnection() {
        try {
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(Example13_06.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Context getContext() throws NamingException {
        Context jndiContext = new InitialContext();
        return jndiContext;

    }

    public void browseMessages() {

        try(Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueBrowser browser = session.createBrowser(myQueue);) {

            Enumeration msgs = browser.getEnumeration();
            
            if(!msgs.hasMoreElements()){
                System.out.println("No more messages within the queue...");
            } else {
                while(msgs.hasMoreElements()){
                    Message currMsg = (Message)msgs.nextElement();
                    System.out.println("Message ID: " + currMsg.getJMSMessageID());       
                }
            }

        } catch (JMSException ex) {
            System.out.println(ex);
        } 

    }

    /**
     * @return the displayMessage
     */
    public String getDisplayMessage() {
        return displayMessage;
    }

    /**
     * @param displayMessage the displayMessage to set
     */
    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}