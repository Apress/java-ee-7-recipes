//
package org.javaeerecipes.javafx.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.javaeerecipes.javafx.entity.Book;

/**
 * Stateless Session Bean for the Book entity
 * @author juneau
 */

@Stateless
public class BookFacade extends AbstractFacade<Book> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEERecipesFXPU");
    EntityManager em = emf.createEntityManager();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
    /**
     * Create a book object
     * @param book 
     */
    public void create(Book book){
        em.persist(book);
    }
    
    /**
     * Update a book object
     * @param book 
     */
    public void edit(Book book){
        em.merge(book);
    }
    
    /**
     * Remove a book object
     * @param book 
     */
    public void remove(Book book){
        em.remove(book);
    }
    
    /**
     * Return a Book object based upon a given title.  This assumes that there
     * are no duplicate titles in the database.
     * @param title
     * @return 
     */
    public Book findByTitle(String title){
        return (Book) em.createQuery("select object(o) from Book o " +
                              "where o.title = :title")
                              .setParameter("title", title.toUpperCase())
                              .getSingleResult();
    }
    
    /**
     * Recipe 10-9:  Forcing a query to be executed
     * @return 
     */

    public List<Book> findAllBooks(){ 
        Query qry = em.createQuery("select o from Book o");
        qry.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        return qry.getResultList();
    }
    
    
  
    
    
}
