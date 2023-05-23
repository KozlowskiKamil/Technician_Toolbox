package com.example.homeworks.zadanie4.controller;

import com.example.homeworks.zadanie4.service.ToolkitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ToolService {

    @GetMapping("tools")
    public ToolkitRepository showAll() {
        ToolkitRepository toolkitRepository = new ToolkitRepository();
        toolkitRepository.getTools();
        return toolkitRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("tools")
    public ToolkitRepository saveTool(@RequestBody ToolkitRepository toolkitRepository) {

        return toolkitRepository;
    }

}