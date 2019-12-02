package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.usuario.entidade.Endereco;
import br.com.bsys.usuario.util.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FreelancerDTO {

    private String id;

    private String nome;

    private String email;

    private String senha;

    private TipoUsuario tipoUsuario;

    private String telefone;

    private String telefone2;

    private String descricaoPerfil;

    private Endereco endereco;

    private String cpf;

    private List<ServicoDTO> servicos;

    public FreelancerDTO(Freelancer freelancer) {
        this.id = freelancer.getId();
        this.nome = freelancer.getNome();
        this.email = freelancer.getEmail();
        this.senha = freelancer.getSenha();
        this.tipoUsuario = freelancer.getTipoUsuario();
        this.telefone = freelancer.getTelefone();
        this.telefone2 = freelancer.getTelefone2();
        this.descricaoPerfil = freelancer.getDescricaoPerfil();
        this.endereco = freelancer.getEndereco();
        this.cpf = freelancer.getCpf();
        this.servicos = freelancer.getServicos().stream().map(ServicoDTO::new).collect(Collectors.toList());
    }

}
