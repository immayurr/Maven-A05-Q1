package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testFullyEligibleVoter() {
        App.Voter voter = new App.Voter("Rahul Kumar", 25, "Indian", "VOTER123", true);
        String result = App.evaluateEligibility(voter);
        assertEquals("Eligible", result);
    }

    @Test
    public void testUnderageVoter() {
        App.Voter voter = new App.Voter("Anjali Sharma", 17, "Indian", "VOTER456", true);
        String result = App.evaluateEligibility(voter);
        assertTrue(result.contains("Underage"));
    }

    @Test
    public void testNonCitizenVoter() {
        App.Voter voter = new App.Voter("John Doe", 30, "American", "VOTER789", true);
        String result = App.evaluateEligibility(voter);
        assertTrue(result.contains("Not an Indian citizen"));
    }

    @Test
    public void testInvalidIdVoter() {
        App.Voter voter = new App.Voter("Priya Patel", 19, "Indian", "INVALID_ID", false);
        String result = App.evaluateEligibility(voter);
        assertTrue(result.contains("Invalid Voter ID"));
    }

    @Test
    public void testMultipleIneligibilityReasons() {
        App.Voter voter = new App.Voter("Sam Smith", 16, "British", "BAD_ID", false);
        String result = App.evaluateEligibility(voter);
        
        // Ensure all reasons are accurately tracked together
        assertTrue(result.contains("Underage"));
        assertTrue(result.contains("Not an Indian citizen"));
        assertTrue(result.contains("Invalid Voter ID"));
    }
}
