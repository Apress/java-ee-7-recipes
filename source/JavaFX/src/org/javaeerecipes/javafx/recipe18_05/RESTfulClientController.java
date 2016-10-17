
package org.javaeerecipes.javafx.recipe18_05;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Controller class for acme_bookstore_rest.fxml
 * @author juneau
 */
public class RESTfulClientController implements Initializable {

    @FXML private Label clientLabel;
  
    private String restString;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RestClientService serv = new RestClientService();
        
        serv.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerEv) {
                restString =  workerEv.getSource().getValue().toString();
                
            }
        });
        serv.start();
    }
    
    @FXML
    private void obtainRestText(){
        clientLabel.setText(restString);
    }
    
}
