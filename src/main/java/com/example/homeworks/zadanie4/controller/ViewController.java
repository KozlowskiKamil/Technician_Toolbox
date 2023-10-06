package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.model.ToolUpdateDTO;
import com.example.homeworks.zadanie4.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

@Controller
public class ViewController {
    private final ToolService toolService;
    List<Tool> searchTool;

    @Autowired
    public ViewController(ToolService toolService) {
        this.toolService = toolService;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Tool theTool = new Tool();
        model.addAttribute("tool", theTool);
        return "create";
    }

    @PostMapping("/create")
    public String add(@RequestParam String name, @RequestParam String location, @RequestParam float size,
                      @RequestParam String unit, @RequestParam("actions") List<String> actions,
                      Model model) {
        Tool newTool = new Tool(name, location, new Tool.ToolSize(size, unit), actions,
                Path.of("/img/noImg.png")); // TODO: 02.06.2023 Add img drop
        toolService.add(newTool);
        List<Tool> tools = toolService.getTools();
        model.addAttribute("tools", tools);
        return "create";
    }

    @GetMapping("/")
    public String getTools(Model model) {
        List<Tool> tools = toolService.getTools();
        tools.sort(Comparator.comparing(Tool::getId));
        model.addAttribute("tools", tools);
        return "index";
    }

    @GetMapping("/update/{id}")
    String updateGet(@PathVariable("id") String id, Model model) {
        Long idL = Long.valueOf(id);
        ToolUpdateDTO toolUpdateDTO = toolService.findById(idL);
        model.addAttribute("toolUpdateDTO", toolUpdateDTO);
        return "update";
    }

    @PostMapping("/update/{id}")
    String updatePost(@PathVariable("id") String id,
                      @RequestParam("actions") List<String> actions,
                      @ModelAttribute ToolUpdateDTO toolDto) {
        Long idL = Long.valueOf(id);
        toolService.delete(idL);
        Tool.ToolSize toolSize = new Tool.ToolSize(toolDto.getSize(), toolDto.getUnit());
        Tool tool = new Tool(toolDto.getName(), toolDto.getLocation(), toolSize, actions, toolDto.getImg());
        toolService.edit(tool, idL);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        toolService.delete(id);
        return "redirect:/";
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