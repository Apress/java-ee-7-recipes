
package org.javaeerecipes.chapter19.recipe19_04;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.javaeerecipes.jpa.entity.BookAuthor;
import org.javaeerecipes.jpa.session.BookAuthorFacade;

/**
 *
 * @author Juneau
 */
public class UserTransactionTask implements Runnable {

    @Resource
    SessionContext ctx;
    
    @EJB
    private BookAuthorFacade bookAuthorFacade;
    UserTransaction ut = ctx.getUserTransaction();

    public void run() {
        try {
            // Start a transaction ut.begin();
            ut.begin();
            List<BookAuthor> authors = bookAuthorFacade.findAuthor();
            for (BookAuthor author : authors) {
                // Do something
                System.out.println(author.getLast());
            }
            ut.commit();
        } catch (NotSupportedException | SystemException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException ex) {
            Logger.getLogger(UserTransactionTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}