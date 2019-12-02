package br.com.bsys.usuario.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicos {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicos servicos = (Servicos) o;
        return id == servicos.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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

    @OneToMany(mappedBy = "servicos", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Agendamento> agendamento;

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
