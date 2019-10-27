package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Servicos;
import br.com.bsys.util.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ServicoRequisicaoCadastroDTO implements DTO<Servicos> {

    @NotEmpty
    private String id;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private Double valor;

    @Override
    public Servicos paraObjeto() {

        Servicos servicos = new Servicos();
        servicos.setDescricao(this.descricao);
        servicos.setValor(this.valor);
        return servicos;
    }
}
