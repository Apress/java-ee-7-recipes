/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaeerecipes.chapter14.recipe14_02;

import java.io.Serializable;
import javax.annotation.security.RolesAllowed;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author juneau
 */
@ManagedBean(name = "recipe14_02b")
@SessionScoped

public class Recipe14_02b implements Serializable {

    /**
     * Creates a new instance of Recipe14_02
     */
    public Recipe14_02b() {
    }
    
    public String unsecuredProcess(){
        return "recipe14_02_1.xhtml";
    }
    
    @RolesAllowed("users")
    public String securedProcess(){
        return "recipe14_02_2.xhtml";
    }
}
