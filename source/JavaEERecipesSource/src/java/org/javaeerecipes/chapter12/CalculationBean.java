
package org.javaeerecipes.chapter12;


/**
 *
 * @author juneau
 */
public class CalculationBean {
    
    public int addNumbers(int[] numArray){
        int temp = 0;
        for(int x : numArray){
            temp = temp + x;
        }
        return temp;
    }
    
}
