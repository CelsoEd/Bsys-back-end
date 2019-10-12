package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.usuario.entidade.Usuario;

import java.util.Optional;

public interface BarbeariaDAO {
    Optional<Barbearia> procurarPorEmailESenha(String email, String senha);

    void insere(Barbearia barbearia);

    Optional<Usuario> consultaPorId(String id);

    void insereServico(Barbearia barbearia, Servicos servicos);

}
