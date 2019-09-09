package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Cliente;
import br.com.bsys.usuario.entidade.Usuario;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UsuarioRequisicaoCadastroDTO implements DTO<Usuario> {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String senha;

    private TipoUsuario tipoUsuario;

    @Override
    public Usuario paraObjeto() {
        Usuario usuario = new Cliente();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setTipoUsuario(this.tipoUsuario);
        return usuario;
    }
}
