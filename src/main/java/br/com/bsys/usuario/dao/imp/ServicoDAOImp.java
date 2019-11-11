package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.ServicoDAO;
import br.com.bsys.usuario.entidade.Servicos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class ServicoDAOImp implements ServicoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void servicoBarbearia(Servicos servicos) {
        entityManager.persist(servicos);
    }

    @Override
    public Optional<Servicos> buscaPorId(int id) {
        return  Optional.ofNullable(entityManager.find(Servicos.class, id));
    }

    @Override
    public void alteraServico(Servicos servicos) {
        entityManager.merge(servicos);
    }


}
