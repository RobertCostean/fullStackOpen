package org.example;

import org.example.classes.Case;
import org.example.classes.Officer;
import org.example.classes.PoliceStation;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PoliceStation policeStation = new PoliceStation("123 Main St.", "555-555-5555");
        try {
            policeStation.connectToDatabase("jdbc:mysql://localhost:3306/police_station", "root", "password");
            Case c = new Case(123, "Burglary", new Officer("John Smith", "12345"));
            policeStation.addCaseToDatabase(c);
            policeStation.disconnectFromDatabase();
        } catch (SQLException e) {
            System.out.println("Error interacting with database: " + e.getMessage());
        }


        Case myCase = new Case(123, "Burglary", new Officer("John Smith", "12345"));
        myCase.addNote("Suspect seen fleeing the scene at 10:00 PM.");

        try {
            myCase.saveNotes("case123.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error saving case notes: " + e.getMessage());
        }

        try {
            String notes = myCase.readNotes("case123.txt");
            System.out.println(notes);
        } catch (IOException e) {
            System.out.println("Error reading case notes" + e.getMessage());
        }
        Officer officer = new Officer("John Smith", "12345");
        Case c1 = new Case(123, "Burglary", officer);
        Case c2 = new Case(456, "Robbery", officer);
        officer.addCase(c1);
        officer.addCase(c2);

        try {
            officer.saveCases("cases.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error saving cases: " + e.getMessage());
        }

        try {
            List<Case> cases = officer.readCases("cases.txt");
            for (Case c : cases) {
                System.out.println("Case " + c.getCaseNumber() + ": " + c.getDescription());
            }
        } catch (IOException e) {
            System.out.println("Error reading cases: " + e.getMessage());
        }
    }
}

