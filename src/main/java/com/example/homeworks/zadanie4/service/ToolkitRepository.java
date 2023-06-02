package com.example.homeworks.zadanie4.service;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.model.ToolUpdateDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ToolkitRepository implements ToolService {

    private final List<Tool> tools;

    public ToolkitRepository() {
        tools = readToolkit();
    }

    @Override
    public List<Tool> getTools() {
        return new ArrayList<>(tools);
    }

    @JsonIgnore
    @Override
    public boolean isEmpty() {
        return tools.isEmpty();
    }

    @Override
    public boolean add(Tool tool) {
        int nextId = tools.size() + 1;
        tool.setId(Long.valueOf(nextId));
        tools.add(tool);
        return saveToolkit();
    }

    @Override
    public List<Tool> findTool(String name) {
        List<Tool> toolList = tools.stream().filter(tool -> tool.getName().toLowerCase().strip().contains(name.toLowerCase())).collect(Collectors.toList());
        if (toolList.isEmpty()) {
            List<Tool> toolEmpty = new ArrayList<>();
            toolEmpty.add(new Tool("No matching objects found.",(new Tool.ToolSize(0, "N/A")),(new ArrayList<>(List.of("N/A")))));
            return toolEmpty;
        }
        return toolList;
    }

    @Override
    public Long delete(Long id) {
        tools.removeIf(s -> s.getId().equals(id));
        saveToolkit();
        return id;
    }

    @Override
    public ToolUpdateDTO findById(Long id) {
        Tool tool = tools.stream().filter(tooll -> tooll.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Did not find tool with id " + id));
        return new ToolUpdateDTO(tool.getId(), tool.getName(), tool.getToolSize().size(), tool.getToolSize().unit(), tool.getActions());
    }

    private List<Tool> readToolkit() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/toolkit.json");
            TypeReference<List<Tool>> typeReference = new TypeReference<>() {
            };
            return objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean saveToolkit() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/toolkit.json");
            objectMapper.writeValue(file, tools);
            System.out.println("------\nTool saved correctly\n------");
            return true;
        } catch (IOException e) {
            System.out.println("------\nTool not saved error\n------");
            e.printStackTrace();
            return false;
        }
    }
}