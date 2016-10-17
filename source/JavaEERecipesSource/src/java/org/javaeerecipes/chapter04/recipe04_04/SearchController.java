
package org.javaeerecipes.chapter04.recipe04_04;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.javaeerecipes.chapter04.recipe04_01.Author;

/**
 * Recipe 4-4
 * @author juneau
 */
@ManagedBean(name = "searchController")
@RequestScoped
public class SearchController implements java.io.Serializable {

    private String searchText;
    private String errorText;
    
    @ManagedProperty(value="authorController")
    private AuthorController authorController;
    
    /**
     * Creates a new instance of SearchController
     */
    public SearchController() {

    }
    
    public String searchAuthors(List<Author> authorList){
        String fullName = null;
        String returnString = null;
       
        for (Author author: authorList){
            fullName = author.getFirst() + " " + author.getLast();
            if (author.getFirst().equalsIgnoreCase(searchText)){
                returnString = getAuthorController().displayAuthor(author.getLast());
            } else if (author.getLast().equalsIgnoreCase(searchText)){
                returnString = getAuthorController().displayAuthor(author.getLast());
            } else if (fullName.equalsIgnoreCase(searchText)){
                returnString = getAuthorController().displayAuthor(author.getLast());
            } 
        }  
        if(returnString == null){
            setErrorText("No Author Found");
            returnString = "recipe04_04a";
        }
        return returnString;
    }

    /**
     * @return the searchText
     */
    public String getSearchText() {
        return searchText;
    }

    /**
     * @param searchText the searchText to set
     */
    public void setSearchText(String searchText) {
        this.searchText = searchText;
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

    /**
     * @return the errorText
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * @param errorText the errorText to set
     */
    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
