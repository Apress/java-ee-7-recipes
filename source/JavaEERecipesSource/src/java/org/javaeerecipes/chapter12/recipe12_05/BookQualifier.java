package org.javaeerecipes.chapter12.recipe12_05;

import java.lang.annotation.*;
import javax.inject.Qualifier;

/**
 * 12-5 Qualifier
 * @author juneau
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Qualifier
public @interface BookQualifier {} 
