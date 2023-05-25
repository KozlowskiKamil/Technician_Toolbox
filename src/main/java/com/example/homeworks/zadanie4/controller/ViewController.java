package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
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

    @Autowired // Dodaję aby było wiadomo gdzie jest DI choć wiadomo, że nie jest wymagana przy konstruktorze
    public ViewController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/read")
    public String getTools(Model model) {
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "read";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }

    @GetMapping("/delete")
    public String delete() {
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") Long id) {
        toolService.delete(id);
        return "delete";
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

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam float size, @RequestParam String unit,
                         @RequestParam("actions") List<String> actions, Model model) {
        Tool newTool = new Tool(name, new Tool.ToolSize(size, unit), actions);
        toolService.add(newTool);
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "create";
    }

    @PostMapping("/update")
    public String update(@RequestParam String name, @RequestParam float size, @RequestParam String unit,
                         @RequestParam("actions") List<String> actions, Model model) {
        Tool newTool = new Tool(name, new Tool.ToolSize(size, unit), actions);
        toolService.add(newTool);
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "update";
    }

}