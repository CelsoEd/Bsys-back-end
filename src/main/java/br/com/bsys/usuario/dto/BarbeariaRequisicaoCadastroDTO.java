package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BarbeariaRequisicaoCadastroDTO implements DTO<Barbearia> {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String senha;

    private TipoUsuario tipoUsuario;

    private String cnpj;

    @Override
    public Barbearia paraObjeto() {
        Barbearia barbearia = new Barbearia();
        barbearia.setNome(this.nome);
        barbearia.setEmail(this.email);
        barbearia.setSenha(this.senha);
        barbearia.setCnpj(this.cnpj);

        return barbearia;
    }
}
