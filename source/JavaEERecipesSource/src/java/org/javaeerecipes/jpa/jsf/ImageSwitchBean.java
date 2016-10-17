
package org.javaeerecipes.jpa.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author Juneau
 */
@Named(value="imageSwitchBean")
public class ImageSwitchBean {
    private List<String> images;
    
    public ImageSwitchBean() {
        images = new ArrayList<String>();
        images.add("resources/image/java7recipes.png");
        images.add("resources/image/javaee7recipes.png");
        images.add("resources/image/javafx.png");
    }
    
    public List<String> getImages(){
        return images;
    }
}
