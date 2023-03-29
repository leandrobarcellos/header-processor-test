package br.com.anonymous.headerprocessortest.config;

import br.org.learn.leandro.config.DefaultHeaderProcessorProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@RequiredArgsConstructor
@Service
public class HelloHeaderProcessorService {
    private final DefaultHeaderProcessorProperties properties;

    public String getMsg() {
        return "Fale oi para o usuário e diga qual é o quarto header: " + properties.getFourthHeader();
    }

}
