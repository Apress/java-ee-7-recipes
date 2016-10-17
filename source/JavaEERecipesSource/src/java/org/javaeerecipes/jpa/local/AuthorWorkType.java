
package org.javaeerecipes.jpa.local;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;
import org.javaeerecipes.jpa.entity.AuthorWork;
import org.javaeerecipes.jpa.entity.Book;
import org.javaeerecipes.jpa.entity.BookAuthor;

/**
 * Local business interface for the AuthorWorkFacade stateless session bean
 * @author juneau
 */
// Comment this annotation to decorate the EJB itself with the annotation
@Local
public interface AuthorWorkType {
    public List<AuthorWork> performFind(BigDecimal bookId);
    
    public List<AuthorWork> performFindByAuthor(BookAuthor authorId);
    
    public Long findAuthorCount(Book book);
}
