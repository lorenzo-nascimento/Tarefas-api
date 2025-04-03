package br.lorenzo.tarefas_api.controller.api;

import br.lorenzo.tarefas_api.dto.request.TarefaRequestDTO;
import br.lorenzo.tarefas_api.dto.response.TarefaResponseDTO;
import br.lorenzo.tarefas_api.service.TarefaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaResponseDTO create(@Valid @RequestBody TarefaRequestDTO request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public TarefaResponseDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<TarefaResponseDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/refresh")
    public List<TarefaResponseDTO> refresh() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public TarefaResponseDTO update(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

} // FIM DA CLASSE