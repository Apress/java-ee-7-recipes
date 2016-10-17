/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaeerecipes.jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.javaeerecipes.jpa.entity.Contact;

/**
 *
 * @author juneau
 */
@Stateless
public class ContactFacade extends AbstractFacade<Contact> {
    @PersistenceContext(unitName = "JavaEERecipesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactFacade() {
        super(Contact.class);
    }
    
    
    
}
