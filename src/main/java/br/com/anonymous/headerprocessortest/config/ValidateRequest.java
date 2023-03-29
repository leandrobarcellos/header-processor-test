package br.com.anonymous.headerprocessortest.config;

import br.org.learn.leandro.InterceptWhen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptWhen(ValidateRequest.NAME)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateRequest {
    String NAME = "VALIDATE_REQUEST";

    String value();

    String valueTwo();

    int valueThree() default 0;
}
