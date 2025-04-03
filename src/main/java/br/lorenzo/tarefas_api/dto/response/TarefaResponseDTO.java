package br.lorenzo.tarefas_api.dto.response;

import br.lorenzo.tarefas_api.model.enums.StatusTarefa;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime prazo;
    private StatusTarefa status;
}
