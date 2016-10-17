
package org.javaeerecipes.chapter12.recipe12_05;

import javax.enterprise.inject.Produces;

/**
 * Recipe 12-5:  Producer Fields and Methods
 * @author juneau
 */

public class InitialValueController implements java.io.Serializable {
    
       @Produces @InitValue public int initialValue = 1000;
       
       
}