

package com.example.homeworks.zadanie4.service;

import com.example.homeworks.zadanie4.model.Tool;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ToolkitRepository {


    private final List<Tool> tools;

    public ToolkitRepository() {
        tools = readToolkit();
    }

    public List<Tool> getTools() {
        return new ArrayList<>(tools);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return tools.isEmpty();
    }

    public boolean add(Tool tool) {
        tools.add(tool);
        return saveToolkit();
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

    private boolean saveToolkit() {
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
