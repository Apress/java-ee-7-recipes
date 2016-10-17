
package org.javaeerecipes.chapter07;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import org.javaeerecipes.chapter07.dao.BookDAO;

/**
 *
 * @author juneau
 */
@ManagedBean(name="ch7BookController")
@SessionScoped
public class BookController implements java.io.Serializable {
    private List<Book> completeBookList = null;
    private BookDAO bookDao = new BookDAO();
    
   @ManagedProperty(value = "#{ch7AuthorController}")
    private AuthorController authorController;
    
    public BookController(){
        
    }

    /**
     * @return the completeBookList
     */
    public List<Book> getCompleteBookList() {
        completeBookList = bookDao.queryBooks();
        return completeBookList;
    }

    /**
     * @param completeBookList the completeBookList to set
     */
    public void setCompleteBookList(List<Book> completeBookList) {
        this.completeBookList = completeBookList;
    }
    
    public String populateBookList(int bookId){
       String returnValue = getAuthorController().populateAuthorList(bookId);
       return returnValue;
    }

    /**
     * @return the authorController
     */
    public AuthorController getAuthorController() {
        return authorController;
    }

    /**
     * @param authorController the authorController to set
     */
    public void setAuthorController(AuthorController authorController) {
        this.authorController = authorController;
    }
    
}
