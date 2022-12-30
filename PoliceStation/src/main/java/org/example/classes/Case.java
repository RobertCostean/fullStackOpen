package org.example.classes;

import org.example.interfaces.Investigatable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Case implements Investigatable {
    private int caseNumber;
    private List<String> suspects;
    private List<String> evidence;
    private String description;
    private Officer assignedOfficer;
    private String caseNotes;

    public Case(int caseNumber, String description, Officer assignedOfficer) {
        this.caseNumber = caseNumber;
        this.description = description;
        this.assignedOfficer = assignedOfficer;
        this.suspects = new ArrayList<>();
        this.evidence = new ArrayList<>();
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public List<String> getSuspects() {
        return suspects;
    }

    public void addNote(String note) {
        caseNotes += note + "\n";
    }

    public void saveNotes(String fileName) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(caseNotes);
        }
    }

    public String readNotes(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public void addSuspect(String suspect) {
        suspects.add(suspect);
    }

    public void removeSuspect(String suspect) {
        suspects.remove(suspect);
    }

    public List<String> getEvidence() {
        return evidence;
    }

    public void addEvidence(String item) {
        evidence.add(item);
    }

    public void removeEvidence(String item) {
        evidence.remove(item);
    }

    public String getDescription() {
        return description;
    }

    public Officer getAssignedOfficer() {
        return assignedOfficer;
    }

    public String getCaseNotes() {
        return caseNotes;
    }
}