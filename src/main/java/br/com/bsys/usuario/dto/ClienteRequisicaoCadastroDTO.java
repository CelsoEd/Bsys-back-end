package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Cliente;
import br.com.bsys.usuario.entidade.Endereco;
import br.com.bsys.usuario.util.TipoUsuario;
import br.com.bsys.util.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ClienteRequisicaoCadastroDTO implements DTO<Cliente> {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String senha;

    private TipoUsuario tipoUsuario;

    private String cpf;

    private String telefone;

    private String telefone2;

    private String descricaoPerfil;

    private String cep;

    private String numero;

    private String complemento;

    private String logradouro;

    private String bairro;

    private String estado;

    private String cidade;

    @Override
    public Cliente paraObjeto() {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setSenha(this.senha);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setTelefone2(this.telefone2);
        cliente.setDescricaoPerfil(this.descricaoPerfil);
        endereco.setCep(this.cep);
        endereco.setCidade(this.cidade);
        endereco.setComplemento(this.complemento);
        endereco.setNumero(this.numero);
        endereco.setUf(this.estado);
        endereco.setLogradouro(this.logradouro);
        endereco.setBairro(this.bairro);
        cliente.setEndereco(endereco);
        return cliente;
    }
}
