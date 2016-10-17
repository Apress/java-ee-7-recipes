package org.javaeerecipes.chapter13.recipe13_04;

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
public class Example13_04 {

        // Inject JMSContext if working within application server
    //  - Injection without any parameters utlizes the default application server
    //    connection factory
    // @Inject
    // JMSContext context;
    @Resource(name = "jms/javaEERecipesConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "jms/javaEERecipesQueue")
    private Queue myQueue;
    private Connection connection;
    private String displayMessage = "No messages as yet...";

    /**
     * Creates a new instance of Example13_04
     */
    public Example13_04() {
    }

    public void createConnection() {
        try {
            connection = connectionFactory.createConnection();

        } catch (JMSException ex) {
            Logger.getLogger(Example13_04.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (JMSException ex) {
            Logger.getLogger(Example13_04.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Context getContext() throws NamingException {
        Context jndiContext = new InitialContext();
        return jndiContext;

    }

    /**
     * Receive message using the standard JMS API
     */
    public void receiveMessage() {
        boolean stopReceivingMessages = false;
        if (connection == null) {
            createConnection();
        }
        try (Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);) {
            createConnection();
            System.out.println("Creating session to receive message");

            myQueue = (Queue) getContext().lookup("jms/javaEERecipesQueue");
            System.out.println("Setting up consumer");
            try (MessageConsumer consumer = session.createConsumer(myQueue)) {
                connection.start();

                while (!stopReceivingMessages) {
                    System.out.println("Receiving message");
                    Message inMessage = consumer.receive();
                    if (inMessage != null) {
                        System.out.println(inMessage);
                        if (inMessage instanceof TextMessage) {
                            String messageStr = ((TextMessage) inMessage).getText();
                            System.out.println(messageStr);
                            setDisplayMessage(messageStr);
                        } else {
                            System.out.println("Message was of another type");
                            setDisplayMessage("Message was of another type");
                        }
                    } else {
                        stopReceivingMessages = true;
                    }

                }
                connection.stop();
            }

        } catch (NamingException | JMSException ex) {
            Logger.getLogger(Example13_04.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                closeConnection();
            }
        }
    }

    /**
     * Receive a message using the new JMS API
     */
    public String receiveMessageNew() {
        try (JMSContext context = connectionFactory.createContext()) {
            JMSConsumer consumer = context.createConsumer(myQueue);
            return consumer.receiveBody(String.class);
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
