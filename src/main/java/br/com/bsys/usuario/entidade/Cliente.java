package br.com.bsys.usuario.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario {

    @Column
    private String cpf;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
    private List<Agendamento> agendamento;

}
