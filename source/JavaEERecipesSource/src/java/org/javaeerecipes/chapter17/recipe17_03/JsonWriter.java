/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaeerecipes.chapter17.recipe17_03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonObject;
import org.javaeerecipes.chapter17.JsonController;

/**
 *
 * @author Juneau
 */
@Named("jsonWriter")
public class JsonWriter {
    
    @Inject
    JsonController jsonController;
    
    public void writeJson() {
        try {
            JsonObject jsonObject = jsonController.buildAuthorsJson();

            javax.json.JsonWriter jsonWriter = Json.createWriter(new FileWriter("Authors.json"));
            
            jsonWriter.writeObject(jsonObject);
            jsonWriter.close();


            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO, "JSON Built",
                "JSON Built"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
