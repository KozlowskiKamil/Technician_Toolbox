package com.example.homeworks.zadanie4.model;

import java.nio.file.Path;
import java.util.List;

public class ToolUpdateDTO {
    float size;
    String unit;
    private Long id;
    private String name;
    private final List<String> actions;
    private Path img;

    public ToolUpdateDTO(Long id, String name, float size, String unit, List<String> actions, Path img) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.unit = unit;
        this.actions = actions;
        this.img = img;
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


    public String getUnit() {
        return unit;
    }

    public List<String> getActions() {
        return actions;
    }


    public Path getImg() {
        return img;
    }

}
