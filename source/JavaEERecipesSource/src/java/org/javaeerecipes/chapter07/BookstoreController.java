package org.javaeerecipes.chapter07;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author juneau
 */
@ManagedBean(name = "ch7BookstoreController")
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
