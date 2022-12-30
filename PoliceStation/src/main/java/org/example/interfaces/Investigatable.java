package org.example.interfaces;

public interface Investigatable {
    void addSuspect(String suspect);
    void removeSuspect(String suspect);
    void addEvidence(String item);
    void removeEvidence(String item);
}