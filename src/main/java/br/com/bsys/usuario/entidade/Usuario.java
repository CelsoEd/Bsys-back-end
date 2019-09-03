package br.com.bsys.usuario.entidade;

import br.com.bsys.usuario.util.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(nullable = false, length = 10)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = true)
    private TipoUsuario tipoUsuario;
}
