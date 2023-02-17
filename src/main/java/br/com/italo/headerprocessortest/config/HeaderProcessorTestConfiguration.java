package br.com.italo.headerprocessortest.config;

import br.org.learn.leandro.EnableHeaderProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableHeaderProcessor
@Configuration
public class HeaderProcessorTestConfiguration {

    @Bean
    HelloHeaderProcessorDummyService helloHeaderProcessorDummyService() {
        return new HelloHeaderProcessorDummyService("Fale oi para o Italo e mostre o que você tem!");
    }
}
