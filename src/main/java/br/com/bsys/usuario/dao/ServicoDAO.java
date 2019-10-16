package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.entidade.Servicos;

public interface ServicoDAO {

    void servicoBarbearia(Servicos servicos);

    void servicoFreelancer(Servicos servicos);

    void alteraServico(Servicos servicos);


}
