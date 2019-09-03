package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.UsuarioDAO;
import br.com.bsys.usuario.entidade.Usuario;
import br.com.bsys.usuario.util.CriptografiaSenha;
import br.com.bsys.util.Mensagem;
import br.com.bsys.util.exception.NotFoundException;
import br.com.bsys.util.exception.UnauthorizedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioDAO dao;

    @Inject
    private CriptografiaSenha criptografiaSenha;

    public Usuario procurarPorEmailESenha(String email, String senha) throws UnauthorizedException, NoSuchAlgorithmException {
        return dao.procurarPorEmailESenha(email, criptografiaSenha.criptografar(email, senha))
                .orElseThrow(() -> new UnauthorizedException(Mensagem.EMAIL_OU_SENHA_INVALIDOS));
    }

    public void novo(Usuario usuario) throws NoSuchAlgorithmException {
        usuario.setSenha(criptografiaSenha.criptografar(usuario.getEmail(), usuario.getSenha()));
        dao.insere(usuario);
    }

    public Usuario consultaPorId(String id) throws NotFoundException {
        return dao.consultaPorId(id).orElseThrow(() -> new NotFoundException(Mensagem.USUARIO_NAO_ENCONTRADO));
    }

}
