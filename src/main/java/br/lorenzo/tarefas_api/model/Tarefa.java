package br.lorenzo.tarefas_api.model;

import br.lorenzo.tarefas_api.model.enums.StatusTarefa;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    @NotBlank(message = "Titulo é obrigatório")
    @Size(max = 120, message = "Máximo de 120 caracteres")
    private String titulo;

    private String descricao;

    @FutureOrPresent(message = "Prazo deve ser futuro ou hoje")
    private LocalDateTime prazo;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status = StatusTarefa.PENDENTE;

}
