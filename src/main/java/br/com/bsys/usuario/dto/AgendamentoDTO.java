package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Agendamento;
import br.com.bsys.usuario.util.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoDTO {

    private int id;

    private String idCliente;

    private LocalDateTime dataHora;

    private Status status;

    public AgendamentoDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.dataHora = agendamento.getDataHora();
        this.status = agendamento.getStatus();
        this.idCliente = agendamento.getCliente().getId();
    }

}
