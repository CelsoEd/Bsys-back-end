package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.ServicoDAO;
import br.com.bsys.usuario.entidade.Servicos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ServicoDAOImp implements ServicoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void servicoBarbearia(Servicos servicos) {
        entityManager.persist(servicos);
    }

    @Override
    public void alteraServico(Servicos servicos) {

    }


}
