package com.example.homeworks.zadanie4.service;

import com.example.homeworks.zadanie4.model.Tool;

import java.util.List;

public interface ToolService {

    List<Tool> getTools();

    boolean isEmpty();

    boolean add(Tool tool);

    List<Tool> findTool(String name);

    Long delete(Long id);

    Tool findById(Long id);

    boolean saveToolkit();
}