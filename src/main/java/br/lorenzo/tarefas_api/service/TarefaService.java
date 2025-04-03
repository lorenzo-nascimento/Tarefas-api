package br.lorenzo.tarefas_api.service;

import br.lorenzo.tarefas_api.dto.request.TarefaRequestDTO;
import br.lorenzo.tarefas_api.dto.response.TarefaResponseDTO;
import br.lorenzo.tarefas_api.model.Tarefa;
import br.lorenzo.tarefas_api.repository.TarefaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TarefaService {

    private final TarefaRepository repository;
    private final ModelMapper modelMapper;

    public TarefaService(TarefaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public TarefaResponseDTO create(TarefaRequestDTO request) {
        Tarefa task = modelMapper.map(request, Tarefa.class);
        Tarefa savedTask = repository.save(task);
        return modelMapper.map(savedTask, TarefaResponseDTO.class);
    }

    @Transactional(readOnly = true)
    public List<TarefaResponseDTO> getAll() {
        entityManager.clear();
        return repository.findAll().stream()
                .map(tarefa -> modelMapper.map(tarefa, TarefaResponseDTO.class))
                .toList();
    }

    @Transactional(readOnly = true)
    public TarefaResponseDTO getById(Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));
        return modelMapper.map(tarefa, TarefaResponseDTO.class);
    }

    @Transactional
    public TarefaResponseDTO update(Long id, TarefaRequestDTO request) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

        modelMapper.map(request, tarefa);
        Tarefa tarefaAtualizada = repository.save(tarefa);

        return modelMapper.map(tarefaAtualizada, TarefaResponseDTO.class);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Tarefa não encontrada");
        }
        repository.deleteById(id);
    }


}