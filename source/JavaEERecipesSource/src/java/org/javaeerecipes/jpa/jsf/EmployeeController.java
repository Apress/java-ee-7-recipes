
package org.javaeerecipes.jpa.jsf;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.javaeerecipes.jpa.entity.Employee;
import org.javaeerecipes.jpa.session.EmployeeSession;

/**
 *
 * @author Juneau
 */
@Named(value = "employeeController")
@RequestScoped
public class EmployeeController {
    
    @EJB
    EmployeeSession ejbFacade;

    /**
     * Creates a new instance of EmployeeController
     */
    public EmployeeController() {
    }
    
    public List getActiveEmployeeCount(){
        return ejbFacade.obtainActiveEmployeeCount();
    }
    
}
