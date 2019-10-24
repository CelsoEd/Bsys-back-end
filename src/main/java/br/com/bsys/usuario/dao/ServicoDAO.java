package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Servicos;

import java.util.Optional;

public interface ServicoDAO {

    void servicoBarbearia(Servicos servicos);

    Optional<Servicos> buscaPorId(int id);

    void alteraServico(Servicos servicos);


}
