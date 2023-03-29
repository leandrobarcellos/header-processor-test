package br.com.anonymous.headerprocessortest.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ObjetoBackend {
    private String nome;
    private String cpf;
    private Date dataNascimento;

}
