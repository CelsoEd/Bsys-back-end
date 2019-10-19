package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.FreelancerDAO;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.GerarIdFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class FreelancerDAOImp implements FreelancerDAO {

    @Inject
    private GerarIdFactory gerarIdFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Freelancer> procurarPorEmailESenha(String email, String senha) {
        TypedQuery<Freelancer> query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Freelancer.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try {
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insere(Freelancer freelancer) {
        freelancer.setId(gerarIdFactory.gerarId());
        freelancer.setTipoUsuario(TipoUsuario.FREELANCER);
        entityManager.persist(freelancer);

    }

    @Override
    public Optional<Freelancer> consultaPorId(String id) {
        return Optional.ofNullable(entityManager.find(Freelancer.class, id));
    }

}
