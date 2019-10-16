package br.com.bsys.usuario.entidade;

import br.com.bsys.usuario.util.TipoUsuario;
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
public class Barbearia extends Usuario {

    @Column
    private String cnpj;

    @Column
    private String telefone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "barbearia")
    private List<Servicos> servicos;

    public Barbearia(String id, String nome, String email, String senha, TipoUsuario tipoUsuario, Endereco endereco, String cnpj, String telefone) {
        super(id, nome, email, senha, tipoUsuario, endereco);
        this.cnpj = cnpj;
        this.telefone = telefone;
    }
}


