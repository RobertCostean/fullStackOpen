package org.example.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Officer {
    private String name;
    private String badgeNumber;
    private List<Case> assignedCases;

    public Officer(String name, String badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
        this.assignedCases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public List<Case> getCases() {
        return assignedCases;
    }

    public void addCase(Case newCase) {
        assignedCases.add(newCase);
    }

    public void removeCase(Case removedCase) {
        assignedCases.remove(removedCase);
    }

    public void saveCases(String fileName) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Case c : assignedCases) {
                writer.println(c.getCaseNumber() + "," + c.getDescription());
            }
        }
    }

    public List<Case> readCases(String fileName) throws IOException {
        List<Case> cases = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            String[] parts = line.split(",");
            int caseNumber = Integer.parseInt(parts[0]);
            String description = parts[1];
            Case c = new Case(caseNumber, description, this);
            cases.add(c);
        }
        return cases;
    }


}