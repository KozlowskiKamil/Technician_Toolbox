package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.service.ToolkitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewController {

    private final ToolkitRepository toolkitRepository;

    List<Tool> searchTool;

    @Autowired // Dodaję aby było wiadomo gdzie jest DI choć wiadomo, że nie jest wymagana przy konstruktorze
    public ViewController(ToolkitRepository toolkitRepository) {
        this.toolkitRepository = toolkitRepository;
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
        List<Tool> tools = toolkitRepository.getTools();
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
        toolkitRepository.delete(id);
        return "delete";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") Long id) {
        toolkitRepository.delete(id);
        toolkitRepository.getTools().get(Math.toIntExact(id)).setName("aaaaaaaaa");

        return "update";
    }



    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/findTool")
    public String findTool(@RequestParam("name") String name, Model model) {
        searchTool = toolkitRepository.findTool(name);
        model.addAttribute("searchResults", searchTool);
        return "search";
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
