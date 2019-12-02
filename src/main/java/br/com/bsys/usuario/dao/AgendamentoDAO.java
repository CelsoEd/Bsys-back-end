package br.com.bsys.usuario.dao;

import br.com.bsys.usuario.entidade.Agendamento;

public interface AgendamentoDAO {

    void insere(Agendamento agendamento);

    void confirmar(int id);

    void cancelar(int id);

}
