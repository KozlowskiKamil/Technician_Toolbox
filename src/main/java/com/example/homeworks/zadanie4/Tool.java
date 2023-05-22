package com.example.homeworks.zadanie4;

import java.util.ArrayList;
import java.util.List;

public class Tool {
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

    public record ToolSize(float size, String unit) {
    }
}