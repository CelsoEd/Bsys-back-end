package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.ClienteDAO;
import br.com.bsys.usuario.entidade.Cliente;
import br.com.bsys.usuario.util.CriptografiaSenha;
import br.com.bsys.util.Mensagem;
import br.com.bsys.util.exception.NotFoundException;
import br.com.bsys.util.exception.UnauthorizedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;

@Stateless
public class ClienteService {

    @Inject
    private ClienteDAO dao;

    @Inject
    private CriptografiaSenha criptografiaSenha;

    public Cliente procurarPorEmailESenha(String email, String senha) throws UnauthorizedException, NoSuchAlgorithmException {
        return dao.procurarPorEmailESenha(email, criptografiaSenha.criptografar(email, senha))
                .orElseThrow(() -> new UnauthorizedException(Mensagem.EMAIL_OU_SENHA_INVALIDOS));
    }

    public void novo(Cliente cliente) throws NoSuchAlgorithmException {
        cliente.setSenha(criptografiaSenha.criptografar(cliente.getEmail(), cliente.getSenha()));
        dao.insere(cliente);
    }

    public Cliente consultaPorId(String id) throws NotFoundException {
        return dao.consultaPorId(id).orElseThrow(() -> new NotFoundException(Mensagem.USUARIO_NAO_ENCONTRADO));
    }

    public void alterar(Cliente cliente){
        dao.alterar(cliente);
    }

}
