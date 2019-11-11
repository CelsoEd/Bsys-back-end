package br.com.bsys.usuario.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double valor;

    @JsonIgnore
    @ManyToOne
    private Barbearia barbearia;

    @JsonIgnore
    @ManyToOne
    private Freelancer freelancer;

    public Servicos(String descricao, Double valor, Barbearia barbearia) {
        this.descricao = descricao;
        this.valor = valor;
        this.barbearia = barbearia;
    }

    public Servicos(String descricao, Double valor, Freelancer freelancer) {
        this.descricao = descricao;
        this.valor = valor;
        this.freelancer = freelancer;
    }
}
