package com.example.homeworks.zadanie4.model;

import java.nio.file.Path;
import java.util.List;

public class ToolUpdateDTO {
    private final List<String> actions;
    float size;
    String unit;
    private String location;
    private Long id;
    private String name;
    private Path img;

    public ToolUpdateDTO(Long id, String name, float size, String unit, List<String> actions, Path img) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.unit = unit;
        this.actions = actions;
        this.img = img;
    }

    public ToolUpdateDTO(List<String> actions, float size, String unit, String location, Long id, String name, Path img) {
        this.actions = actions;
        this.size = size;
        this.unit = unit;
        this.location = location;
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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