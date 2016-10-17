
package org.javaeerecipes.javafx.recipe18_05;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.IOException;
import java.net.MalformedURLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javax.ws.rs.core.MediaType;

/**
 * Service class that is used to retrieve web service data and return
 * @author juneau
 */
public class RestClientService extends Service<String> {

    private StringProperty url = new SimpleStringProperty();

    public final void setUrl(String value) {
        url.set(value);
    }

    public final String getUrl() {
        return url.get();
    }

    public final StringProperty urlProp() {
        return url;
    }

    protected Task<String> createTask() {
        
        return new Task<String>() {
            protected String call()
                    throws IOException, MalformedURLException {
                String result = obtainData();
                return result;
            }
        };
    }

    private String obtainData() {
        String restString = null;
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:8080/JavaEERecipesJPA/rest/simplerest/");

            ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN)
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            restString = response.getEntity(String.class);

        } catch (Exception e) {

            e.printStackTrace();

        }
        return restString;
    }
}
