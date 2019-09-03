package br.com.bsys.util.exception;

import br.com.bsys.util.Mensagem;

import javax.ws.rs.core.Response;

public class NotFoundException extends RestException{
    public NotFoundException(Mensagem mensagem){ super(Response.Status.NOT_FOUND, mensagem);}
}
