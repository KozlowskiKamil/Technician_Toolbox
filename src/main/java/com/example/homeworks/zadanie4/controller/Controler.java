package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.model.Tool;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

public class Controler {
    @GetMapping("model")
    public String getToolModel(@PathVariable String name,
                               @RequestParam Tool.ToolSize size, List<String> action,
                               Model model) {
        Tool tool = createTool(name, size, action);
        model.addAttribute("tool", tool);
        return "tool";
    }

    private Tool createTool(String name, Tool.ToolSize size, List<String> action) {
        Tool tool = new Tool();
        tool.setName(name);
        tool.setToolSize(size);
        tool.setActions(action);
        return tool;
    }

}
