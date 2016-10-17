package org.javaeerecipes.chapter03.recipe03_09;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Recipe 3-9
 *
 * @author juneau
 */
@ManagedBean(name = "authorTableController")
@SessionScoped
public class AuthorController implements Serializable {

    private List<Author> authorList = null;
    private String juneauBio =
            "Josh Juneau has been developing software"
            + " since the mid-1990s. PL/SQL development and database programming"
            + " was the focus of his career in the beginning, but as his skills developed,"
            + " he began to use Java and later shifted to it as a primary base for his"
            + " application development. Josh has worked with Java in the form of graphical"
            + " user interface, web, and command-line programming for several years. "
            + "During his tenure as a Java developer, he has worked with many frameworks"
            + " such as JSF, EJB, and JBoss Seam. At the same time, Josh has extended his"
            + " knowledge of the Java Virtual Machine (JVM) by learning and developing applications"
            + " with other JVM languages such as Jython and Groovy. His interest in learning"
            + " new languages that run on the JVM led to his interest in Jython. Since 2006,"
            + " Josh has been the editor and publisher for the Jython Monthly newsletter. "
            + "In late 2008, he began a podcast dedicated to the Jython programming language.";
    
    private String deaBio = "This is Carl Dea's Bio";
    private String beatyBio = "This is Mark Beaty's Bio";
    private String oConnerBio = "This is John O'Connor's Bio";
    private String guimeBio = "This is Freddy Guime's Bio";
    private Author current;
    private String authorLast;
    /**
     * Creates a new instance of RecipeController
     */
    public AuthorController() {
        super();
        authorLast = null;
        populateAuthorList();
    }

    private void populateAuthorList() {
        
        if(authorList == null){
            System.out.println("initializng authors list");
            authorList = new ArrayList<Author>();
            authorList.add(new Author("Josh", "Juneau", juneauBio));
            authorList.add(new Author("Carl", "Dea", deaBio));
            authorList.add(new Author("Mark", "Beaty", beatyBio));
            authorList.add(new Author("John", "O'Conner", oConnerBio));
            authorList.add(new Author("Freddy", "Guime", guimeBio));
        }
    }
    
    public String displayAuthor(String last){
        for(Author author:authorList){
            if(author.getLast().equals(last)){
                current = author;
                break;
            }
        }
        return "recipe03_09b";
    }

    /**
     * @return the authorList
     */
    public List getAuthorList() {
        System.out.println("Getting the authorlist =>" + authorList.size());
        return authorList;
    }

    /**
     * @return the current
     */
    public Author getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Author current) {
        this.current = current;
    }

    /**
     * @return the authorLast
     */
    public String getAuthorLast() {
        return authorLast;
    }

    /**
     * @param authorLast the authorLast to set
     */
    public void setAuthorLast(String authorLast) {
        displayAuthor(authorLast);
    }
}
