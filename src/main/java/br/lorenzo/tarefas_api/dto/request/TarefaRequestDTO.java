package br.lorenzo.tarefas_api.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaRequestDTO {

    @NotBlank(message = "Título é obrigatório")
    @Size(max = 120, message = "Máximo de 120 caracteres")
    private String titulo;

    @Size(max = 500, message = "Máximo de 500 caracteres")
    private String descricao;

    @FutureOrPresent(message = "Prazo deve ser uma data futura ou presente")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime prazo;
}
