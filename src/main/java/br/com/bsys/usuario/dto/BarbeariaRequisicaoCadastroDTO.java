package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Barbearia;
import br.com.bsys.usuario.entidade.Endereco;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BarbeariaRequisicaoCadastroDTO implements DTO<Barbearia> {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String senha;

    private String cnpj;

    private String telefone;

    private String telefone2;

    private String descricaoPerfil;

    private String cep;

    private String numero;

    private String complemento;

    private String estado;

    private String cidade;

    private String logradouro;

    private String bairro;

    @Override
    public Barbearia paraObjeto() {
        Barbearia barbearia = new Barbearia();
        barbearia.setNome(this.nome);
        barbearia.setEmail(this.email);
        barbearia.setSenha(this.senha);
        barbearia.setCnpj(this.cnpj);
        barbearia.setTelefone(this.telefone);
        barbearia.setTelefone2(this.telefone2);
        barbearia.setDescricaoPerfil(this.descricaoPerfil);

        Endereco endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        endereco.setUf(this.estado);
        endereco.setLogradouro(this.logradouro);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);

        barbearia.setEndereco(endereco);

        return barbearia;
    }
}
