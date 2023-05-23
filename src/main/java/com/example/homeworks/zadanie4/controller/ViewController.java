package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.service.ToolkitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {

    private final ToolkitRepository toolkitRepository;

    @Autowired // Dodaję aby było wiadomo gdzie jest DI choć wiadomo, że nie jest wymagana przy konstruktorze
    public ViewController(ToolkitRepository toolkitRepository) {
        this.toolkitRepository = toolkitRepository;
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/read")
    public String getTools(Model model) {
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "read";
    }

    @PostMapping("/create")
    public String add(@RequestParam String name, @RequestParam float size, @RequestParam String unit,
                      @RequestParam("actions") List<String> actions, Model model) {
        Tool newTool = new Tool(name, new Tool.ToolSize(size, unit), actions);
        toolkitRepository.add(newTool);
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "create";
    }


}
