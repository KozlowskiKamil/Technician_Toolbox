/*
package com.example.homeworks.zadanie4;

import com.example.homeworks.zadanie4.model.Tool;
import com.example.homeworks.zadanie4.service.ToolkitRepository;

import java.util.*;

public class ToolkitApp {
    private static final int SHOW_ALL = 1;
    private static final int FIND_TOOL = 2;
    private static final int ADD_TOOL = 3;
    private static final int COUNT_TOOL = 4;
    private static final int EXIT = 0;

    public static void main(String[] args) {
        ToolkitRepository toolkitRepository = new ToolkitRepository();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            showOptions();
            try {
                int selectedOption = readOption(scanner);
                switch (selectedOption) {
                    case SHOW_ALL -> showAll(toolkitRepository);
                    case FIND_TOOL -> findTool(toolkitRepository);
                    case ADD_TOOL -> addTool(toolkitRepository);
                    case COUNT_TOOL -> toolsCount(toolkitRepository);
                    case EXIT -> isRunning = false;
                    default -> System.out.println("The wrong number has been entered.");
                }
            } catch (InputMismatchException e) {
                System.out.println("An invalid character has been entered.");
                scanner.next();
            }
        }
    }

    private static void toolsCount(ToolkitRepository toolkitRepository) {
        List<Tool> toolsList = toolkitRepository.getTools();
        Map<String, List<Tool>> listMap = new HashMap<>();
        for (Tool tool : toolsList) {
            String key = tool.getName();
            listMap.putIfAbsent(key, new ArrayList<>());
            listMap.get(key).add(tool);
        }
        listMap.forEach((k, v) -> {
            for (Tool tool : v) {
                System.out.println("Tool name = " + k + " | Tool size = " + tool.getToolSize().size() + " " + tool.getToolSize().unit() + "\nHow many " + k + " in the box: " + v.size() + "\n--------");
            }
        });
    }

    private static void showOptions() {
        System.out.println("Menu options\n" + SHOW_ALL + " - show all tools\n" + FIND_TOOL + " - find tool by name\n" + ADD_TOOL + " - add new tool\n" + COUNT_TOOL + " - count tools in the box\n" + EXIT + " - exit");
    }

    private static int readOption(Scanner scanner) {
        return scanner.nextInt();
    }

    private static void showAll(ToolkitRepository toolkitRepository) {
        if (toolkitRepository.isEmpty()) {
            System.out.println("You have no tools in your toolkit");
            return;
        }
        toolkitRepository.getTools().forEach(ToolkitApp::showTool);
        System.out.println("---");
    }

    private static void showTool(Tool tool) {
        System.out.println("---\n" + tool.getName() + " | Tool actions: " + tool.getActions() + "\nSize: " + tool.getToolSize().size() + " " + tool.getToolSize().unit());
    }

    private static void findTool(ToolkitRepository toolkitRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for a tool");
        String find = scanner.nextLine().toLowerCase();
        List<Tool> findList = toolkitRepository.getTools().stream().filter(tool -> tool.getName().toLowerCase().contains(find)).toList();
        if (findList.isEmpty()) {
            System.out.println("You don't have any tools with this name");
        } else {
            System.out.println("You have the tools with this name: ");
            findList.forEach(ToolkitApp::showTool);
            System.out.println("---");
        }
    }

    private static void addTool(ToolkitRepository toolkitRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add a tool name");
        String addName = getString(scanner);
        System.out.println("Add a tool size");
        float addSize = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Add a tool unit");
        String addUnit = getString(scanner);
        Tool newTool = new Tool(addName, new Tool.ToolSize(addSize, addUnit), new ArrayList<>(), img);
        boolean addActions = false;
        while (!addActions) {
            System.out.println("Add a tool action (or type 'done' to finish)");
            String addAction = getString(scanner);
            if (addAction.strip().equalsIgnoreCase("done")) {
                addActions = true;
            } else {
                newTool.addAction(addAction);
            }
        }
        toolkitRepository.add(newTool);
    }

    @SuppressWarnings("ConditionalBreakInInfiniteLoop")
    private static String getString(Scanner scanner) {
        String addString;
        while (true) {
            addString = scanner.nextLine().trim();
            if (addString.matches(".*[^ .,].*")) {
                break;
            } else {
                System.out.println("The input must contain letters");
            }
        }
        return addString;
    }
}*/
