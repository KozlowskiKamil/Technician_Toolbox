package com.example.homeworks.zadanie4.model;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class Tool {
    private Long id;
    private String name;
    private ToolSize toolSize;
    private List<String> actions;
    private Path img;

    @SuppressWarnings("Needed to load json file")
    public Tool() {
    }

    public Tool(String name, ToolSize size, List<String> actions, Path img) {
        this.name = name;
        this.toolSize = size;
        this.actions = actions;
        this.img = img;
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

    public void setName(String name) {
        this.name = name;
    }

    public ToolSize getToolSize() {
        return toolSize;
    }

    public Path getImg() {
        return img;
    }

    public record ToolSize(float size, String unit) {
    }
}