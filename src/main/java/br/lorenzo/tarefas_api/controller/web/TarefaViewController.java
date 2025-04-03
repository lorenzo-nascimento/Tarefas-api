package br.lorenzo.tarefas_api.controller.web;

import br.lorenzo.tarefas_api.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/{id}/status")
    public String updateStatus(
            @PathVariable Long id,
            @RequestParam String status,
            RedirectAttributes redirectAttributes) {

        tarefaService.updateStatus(id, status);
        redirectAttributes.addFlashAttribute("success", "Status atualizado com sucesso!");
        return "redirect:/tarefas";
    }

    @PostMapping("/{id}/delete")
    public String deleteTarefa(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {

        tarefaService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Tarefa excluída com sucesso!");
        return "redirect:/tarefas";
    }

}

