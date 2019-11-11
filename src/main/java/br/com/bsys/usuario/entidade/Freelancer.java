package br.com.bsys.usuario.entidade;

import br.com.bsys.usuario.util.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Freelancer extends Usuario {

    @Column
    private String cpf;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "freelancer")
    private List<Servicos> servicos;


}
