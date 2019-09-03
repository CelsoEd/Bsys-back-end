package br.com.bsys.util.exception;

import br.com.bsys.util.Mensagem;

import javax.ws.rs.core.Response;

public class UnauthorizedException extends RestException{
    public UnauthorizedException(Mensagem mensagem) { super (Response.Status.UNAUTHORIZED, mensagem);}
}
