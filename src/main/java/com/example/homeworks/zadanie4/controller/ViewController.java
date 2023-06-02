package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.model.ToolUpdateDTO;
import com.example.homeworks.zadanie4.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewController {

    private final ToolService toolService;

    List<Tool> searchTool;

    @Autowired // Dodaję aby pokazać gdzie jest DI choć wiadomo, że nie jest wymagana przy konstruktorze
    public ViewController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Tool theTool = new Tool();
        model.addAttribute("tool", theTool);
        return "create";
    }

    @PostMapping("/create")
    public String add(@RequestParam String name, @RequestParam float size, @RequestParam String unit, @RequestParam("actions") List<String> actions, Model model) {
        Tool newTool = new Tool(name, new Tool.ToolSize(size, unit), actions);
        toolService.add(newTool);
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "create";
    }

    @GetMapping("/read")
    public String getTools(Model model) {
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "read";
    }

    @GetMapping("/update/{id}")
    String updateGet(@PathVariable("id") String id, Model model) {
        Long idL = Long.valueOf(id);
        ToolUpdateDTO toolUpdateDTO = toolService.findById(idL);
        model.addAttribute("toolUpdateDTO", toolUpdateDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    String updatePost(@PathVariable("id") String id, @RequestParam("actions") List<String> actions, @ModelAttribute ToolUpdateDTO toolDto) {
        Long idL = Long.valueOf(id);
        toolService.delete(idL);
        Tool.ToolSize toolSize = new Tool.ToolSize(toolDto.getSize(), toolDto.getUnit());
        Tool tool = new Tool(toolDto.getName(), toolSize, actions);
        toolService.add(tool);
        return "redirect:/read";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        toolService.delete(id);
        return "redirect:/read";
    }

    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/findTool")
    public String findTool(@RequestParam("name") String name, Model model) {
        searchTool = toolService.findTool(name);
        model.addAttribute("searchResults", searchTool);
        return "search";
    }

}