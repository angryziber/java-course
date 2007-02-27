package net.azib.java.simple;

import java.lang.annotation.*;

/**
 * Todo sample annotation
 *
 * @author anton
 */
@Target(ElementType.TYPE)
public @interface Todo {
	String value() default "";
}
