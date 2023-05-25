package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewController {

    private final ToolService toolService;

    List<Tool> searchTool;

    @Autowired // Dodaję aby było wiadomo gdzie jest DI choć wiadomo, że nie jest wymagana przy konstruktorze
    public ViewController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/read")
    public String getTools(Model model) {
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "read";
    }

    @PostMapping("/showFormForAddp")
    public String showFormForAddp(Model model) {
        Tool theTool = new Tool();
        model.addAttribute("tool", theTool);
        return "create";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Tool theTool = new Tool();
        model.addAttribute("tool", theTool);
        return "create";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") Long id, Model theModel) {
        Tool tool = toolService.findById(id);
        theModel.addAttribute("tool", tool);
        return "create";
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