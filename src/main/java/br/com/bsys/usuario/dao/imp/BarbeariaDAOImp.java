package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.BarbeariaDAO;
import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.usuario.entidade.Usuario;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.GerarIdFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BarbeariaDAOImp implements BarbeariaDAO {

    @Inject
    private GerarIdFactory gerarIdFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Barbearia> procurarPorEmailESenha(String email, String senha) {
        TypedQuery<Barbearia> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Barbearia.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insere(Barbearia barbearia) {
        barbearia.setId(gerarIdFactory.gerarId());
        barbearia.setTipoUsuario(TipoUsuario.BARBEARIA);
        entityManager.persist(barbearia);

    }

    @Override
    public Optional<Usuario> consultaPorId(String id) {

////        entityManager.getTransaction().begin();
//
//        Usuario usuario = entityManager.find(Barbearia.class, id);
//        entityManager.getTransaction().commit();
//
//
////        usuario =  query.getSingleResult();
//
//        return usuario;
//
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :id", Usuario.class);
        query.setParameter("id", id);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


    @Override
    public void insereServico(Barbearia barbearia, Servicos servicos) {
        barbearia.setServicos((List<Servicos>) servicos);
        entityManager.persist(barbearia);
    }
}
