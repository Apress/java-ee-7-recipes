

package org.javaeerecipes.chapter12.recipe12_06;

import java.util.List;
import javax.enterprise.inject.Produces;
import org.javaeerecipes.jpa.entity.Book;


/**
 * Recipe 12-6 - @Veto Annotation
 * @author Juneau
 */

//@Veto
public class OrderBean implements java.io.Serializable {
    
   // @Produces @Disposer
    List<Book> books;
    
    public OrderBean(){
        
    }
    
    // Some Class Implementation
}
