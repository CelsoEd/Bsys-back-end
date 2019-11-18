package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.ClienteDAO;
import br.com.bsys.usuario.entidade.Cliente;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.GerarIdFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class ClienteDAOImp implements ClienteDAO {

    @Inject
    private GerarIdFactory gerarIdFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Cliente> procurarPorEmailESenha(String email, String senha) {
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Cliente.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insere(Cliente cliente) {
        cliente.setId(gerarIdFactory.gerarId());
        cliente.setTipoUsuario(TipoUsuario.CLIENTE);
        entityManager.persist(cliente);

    }

    @Override
    public Optional<Cliente> consultaPorId(String id) {
        return  Optional.ofNullable(entityManager.find(Cliente.class, id));
    }

    @Override
    public void alterar(Cliente cliente)
    {
        entityManager.merge(cliente);
    }
}
