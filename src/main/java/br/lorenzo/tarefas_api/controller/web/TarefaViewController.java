package br.lorenzo.tarefas_api.controller.web;

import br.lorenzo.tarefas_api.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tarefas")
public class TarefaViewController {

    private final TarefaService tarefaService;

    public TarefaViewController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public String listarTarefas(Model model) {
        model.addAttribute("tarefas", tarefaService.getAll());
        return "tarefas/list";
    }
}