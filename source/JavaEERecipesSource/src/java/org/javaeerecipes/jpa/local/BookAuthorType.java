
package org.javaeerecipes.jpa.local;

import java.util.List;
import javax.ejb.Local;
import org.javaeerecipes.jpa.entity.BookAuthor;

/**
 * Local business interface for the BookAuthorFacade stateless session bean
 * @author juneau
 */
// Comment this annotation to decorate the EJB itself with the annotation
@Local
public interface BookAuthorType {
    public List<BookAuthor> findAuthor();
    
   public List<BookAuthor> findAuthorByLast(String last);
}
