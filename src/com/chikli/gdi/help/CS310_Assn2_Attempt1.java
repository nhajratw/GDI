package com.chikli.gdi.help;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ragan E. Lake
 */
public class CS310_Assn2_Attempt1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        CashImplementation cashImpl = new CashImplementation();
        PropertyImplementation propImpl = new PropertyImplementation();
        
        Scanner fileScanner=null;
        File inFile = new File ("donations.csv");
        
        try {
            fileScanner = new Scanner (inFile);  
        } catch (FileNotFoundException fnfe) { 
            System.err.println("Failed to open file " + inFile);           
        }
        
        int sizeOfList=100;
        String [] inputArray = new String[sizeOfList];
        ArrayList<CashDonation> cashDonationList = new ArrayList<CashDonation>(inputArray.length);
        
        while (fileScanner.hasNextLine() ){            
            String inputLine = fileScanner.nextLine();
            inputArray = inputLine.split(",");
                    String type = inputArray[0]; 
                    String action = inputArray[1]; 
                    int donation_Id = Integer.parseInt(inputArray[2]);
                    int donor_Id = Integer.parseInt(inputArray[3]);
                    String donation_Description = inputArray[4];
                    double donation_Amount = Double.parseDouble(inputArray[5]);
                    String donation_Date = inputArray[6];
                    String is_Deductible = inputArray[7];
                    if (type.equalsIgnoreCase ("CASH")) {
                        int check_Number = Integer.parseInt(inputArray[8]);
                        CashDonation cashDonation = new CashDonation (donation_Id, donor_Id, donation_Description, donation_Amount, donation_Date, is_Deductible, check_Number);               
                        if (!cashDonation.validateCheckNumber(check_Number)) {
                           System.out.println("Check number " + check_Number + " is not valid.");
                            System.out.println();    
                        } else {
                            cashImpl.add(cashDonation);
                        }       
                    } else if (type.equalsIgnoreCase("PROPERTY")) {
                        boolean appraisalPerformed = Boolean.parseBoolean(inputArray[8]);
                        PropertyDonation propertyDonation = new PropertyDonation (donation_Id, donor_Id, donation_Description, donation_Amount, donation_Date, is_Deductible, appraisalPerformed);
                        propImpl.add(propertyDonation);
                    }
        }
       System.out.println(cashImpl.getCashDonationList());
        System.out.println(propImpl.getPropertyDonationList());
        System.out.println();
        
    }
}
    