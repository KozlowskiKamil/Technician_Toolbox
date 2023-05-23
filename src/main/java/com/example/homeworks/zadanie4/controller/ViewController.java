package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.service.ToolkitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ViewController {

    private final ToolkitRepository toolkitRepository;

    public ViewController(ToolkitRepository toolkitRepository) {
        this.toolkitRepository = toolkitRepository;
    }

    @GetMapping("/")
    public String getTools(Model model) {
        List<Tool> tools = toolkitRepository.getTools();
        model.addAttribute("tools", tools);
        return "index";
    }

}
