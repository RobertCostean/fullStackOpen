package tests;

import org.example.classes.Case;
import org.example.classes.Officer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OfficerTest {
    @Test
    public void testOfficer() {
        // Create an officer
        Officer officer = new Officer("John Doe", "12345");

        // Check initial state
        assertEquals("John Doe", officer.getName());
        assertEquals("12345", officer.getBadgeNumber());
        assertEquals(0, officer.getCases().size());

        // Add a case
        Case caseObject = new Case(123456, "Murder1", officer);
        officer.addCase(caseObject);

        // Check that the case was added
        assertEquals(1, officer.getCases().size());
        assertTrue(officer.getCases().contains(caseObject));

        // Remove the case
        officer.removeCase(caseObject);

        // Check that the case was removed
        assertEquals(0, officer.getCases().size());
        assertFalse(officer.getCases().contains(caseObject));
    }
}