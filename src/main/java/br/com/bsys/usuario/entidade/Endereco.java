package br.com.bsys.usuario.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class Endereco {

    @Column
    private String cep;

    @Column
    private String numero;

    @Column
    private String complemento;

    @Column
    private String uf;

    @Column
    private String cidade;

    @Column
    private String logradouro;

    @Column
    private String bairro;
}
