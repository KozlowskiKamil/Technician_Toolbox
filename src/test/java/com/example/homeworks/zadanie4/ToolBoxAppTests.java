package com.example.homeworks.zadanie4;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.service.ToolService;
import com.example.homeworks.zadanie4.service.ToolkitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToolBoxAppTests {

    @Test
    public void testAddTool() {
        ToolService toolService = new ToolkitRepository();
        Tool newTool = new Tool("Test Tool", "Test Location", new Tool.ToolSize(1.0f, "Test Unit"), List.of("Test Action"), Path.of("/img/test.png"));
        boolean result = toolService.add(newTool);
        assertTrue(result);
        List<Tool> tools = toolService.getTools();
        Tool addedTool = tools.get(tools.size() - 1);
        assertEquals(newTool, addedTool);
    }

    @Test
    public void testDeleteTool() {
        ToolService toolService = new ToolkitRepository();
        Tool newTool = new Tool("Test Tool", "Test Location", new Tool.ToolSize(1.0f, "Test Unit"), List.of("Test Action"), Path.of("/img/test.png"));
        toolService.add(newTool);
        Long idToDelete = newTool.getId();
        toolService.delete(idToDelete);
        List<Tool> tools = toolService.getTools();
        Tool deletedTool = tools.stream().filter(t -> t.getId().equals(idToDelete)).findFirst().orElse(null);
        assertNull(deletedTool);
    }
}