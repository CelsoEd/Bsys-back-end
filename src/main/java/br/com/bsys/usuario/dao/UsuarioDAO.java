package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Usuario;

import java.util.Optional;

public interface UsuarioDAO {

    Optional<Usuario> procurarPorEmailESenha(String email, String senha);

    void insere(Usuario usuario);

    Optional<Usuario> consultaPorId(String id);

    void alteraUsuario(Usuario usuario);

}
