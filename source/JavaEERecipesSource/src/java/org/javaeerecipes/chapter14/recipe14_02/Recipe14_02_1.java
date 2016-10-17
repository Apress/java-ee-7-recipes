/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaeerecipes.chapter14.recipe14_02;


import java.io.Serializable;
import javax.annotation.security.DeclareRoles;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author juneau
 */
@ManagedBean(name = "recipe14_02")
@SessionScoped
@DeclareRoles("users")
public class Recipe14_02_1 implements Serializable {

    /**
     * Creates a new instance of Recipe14_02
     */
    public Recipe14_02_1() {
    }
    
    public String nextPage(){
        return "recipe14_02b.xhtml";
    }
}
