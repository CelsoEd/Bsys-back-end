package br.com.bsys.util.exception;

import br.com.bsys.util.Mensagem;

public class InfraestruturaException extends Exception {

    private static final long serialVersionUID = 1L;

    private final Mensagem mensagem;

    public InfraestruturaException(Mensagem mensagem) {
        super(mensagem.getMessagem());
        this.mensagem = mensagem;
    }

    public Mensagem getMensagem() {
        return this.mensagem;
    }

}
