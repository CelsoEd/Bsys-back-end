package br.com.bsys.usuario.service;


import br.com.bsys.usuario.entidade.Usuario;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Sessao {

    protected Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }
}
