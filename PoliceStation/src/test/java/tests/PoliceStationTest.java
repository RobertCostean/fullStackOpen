package tests;

import org.example.classes.Officer;
import org.example.classes.PoliceStation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PoliceStationTest {
    @Test
    public void testPoliceStation() {
        // Create a police station
        PoliceStation policeStation = new PoliceStation("123 Main St", "555-555-1212");

        // Check initial state
        assertEquals("123 Main St", policeStation.getAddress());
        assertEquals("555-555-1212", policeStation.getPhoneNumber());
        assertEquals(0, policeStation.getOfficers().size());

        // Add an officer
        Officer officer = new Officer("John Doe", "12345");
        policeStation.addOfficer(officer);

        // Check that the officer was added
        assertEquals(1, policeStation.getOfficers().size());
        assertTrue(policeStation.getOfficers().contains(officer));

        // Remove the officer
        policeStation.removeOfficer(officer);

        // Check that the officer was removed
        assertEquals(0, policeStation.getOfficers().size());
        assertFalse(policeStation.getOfficers().contains(officer));
    }
}