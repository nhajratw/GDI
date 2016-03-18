package com.chikli.gdi.help;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DonationProcessor {

    public static void main(String[] args) {

        Cash cash = new Cash();
        Property property = new Property();

        Scanner fileScanner = openFile("donations.csv");

        while (fileScanner.hasNextLine()) {
            String inputLine = fileScanner.nextLine();
            String[] inputArray = inputLine.split(",");
            String type = inputArray[0];
            String action = inputArray[1];
            int donationId = Integer.parseInt(inputArray[2]);
            int donorId = Integer.parseInt(inputArray[3]);
            String donationDescription = inputArray[4];
            double donationAmount = Double.parseDouble(inputArray[5]);
            String donationDate = inputArray[6];
            String isDeductible = inputArray[7];
            if (type.equalsIgnoreCase("CASH")) {
                int checkNumber = Integer.parseInt(inputArray[8]);
                CashDonation cashDonation = new CashDonation(donationId, donorId, donationDescription, donationAmount, donationDate, isDeductible, checkNumber);
                if (cashDonation.hasValidCheckNumber()) {
                    cash.add(cashDonation);
                } else {
                    System.out.println("Check number " + checkNumber + " is not valid.");
                    System.out.println();
                }
            } else if (type.equalsIgnoreCase("PROPERTY")) {
                boolean appraisalPerformed = Boolean.parseBoolean(inputArray[8]);
                PropertyDonation propertyDonation = new PropertyDonation(donationId, donorId, donationDescription, donationAmount, donationDate, isDeductible, appraisalPerformed);
                property.add(propertyDonation);
            }
        }
        System.out.println(cash.donations);
        System.out.println(property.donations);
        System.out.println();

    }

    private static Scanner openFile(String fileName) {
        try {
            return new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could Not open file " + fileName, e);
        }
    }
}
             
    