package br.com.anonymous.headerprocessortest.resources;

import br.com.anonymous.headerprocessortest.config.HelloHeaderProcessorDummyService;
import br.com.anonymous.headerprocessortest.config.HelloHeaderProcessorService;
import br.com.anonymous.headerprocessortest.config.ValidateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RequiredArgsConstructor
@RestController
@RequestMapping()
public class ObjectResource {

    private final HelloHeaderProcessorService service;
    private final HelloHeaderProcessorDummyService dummyService;

    @ValidateRequest(value = "xpto", valueTwo = "é bacana")
    @GetMapping("/objeto")
    ObjetoBackend getObjeto() {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(1955, Calendar.MARCH, 20);
        return new ObjetoBackend("Leandro", "12345678909", dataNascimento.getTime());
    }
}
