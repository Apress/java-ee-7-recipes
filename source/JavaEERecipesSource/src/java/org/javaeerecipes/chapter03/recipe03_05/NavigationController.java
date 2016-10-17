
package org.javaeerecipes.chapter03.recipe03_05;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 * Recipe 3-5
 * @author juneau
 */
@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationController implements java.io.Serializable{
    
    private boolean authenticated = false;

    /**
     * Creates a new instance of NavigationController
     */
    public NavigationController() {
    }
    
    public String pageOne(){
        return "PAGE_1";
    }
    
    public String pageTwo(){
        return "PAGE_2";
    }
    
    /**
     * Utilizing implicit navigation, a page name can be returned from an 
     * action method rather than listing a navigation-rule within faces-config.xml
     * @return 
     */
    public String nextPage(){
        // Perform some task, then implicitly list a page to render
        
        return "recipe03_05c";
    }
    
    /**
     * Demonstrates the use of conditional navigation
     */
    public void login(){
        // Perform some task
        setAuthenticated(true);
    }

    /**
     * @return the authenticated
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * @param authenticated the authenticated to set
     */
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
