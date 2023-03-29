package br.com.anonymous.headerprocessortest.config;

import br.org.learn.leandro.InterceptWhen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptWhen(Proibidor.NAME)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Proibidor {
    String NAME = "PROIBIDOR";
    int value() default 0;
}
