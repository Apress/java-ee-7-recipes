/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaeerecipes.chapter06;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author juneau
 */
@ManagedBean(name = "bookstoreController")
@SessionScoped
public class BookstoreController implements Serializable {
    
    private Date dayAndTime = null;

    /**
     * Creates a new instance of BookstoreController
     */
    public BookstoreController() {
    }

    /**
     * @return the dayAndTime
     */
    public Date getDayAndTime() {
        dayAndTime = new Date();
        return dayAndTime;
    }

    /**
     * @param dayAndTime the dayAndTime to set
     */
    public void setDayAndTime(Date dayAndTime) {
        this.dayAndTime = dayAndTime;
    }
}
