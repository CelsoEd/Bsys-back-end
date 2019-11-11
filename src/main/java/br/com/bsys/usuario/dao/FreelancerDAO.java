package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Freelancer;

import java.util.List;
import java.util.Optional;

public interface FreelancerDAO {

    Optional<Freelancer> procurarPorEmailESenha(String email, String senha);

    void insere(Freelancer freelancer);

    Optional<Freelancer> consultaPorId(String id);

    List<Freelancer> listarTodos();


}
