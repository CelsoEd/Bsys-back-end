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

    @Column
    private String telefone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "freelancer")
    private List<Servicos> servicos;

    public Freelancer(String id, String nome, String email, String senha, TipoUsuario tipoUsuario, Endereco endereco, String cnpj, String telefone) {
        super(id, nome, email, senha, tipoUsuario, endereco);
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
