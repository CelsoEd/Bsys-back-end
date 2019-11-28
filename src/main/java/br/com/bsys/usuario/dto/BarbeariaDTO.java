package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Endereco;
import br.com.bsys.usuario.util.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BarbeariaDTO {

    private String id;

    private String nome;

    private String email;

    private String senha;

    private TipoUsuario tipoUsuario;

    private String telefone;

    private String telefone2;

    private String descricaoPerfil;

    private Endereco endereco;

    private String cnpj;

    private List<ServicoDTO> servicos;

    public BarbeariaDTO(Barbearia barbearia) {
        this.id = barbearia.getId();
        this.nome = barbearia.getNome();
        this.email = barbearia.getEmail();
        this.senha = barbearia.getSenha();
        this.tipoUsuario = barbearia.getTipoUsuario();
        this.telefone = barbearia.getTelefone();
        this.telefone2 = barbearia.getTelefone2();
        this.descricaoPerfil = barbearia.getDescricaoPerfil();
        this.endereco = barbearia.getEndereco();
        this.cnpj = barbearia.getCnpj();
        this.servicos = barbearia.getServicos().stream().map(ServicoDTO::new).collect(Collectors.toList());
    }

}
