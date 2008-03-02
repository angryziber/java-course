package net.azib.java.lessons.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Todo sample annotation
 *
 * @author anton
 */
@Target(ElementType.TYPE)
public @interface Todo {
	String value() default "";
}
