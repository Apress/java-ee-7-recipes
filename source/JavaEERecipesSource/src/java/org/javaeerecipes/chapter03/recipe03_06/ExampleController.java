
package org.javaeerecipes.chapter03.recipe03_06;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * Recipe 3-6
 * @author juneau
 */
@ManagedBean(name = "exampleController")
@RequestScoped
public class ExampleController {
    private String exampleProperty;
    
    /**
     * Creates a new instance of ExampleController
     */
    public ExampleController() {
        exampleProperty = "Used to instantiate the bean.";
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                ResourceBundle.getBundle("/org/javaeerecipes/chapter03/Bundle").getString("ExampleMessage"), null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @return the exampleProperty
     */
    public String getExampleProperty() {
        return exampleProperty;
    }

    /**
     * @param exampleProperty the exampleProperty to set
     */
    public void setExampleProperty(String exampleProperty) {
        this.exampleProperty = exampleProperty;
    }
}
