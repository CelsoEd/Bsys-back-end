package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Barbearia;

import java.util.Optional;

public interface BarbeariaDAO {
    Optional<Barbearia> procurarPorEmailESenha(String email, String senha);

    void insere(Barbearia barbearia);

    Optional<Barbearia> consultaPorId(String id);

}
