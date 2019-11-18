package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.FreelancerDAO;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.util.CriptografiaSenha;
import br.com.bsys.util.Mensagem;
import br.com.bsys.util.exception.NotFoundException;
import br.com.bsys.util.exception.UnauthorizedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Stateless
public class FreelancerService {

    @Inject
    private FreelancerDAO dao;

    @Inject
    private CriptografiaSenha criptografiaSenha;

    public Freelancer procurarPorEmailESenha(String email, String senha) throws UnauthorizedException, NoSuchAlgorithmException {
        return dao.procurarPorEmailESenha(email, criptografiaSenha.criptografar(email, senha))
                .orElseThrow(() -> new UnauthorizedException(Mensagem.EMAIL_OU_SENHA_INVALIDOS));
    }

    public void novo(Freelancer freelancer) throws NoSuchAlgorithmException {
        freelancer.setSenha(criptografiaSenha.criptografar(freelancer.getEmail(), freelancer.getSenha()));
        dao.insere(freelancer);
    }

    public Freelancer consultaPorId(String id) throws NotFoundException {
        return dao.consultaPorId(id).orElseThrow(() -> new NotFoundException(Mensagem.USUARIO_NAO_ENCONTRADO));
    }

    public List<Freelancer> listarTodos() throws NotFoundException {
        List<Freelancer> barbearias = dao.listarTodos();
        if(barbearias.isEmpty()){
            throw new NotFoundException(Mensagem.FREELANCERS_NAO_CADASTRADOS);
        }
        return barbearias;
    }

    public void alterar(Freelancer freelancer){
        dao.alterar(freelancer);
    }

}
