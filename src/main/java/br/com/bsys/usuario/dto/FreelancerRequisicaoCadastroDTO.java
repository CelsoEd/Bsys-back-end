package br.com.bsys.usuario.dto;

import br.com.bsys.usuario.entidade.Endereco;
import br.com.bsys.usuario.entidade.Freelancer;
import br.com.bsys.util.DTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class FreelancerRequisicaoCadastroDTO implements DTO<Freelancer> {

    @NotEmpty
    private String nome;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String senha;

    private String cpf;

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
    public Freelancer paraObjeto() {
        Freelancer freelancer = new Freelancer();
        freelancer.setNome(this.nome);
        freelancer.setEmail(this.email);
        freelancer.setSenha(this.senha);
        freelancer.setCpf(this.cpf);
        freelancer.setTelefone(this.telefone);
        freelancer.setTelefone2(this.telefone2);
        freelancer.setDescricaoPerfil(this.descricaoPerfil);

        Endereco endereco = new Endereco();
        endereco.setCep(this.cep);
        endereco.setNumero(this.numero);
        endereco.setComplemento(this.complemento);
        endereco.setLogradouro(this.logradouro);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);

        freelancer.setEndereco(endereco);

        return freelancer;
    }

}
