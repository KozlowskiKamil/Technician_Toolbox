package com.example.homeworks.zadanie4.model;

import java.util.List;

public class ToolUpdateDTO {
    float size;
    String unit;
    private Long id;
    private String name;
    private List<String> actions;

    public ToolUpdateDTO(Long id, String name, float size, String unit, List<String> actions) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.unit = unit;
        this.actions = actions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

}