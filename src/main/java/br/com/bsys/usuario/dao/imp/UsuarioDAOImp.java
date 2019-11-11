package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.UsuarioDAO;
import br.com.bsys.usuario.entidade.Usuario;
import br.com.bsys.util.GerarIdFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class UsuarioDAOImp implements UsuarioDAO {

    @Inject
    private GerarIdFactory gerarIdFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Usuario> procurarPorEmailESenha(String email, String senha) {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insere(Usuario usuario) {
        usuario.setId(gerarIdFactory.gerarId());
        entityManager.persist(usuario);
    }

    @Override
    public Optional<Usuario> consultaPorId(String id) {
        return Optional.empty();
    }

    @Override
    public void alteraUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
}
