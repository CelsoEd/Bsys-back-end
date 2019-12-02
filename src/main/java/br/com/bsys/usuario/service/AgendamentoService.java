package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.AgendamentoDAO;
import br.com.bsys.usuario.entidade.Agendamento;
import br.com.bsys.usuario.entidade.Cliente;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.util.exception.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AgendamentoService {

    @Inject
    private AgendamentoDAO agendamentoDAO;

    @EJB
    private ServicoService servicoService;

    @EJB
    private ClienteService clienteService;

    public void cadastraAgendamento(String idCliente, int idServico, Agendamento agendamento) throws NotFoundException {
        Cliente cliente = clienteService.consultaPorId(idCliente);
        Servicos servicos = servicoService.consultaPorId(idServico);
        agendamento.setCliente(cliente);
        agendamento.setServicos(servicos);
        agendamentoDAO.insere(agendamento);
    }

    public void confirmarAgendament(int id){
        agendamentoDAO.confirmar(id);
    }

    public void cancelarAgendamento(int id){
        agendamentoDAO.cancelar(id);
    }


}
