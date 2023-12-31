package com.example.homeworks.zadanie4.service;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.model.ToolUpdateDTO;

import java.util.List;

public interface ToolService {

    List<Tool> getTools();

    boolean isEmpty();

    boolean add(Tool tool);

    boolean edit(Tool tool, Long idL);

    List<Tool> findTool(String name);

    void delete(Long id);

    ToolUpdateDTO findById(Long id);

    boolean saveToolkit();
}
