
package org.javaeerecipes.chapter12.recipe12_03;

import java.lang.annotation.*;
import javax.inject.Qualifier;

/**
 *
 * @author juneau
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Qualifier
public @interface Paperback {} 