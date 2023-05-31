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

    @PostMapping("/updateTool")
    public String updateTool(@RequestParam("id") Long id, @RequestParam("name") String name) {
        Tool existingTool = toolService.findById(id);
        existingTool.setName(name);
        toolService.saveToolkit();
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

    @PostMapping("/create")
    public String add(@RequestParam String name, @RequestParam float size, @RequestParam String unit,
                      @RequestParam("actions") List<String> actions, Model model) {
        Tool newTool = new Tool(name, new Tool.ToolSize(size, unit), actions);
        toolService.add(newTool);
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "create";
    }

//    @PostMapping("/updateTool")
//    public String updateTool(@RequestParam("id") Long id, @RequestParam("name") String name,
//                             @RequestParam("size") float size, @RequestParam("unit") String unit,
//                             @RequestParam("actions") List<String> actions) {
//        Tool existingTool = toolService.findById(id);
//        existingTool.setName(name);
//        existingTool.setToolSize(new Tool.ToolSize(size, unit));
//        existingTool.setActions(actions);
//        toolService.saveToolkit();
//        return "redirect:/read";
//    }
}