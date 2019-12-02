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

    @Override
    public void confirmar(int id) {
        Agendamento agendamento =entityManager.find(Agendamento.class, id);
        agendamento.setStatus(Status.AGENDADO);
        entityManager.merge(agendamento);
    }
    @Override
    public void cancelar(int id) {
        Agendamento agendamento =entityManager.find(Agendamento.class, id);
        agendamento.setStatus(Status.CANCELADO);
        entityManager.merge(agendamento);
    }
}
