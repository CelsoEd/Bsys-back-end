package br.com.bsys.usuario.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
}
