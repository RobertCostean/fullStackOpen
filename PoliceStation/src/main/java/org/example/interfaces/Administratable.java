package org.example.interfaces;

import org.example.classes.Officer;

public interface Administratable {
    void addOfficer(Officer officer);
    void removeOfficer(Officer officer);
}