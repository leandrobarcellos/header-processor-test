package br.com.italo.headerprocessortest.config;

import br.org.learn.leandro.beans.Interceptador;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class HelloHeaderProcessorService {
    private final Interceptador interceptador;

    public HelloHeaderProcessorService(Interceptador interceptador) {
        this.interceptador = interceptador;
    }

    public String getMsg() {
        return "Fale oi para o Ítalo e diga qual é o quarto header: " + interceptador.getFourth();
    }

}
