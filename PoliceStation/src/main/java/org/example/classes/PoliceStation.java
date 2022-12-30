package org.example.classes;

import org.example.interfaces.Administratable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliceStation implements Administratable {
    private String address;
    private String phoneNumber;
    private List<Officer> officers;
    private Connection dbConnection;

    public PoliceStation(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.officers = new ArrayList<>();
    }

    public void connectToDatabase(String url, String username, String password) throws SQLException {
        dbConnection = DriverManager.getConnection(url, username, password);
    }

    public void disconnectFromDatabase() throws SQLException {
        dbConnection.close();
    }

    public void addCaseToDatabase(Case c) throws SQLException {
        // Execute INSERT statement to add case to database
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Officer> getOfficers() {
        return officers;
    }

    public void addOfficer(Officer officer) {
        officers.add(officer);
    }

    public void removeOfficer(Officer officer) {
        officers.remove(officer);
    }
}
