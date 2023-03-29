package br.com.anonymous.headerprocessortest.config.interceptors;

import br.org.learn.leandro.beans.InterceptorHandlers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class InterceptorsConfiguration {

    private final InterceptorHandlers processors;

    @PostConstruct
    void init() {
        processors.addPreHandler(this::primeiroPreHandler);
        processors.addPreHandler(this::segundoPreHandler);
        processors.addPreHandler(this::terceiroPreHandler);
        processors.addAfterCompletion(this::maisUmAfterCompletion);
        processors.addAfterCompletion(this::adicioneiMaisUm);

    }

    private boolean primeiroPreHandler(HttpServletRequest request, HttpServletResponse response, Object o) {
        log.info("Adicionei o primeiro pre-handler.");
        return true;
    }

    private boolean segundoPreHandler(HttpServletRequest request, HttpServletResponse response, Object o) {
        log.info("Adicionei o segundo pre-handler.");
        return true;
    }

    private boolean terceiroPreHandler(HttpServletRequest request, HttpServletResponse response, Object o) {
        log.info("Adicionei o terceiro pre-handler.");
        return true;
    }

    private void adicioneiMaisUm(HttpServletRequest request, HttpServletResponse response, Object o, Exception exception) {
        log.info("Adicionei mais um pra testar.");
    }

    private void maisUmAfterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception exception) {
        log.info("Mais um After Completion para testar.");
    }
}
