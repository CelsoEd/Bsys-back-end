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

    private int idServico;

//    private String idBarbearia;
//
//    private String idFreelancer;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private Double valor;

    @Override
    public Servicos paraObjeto() {

        Servicos servicos = new Servicos();
        if (this.getIdServico() != 0){
            servicos.setId(this.idServico);
        }
//        if (this.getIdBarbearia() != null){
//            servicos.setBarbearia(this.idBarbearia);
//        }
//        if (this.getIdServico() != 0){
//            servicos.setId(this.idServico);
//        }
        servicos.setNome(this.nome);
        servicos.setDescricao(this.descricao);
        servicos.setValor(this.valor);
        return servicos;
    }
}
