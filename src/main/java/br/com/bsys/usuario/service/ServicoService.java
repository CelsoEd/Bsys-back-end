package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.ServicoDAO;
import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.util.Mensagem;
import br.com.bsys.util.exception.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ServicoService {

    @Inject
    private ServicoDAO servicoDAO;

    @EJB
    private BarbeariaService barbeariaService;

    @EJB
    private FreelancerService freelancerService;

    public Servicos consultaPorId(int id) throws NotFoundException{
        return servicoDAO.buscaPorId(id).orElseThrow(() -> new NotFoundException(Mensagem.SERVICO_NAO_CADASTRADO));
    }

    public void novoServicoBarbearia(String id, Servicos servico) throws NotFoundException {
        Barbearia barbearia = barbeariaService.consultaPorId(id);
        servico.setBarbearia(barbearia);
        servicoDAO.servicoBarbearia(servico);
    }

    public void novoServicoFreelancer(String id, Servicos servico) throws NotFoundException {
        Freelancer freelancer = freelancerService.consultaPorId(id);
        servico.setFreelancer(freelancer);
        servicoDAO.servicoBarbearia(servico);
    }
}

