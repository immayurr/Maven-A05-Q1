package com.example;

import java.util.ArrayList;
import java.util.List;

public class App {

    // Inner class to represent Voter details
    public static class Voter {
        private String name;
        private int age;
        private String citizenship;
        private String voterId;
        private boolean isIdValid;

        public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
            this.name = name;
            this.age = age;
            this.citizenship = citizenship;
            this.voterId = voterId;
            this.isIdValid = isIdValid;
        }

        // Getters
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getCitizenship() { return citizenship; }
        public String getVoterId() { return voterId; }
        public boolean isIdValid() { return isIdValid; }
    }

    public static String evaluateEligibility(Voter voter) {
        List<String> reasons = new ArrayList<>();

        if (voter.getAge() < 18) {
            reasons.add("Underage (must be at least 18)");
        }
        if (!"Indian".equalsIgnoreCase(voter.getCitizenship())) {
            reasons.add("Not an Indian citizen");
        }
        if (!voter.isIdValid()) {
            reasons.add("Invalid Voter ID");
        }

        if (reasons.isEmpty()) {
            return "Eligible";
        } else {
            return "Not Eligible due to: " + String.join(", ", reasons);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Voting Eligibility System (Hardcoded Evaluation) ===");

        List<Voter> voters = new ArrayList<>();
        voters.add(new Voter("Rahul Kumar", 25, "Indian", "VOTER123", true));
        voters.add(new Voter("Anjali Sharma", 17, "Indian", "VOTER456", true));
        voters.add(new Voter("John Doe", 30, "American", "VOTER789", true));
        voters.add(new Voter("Priya Patel", 19, "Indian", "INVALID_ID", false));
        voters.add(new Voter("Sam Smith", 16, "British", "BAD_ID", false));

        // Processing and displaying results
        for (Voter voter : voters) {
            String result = evaluateEligibility(voter);
            System.out.println("\n-------------------------------------------");
            System.out.println("Voter Name  : " + voter.getName());
            System.out.println("Age         : " + voter.getAge());
            System.out.println("Citizenship : " + voter.getCitizenship());
            System.out.println("Voter ID    : " + voter.getVoterId());
            System.out.println("ID Status   : " + (voter.isIdValid() ? "Valid" : "Invalid"));
            System.out.println(">>> Result : " + result);
        }

        System.out.println("\nEvaluation completed.");
    }
}
