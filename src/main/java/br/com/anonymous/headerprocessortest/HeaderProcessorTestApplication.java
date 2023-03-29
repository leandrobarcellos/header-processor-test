package br.com.anonymous.headerprocessortest;

import br.org.learn.leandro.EnableHeaderProcessor;
import br.org.learn.leandro.EnableInterceptors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHeaderProcessor
@EnableInterceptors
@SpringBootApplication
public class HeaderProcessorTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeaderProcessorTestApplication.class, args);
    }

}
