package br.com.bsys.util.exception;

import br.com.bsys.util.Mensagem;

import javax.ws.rs.core.Response;

public class RestException extends Exception{

    private Response.Status status;
    private Mensagem mensagem;

    public RestException(Response.Status status, Mensagem mensagem) {
        super(mensagem.getMessagem());
        this.status = status;
        this.mensagem = mensagem;
    }

    public Response.Status getStatus() {
        return status;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }
}
