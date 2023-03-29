package br.com.anonymous.headerprocessortest.resources;

import br.com.anonymous.headerprocessortest.config.HelloHeaderProcessorDummyService;
import br.com.anonymous.headerprocessortest.config.HelloHeaderProcessorService;
import br.com.anonymous.headerprocessortest.config.Proibidor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hello")
public class HelloResource {

    private final HelloHeaderProcessorService service;
    private final HelloHeaderProcessorDummyService dummyService;

    @Proibidor
    @GetMapping
    String sayHello() {
        return service.getMsg();
    }

    @Proibidor(1)
    @GetMapping("/dummy")
    String sayHelloDummy(@RequestParam("someParam") String someParam) {
        return dummyService.getMsg();
    }

    @Proibidor
    @GetMapping("/dummy/{someVar}")
    String sayHelloDummyThrowsException(@PathVariable("someVar") String someVar) {
        throw new UnsupportedOperationException("Operação não suportada. "+someVar);
    }
}
