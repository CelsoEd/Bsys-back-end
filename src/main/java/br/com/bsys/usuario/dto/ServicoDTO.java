package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Servicos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ServicoDTO {

    private int id;

    private String nome;

    private String descricao;

    private Double valor;

    private List<AgendamentoDTO> agendamento;

    public ServicoDTO(Servicos servicos) {
        this.id = servicos.getId();
        this.nome = servicos.getNome();
        this.descricao = servicos.getDescricao();
        this.valor = servicos.getValor();
        this.agendamento = servicos.getAgendamento().stream().map(AgendamentoDTO::new).collect(Collectors.toList());
    }

}
