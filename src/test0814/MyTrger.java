package test0814;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@interface MyTrger {
    String value() default " ";

}
