package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.AgendamentoDAO;
import br.com.bsys.usuario.entidade.Agendamento;
import br.com.bsys.usuario.util.Status;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AgendamentoDAOImp implements AgendamentoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insere(Agendamento agendamento) {
        agendamento.setStatus(Status.SOLICITADO);
        entityManager.persist(agendamento);
    }
}
