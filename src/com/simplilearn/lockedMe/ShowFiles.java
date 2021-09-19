package com.simplilearn.lockedMe;

import java.io.File;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowFiles {
	
	public static void retrieveFiles() {
		System.out.println("Please select any option and press Enter \n1. Retrieve files in the primary folder \n2. Go back to previous menu \n3. Exit ");
		Scanner input = new Scanner(System.in);
		try{
			int option=input.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("Files present in primary folder are:");
			File[] listOfFiles = new File("D:/projects/primary/").listFiles();
			Arrays.sort(listOfFiles);
			ShowFiles.printFileName(listOfFiles);
			
			System.out.println("\nDo you want to continue? \nPress Y to go to previous menu or N to Exit.");
			char answer = input.next().charAt(0);
			answer = Character.toLowerCase(answer);
			
			if (answer=='n')
				Homepage.exit();
			
			else if(answer=='y')
				ShowFiles.retrieveFiles();
			break;
		
		case 2:
			Homepage.menu();
			break;
			
		case 3:
			System.out.println("Thank you for using the application");
			break;
			
		default:
			System.out.println("You have entered invalid number. Please enter again \n");
			ShowFiles.retrieveFiles();
		}
		input.close();
		}
		catch(InputMismatchException ie) {
			System.out.println("Your input is invalid");

		}
		catch(Exception e){
			System.out.println("Something went wrong");
		}
	}
	
	public static void printFileName(File[] fileList) {
		for(File x:fileList) {
			System.out.println(x.getName());
		}
	}

}
