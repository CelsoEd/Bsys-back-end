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

    private String cep;

    private String numero;

    private String complemento;

    private String uf;

    private String cidade;

    @Override
    public Barbearia paraObjeto() {
        Barbearia barbearia = new Barbearia();
        barbearia.setNome(this.nome);
        barbearia.setEmail(this.email);
        barbearia.setSenha(this.senha);
        barbearia.setCnpj(this.cnpj);
        barbearia.setTelefone(this.telefone);

        Endereco endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        endereco.setUf(this.uf);
        endereco.setCidade(this.cidade);

        barbearia.setEndereco(endereco);

        return barbearia;
    }
}
