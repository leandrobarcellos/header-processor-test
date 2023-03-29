package br.com.anonymous.headerprocessortest.config.interceptors;

import br.com.anonymous.headerprocessortest.config.Proibidor;
import br.org.learn.leandro.beans.InterceptorHandlers;
import br.org.learn.leandro.contexts.AfterCompletionContext;
import br.org.learn.leandro.contexts.PostHandleContext;
import br.org.learn.leandro.contexts.PreHandleContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ProibidorConfiguration {

    private final InterceptorHandlers handlers;

    @PostConstruct
    void init() {
        handlers.addPreHandler(Proibidor.NAME, this::processProibidor);
        handlers.addPostHandler(Proibidor.NAME, this::postHandleProibidor);
        handlers.addAfterCompletion(Proibidor.NAME, this::afterCompletionProibidor);

    }

    private void afterCompletionProibidor(AfterCompletionContext<Proibidor> context) {
        long between = ChronoUnit.MILLIS.between(context.startedAt(), LocalDateTime.now());
        log.info("{} passou no aftercompletion proibidor. execução em {} millis", context.getAnnotation().value(), between);
        Optional.ofNullable(context.getException()).ifPresent(e -> log.error("Erro durante a execuçao da requisição", e));
    }

    private void postHandleProibidor(PostHandleContext<Proibidor> context) {
        log.info("{} passou no posthandler proibidor", context.getAnnotation().value());
    }

    private void processProibidor(PreHandleContext<Proibidor> context) {
        if (1 == context.getAnnotation().value()) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
        log.debug("{} passei aqui", context.getAnnotation().value());
    }

}
