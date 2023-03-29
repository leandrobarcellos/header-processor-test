package br.com.anonymous.headerprocessortest.config.interceptors;

import br.com.anonymous.headerprocessortest.config.ValidateRequest;
import br.org.learn.leandro.beans.InterceptorHandlers;
import br.org.learn.leandro.contexts.PreHandleContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ValidateRequestConfiguration implements WebMvcConfigurer {

    private final InterceptorHandlers handlers;

    @PostConstruct
    void init() {
        handlers.addPreHandler(ValidateRequest.NAME, this::processXPTO);
    }

    private void processXPTO(PreHandleContext<ValidateRequest> context) {
        log.debug("{} passei aqui", context.getAnnotation().valueTwo());
    }

}
