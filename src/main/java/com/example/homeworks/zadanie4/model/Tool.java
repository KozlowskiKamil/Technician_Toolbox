package com.example.homeworks.zadanie4.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tool {
    private Long id;
    private String name;
    private ToolSize toolSize;
    private List<String> actions;

    @SuppressWarnings("Needed to load json file")
    public Tool() {
    }

    public Tool(String name, ToolSize size, List<String> actions) {
        this.name = name;
        this.toolSize = size;
        this.actions = actions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getActions() {
        return actions;
    }

    public void addAction(String action) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }
        this.actions.add(action);
    }

    public String getName() {
        return name;
    }


    public ToolSize getToolSize() {
        return toolSize;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToolSize(ToolSize toolSize) {
        this.toolSize = toolSize;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public record ToolSize(float size, String unit) {
    }
}