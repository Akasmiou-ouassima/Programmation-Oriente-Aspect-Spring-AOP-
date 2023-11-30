package org.example.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // to be available at runtime (not only in the source code)
@Target(ElementType.METHOD) // to be used on methods only (not classes, fields, constructor, etc.)
public @interface Log {
}
