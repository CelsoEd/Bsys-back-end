package br.com.bsys.usuario.dao.imp;

import br.com.bsys.usuario.dao.BarbeariaDAO;
import br.com.bsys.usuario.entidade.Barbearia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class BarbeariaDAOImp implements BarbeariaDAO {

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

    }

    @Override
    public Optional<Barbearia> consultaPorId(String id) {
        return Optional.empty();
    }
}
