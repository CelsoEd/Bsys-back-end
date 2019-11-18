package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Cliente;

import java.util.Optional;

public interface ClienteDAO {

    Optional<Cliente> procurarPorEmailESenha(String email, String senha);

    void insere(Cliente cliente);

    Optional<Cliente> consultaPorId(String id);

    void alterar(Cliente cliente);


}
