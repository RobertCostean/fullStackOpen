package tests;

import org.example.classes.Case;
import org.example.classes.Officer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaseTest {
    @Test
    public void testCase() {
        // Create a case
        Officer officer = new Officer("Mircea", "F45");
        Case caseObject = new Case(123456,  "Murder2", officer);

        // Check initial state
        assertEquals(123456, caseObject.getCaseNumber());
        assertEquals(0, caseObject.getSuspects().size());
        assertEquals(0, caseObject.getEvidence().size());

        // Add a suspect and evidence
        caseObject.addSuspect("Jane Doe");
        caseObject.addEvidence("Fingerprint evidence");

        // Check that the suspect and evidence were added
        assertEquals(1, caseObject.getSuspects().size());
        assertTrue(caseObject.getSuspects().contains("Jane Doe"));
        assertEquals(1, caseObject.getEvidence().size());
        assertTrue(caseObject.getEvidence().contains("Fingerprint evidence"));

        // Remove the suspect and evidence
        caseObject.removeSuspect("Jane Doe");
        caseObject.removeEvidence("Fingerprint evidence");
    }
}