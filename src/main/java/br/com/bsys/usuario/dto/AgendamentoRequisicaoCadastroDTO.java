package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Agendamento;
import br.com.bsys.usuario.util.Status;
import br.com.bsys.util.DTO;
import br.com.bsys.util.exception.InfraestruturaException;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoRequisicaoCadastroDTO implements DTO<Agendamento> {

    @NotEmpty
    private String idCliente;

    @NotEmpty
    private int idServico;

    @NotEmpty
    private LocalDateTime dataHora;

    private Status status;

    @Override
    public Agendamento paraObjeto() throws InfraestruturaException {

        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(dataHora);
        if (this.status != null) {
            agendamento.setStatus(this.status);
        }
        return agendamento;
    }
}
