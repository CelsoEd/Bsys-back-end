package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.BarbeariaDAO;
import br.com.bsys.usuario.dao.ServicoDAO;
import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.util.exception.NotFoundException;

import javax.ejb.EJB;
import javax.inject.Inject;

public class ServicoService {

    @Inject
    private ServicoDAO servicoDAO;

    @EJB
    private BarbeariaService barbeariaService;

    public void novoServicoBarbearia(String id, Servicos servico) throws NotFoundException {
        Barbearia barbearia = barbeariaService.consultaPorId(id);
        servico.setBarbearia(barbearia);
        servicoDAO.servicoBarbearia(servico);

    }
}

