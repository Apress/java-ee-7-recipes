package org.javaeerecipes.chapter09.recipe09_13;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Juneau
 */
@ManagedBean
public class AcmeMessageClient implements java.io.Serializable {

    @Resource(mappedName = "jms/javaeeRecipesConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Queue")
    private static Queue queue;

    public void sendMessage() {

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();

            message.setText("This is a test message");
            System.out.println("Sending message: " + message.getText());
            messageProducer.send(message);
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message Sent", null);

            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (javax.jms.JMSException ex) {
            System.out.println(ex);
        }
    }
}
