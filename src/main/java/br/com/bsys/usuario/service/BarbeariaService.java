package br.com.bsys.usuario.service;

import br.com.bsys.usuario.dao.BarbeariaDAO;
import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.usuario.entidade.Usuario;
import br.com.bsys.usuario.util.CriptografiaSenha;
import br.com.bsys.util.Mensagem;
import br.com.bsys.util.exception.NotFoundException;
import br.com.bsys.util.exception.UnauthorizedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Stateless
public class BarbeariaService {

    @Inject
    private BarbeariaDAO dao;

    @Inject
    private CriptografiaSenha criptografiaSenha;

    public Barbearia procurarPorEmailESenha(String email, String senha) throws UnauthorizedException, NoSuchAlgorithmException {
        return dao.procurarPorEmailESenha(email, criptografiaSenha.criptografar(email, senha))
                .orElseThrow(() -> new UnauthorizedException(Mensagem.EMAIL_OU_SENHA_INVALIDOS));
    }

    public void novo(Barbearia barbearia) throws NoSuchAlgorithmException {
        barbearia.setSenha(criptografiaSenha.criptografar(barbearia.getEmail(), barbearia.getSenha()));
        dao.insere(barbearia);
    }

    public Barbearia consultaPorId(String id) throws NotFoundException {
        return dao.consultaPorId(id).orElseThrow(() -> new NotFoundException(Mensagem.USUARIO_NAO_ENCONTRADO));
    }

    public List<Barbearia> listarTodas() throws NotFoundException {
        List<Barbearia> barbearias = dao.listarTodas();
        if(barbearias.isEmpty()){
            throw new NotFoundException(Mensagem.BARBEARIAS_NAO_CADASTRADAS);
        }
        return barbearias;
    }


//    public void novoServico(String id,Servicos servicos) throws NotFoundException {
//        dao.insereServico((Barbearia) consultaPorId(id),servicos);
//    }

}
