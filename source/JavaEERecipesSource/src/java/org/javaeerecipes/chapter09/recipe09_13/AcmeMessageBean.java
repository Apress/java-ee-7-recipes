
package org.javaeerecipes.chapter09.recipe09_13;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Juneau
 */
//@MessageDriven(mappedName="jms/Queue", activationConfig = {
//    @ActivationConfigProperty(propertyName = "destinationType",
//                              propertyValue = "javax.jms.Queue")
//})
public class AcmeMessageBean implements MessageListener {
    
    public AcmeMessageBean(){
        
    }

    @Override
    public void onMessage(Message msg) {
        if(msg != null){
            performExtraProcessing();
            System.out.println("Message has been received: " + msg);
        } else {
            System.out.println("No message received");
        }
    }
    
    public void performExtraProcessing(){
        System.out.println("This method could perform extra processing");
    }
     
}
