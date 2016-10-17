
package org.javaeerecipes.chapter12.recipe12_09;

import java.lang.annotation.Annotation;
import javax.enterprise.inject.spi.Bean;
import javax.inject.Inject;
import javax.inject.Named;
import org.javaeerecipes.chapter12.recipe12_06.OrderBean;


/**
 *
 * @author Juneau
 */
@Named("OtherBean")
public class OtherBean {
 //   @Inject Bean<OrderBean> bean;

        public String getBeanName(){
    //    return bean.getName();
            return null;
    }
    
    public Class<? extends Annotation> getBeanScope(){
        return null; //bean.getScope();
    }
}

