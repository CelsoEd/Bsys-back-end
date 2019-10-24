package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Agendamento;
import br.com.bsys.usuario.util.Status;
import br.com.bsys.util.DTO;

import java.time.LocalDateTime;


public class AgendamentoRequisicaoCadastroDTO implements DTO<Agendamento> {

    private LocalDateTime dataHora;

    private Status status;

    @Override
    public Agendamento paraObjeto() {

        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(this.dataHora);
        agendamento.setStatus(this.status);
        return agendamento;
    }
}
