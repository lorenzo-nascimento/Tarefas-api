package br.lorenzo.tarefas_api.dto;

import java.util.List;

public record ErrorResponse(
        String message,
        List<String> details
) {
    public ErrorResponse(String message) {
        this(message, null);
    }
}
