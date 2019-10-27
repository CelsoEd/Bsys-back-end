package br.com.bsys.util;


public enum Mensagem {
    EMAIL_OU_SENHA_INVALIDOS("E-mail ou senha inválidos."),
    ESSE_RECURSO_NAO_EXISTE("Esse recurso não existe."),
    SERVICO_NAO_CADASTRADO("Esse serviço não está cadastrado"),
    USUARIO_NAO_ENCONTRADO("Usuário não encontrado."),

    ERRO_CONVERSAO_JSON ("Erro na conversão de JSON");

    private String messagem;

    Mensagem(String messagem) {
        this.messagem = messagem;
    }

    public String getMessagem() {
        return messagem;
    }
}
