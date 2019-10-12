package br.com.bsys.usuario.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario {

    @Column
    private String cpf;

    @Column
    private String telefone;

//    @OneToOne
//    private Endereco endereco;


}
