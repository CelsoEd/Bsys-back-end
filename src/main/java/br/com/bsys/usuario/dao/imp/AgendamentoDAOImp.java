package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.AgendamentoDAO;
import br.com.bsys.usuario.entidade.Agendamento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AgendamentoDAOImp implements AgendamentoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insere(Agendamento agendamento) {
        entityManager.persist(agendamento);    
    }
}
