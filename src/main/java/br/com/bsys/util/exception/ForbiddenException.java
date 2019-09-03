package br.com.bsys.util.exception;

import br.com.bsys.util.Mensagem;

import javax.ws.rs.core.Response;

public class ForbiddenException extends RestException{
    public ForbiddenException(Mensagem mensagem) {
        super(Response.Status.FORBIDDEN, mensagem);
    }
}
