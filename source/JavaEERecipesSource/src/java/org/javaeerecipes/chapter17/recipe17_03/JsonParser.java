/*
 * Recipe 17-7
 */
package org.javaeerecipes.chapter17.recipe17_03;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.*;
import org.javaeerecipes.chapter17.JsonController;

/**
 *
 * @author Juneau
 */
@Named("jsonBuilder")
public class JsonParser {
    
    @Inject
    JsonController controller;

    public void parseObject() {
        InputStream in = new ByteArrayInputStream(controller.buildAndReturnAuthors().getBytes());
        
        javax.json.stream.JsonParser parser = Json.createParser(in);
        javax.json.stream.JsonParser.Event ev = parser.next();
        
    }
    
    public String readObject() {
        InputStream in = new ByteArrayInputStream(controller.buildAndReturnAuthors().getBytes());
        // or
        //Reader fileReader = new InputStreamReader(getClass().getResourceAsStream("AuthorObject.json"));
        //JsonReader reader = Json.createReader(fileReader);

        JsonReader reader = Json.createReader(in);
        JsonObject obj = reader.readObject();
        return obj.toString();
              
    }

    public static void main(String[] args) {
        JsonParser ex = new JsonParser();
        ex.parseObject();
    }

    
}
