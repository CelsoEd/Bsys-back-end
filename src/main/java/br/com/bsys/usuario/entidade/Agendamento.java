package br.com.bsys.usuario.entidade;

import br.com.bsys.usuario.util.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime dataHora;

    @Column
    private Status status;

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Servicos servicos;

    public Agendamento(LocalDateTime dataHora, Status status){
        this.dataHora = dataHora;
        this.status = status;
    }
    public Agendamento(Status status){
        this.dataHora = dataHora;
        this.status = status;
    }




}
