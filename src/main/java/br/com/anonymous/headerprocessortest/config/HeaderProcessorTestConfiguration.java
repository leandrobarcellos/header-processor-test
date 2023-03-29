package br.com.anonymous.headerprocessortest.config;

import br.org.learn.leandro.EnableInterceptors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@RequiredArgsConstructor
@EnableInterceptors
@Configuration
public class HeaderProcessorTestConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    HelloHeaderProcessorDummyService helloHeaderProcessorDummyService() {
        return new HelloHeaderProcessorDummyService("Fale oi para o usuário e mostre o que você tem!");
    }

}
