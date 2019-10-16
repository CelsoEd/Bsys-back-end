package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.ServicoDAO;
import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.entidade.Servicos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ServicoDAOImp implements ServicoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void servicoBarbearia(Servicos servicos) {
        entityManager.persist(servicos);
    }

    @Override
    public void servicoFreelancer(Servicos servicos) {

    }

    @Override
    public void alteraServico(Servicos servicos) {

    }


}
