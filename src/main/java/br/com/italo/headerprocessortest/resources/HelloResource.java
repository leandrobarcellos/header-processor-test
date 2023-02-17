package br.com.italo.headerprocessortest.resources;

import br.com.italo.headerprocessortest.config.HelloHeaderProcessorDummyService;
import br.com.italo.headerprocessortest.config.HelloHeaderProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hello")
public class HelloResource {

    private final HelloHeaderProcessorService service;
    private final HelloHeaderProcessorDummyService dummyService;

    @GetMapping
    String sayHello() {
        return service.getMsg();
    }

    @GetMapping("/dummy")
    String sayHelloDummy() {
        return dummyService.getMsg();
    }
}
