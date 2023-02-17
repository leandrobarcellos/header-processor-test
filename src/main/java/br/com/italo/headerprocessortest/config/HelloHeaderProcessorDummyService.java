package br.com.italo.headerprocessortest.config;

import lombok.Getter;

@Getter
public class HelloHeaderProcessorDummyService {
    private final String msg;

    public HelloHeaderProcessorDummyService(String msg) {
        this.msg = msg;
    }

}
