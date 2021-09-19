package com.simplilearn.lockedMe;

import java.util.Scanner;

public class Homepage {
	
	public static void welcomescreen(String company, String name){
		
		System.out.println("************************************* "
				+ "\nWelcome to "+ company + "\nApplication developed by "+ name +
				"\n************************************* \nNote: All files operations are done in D:/projects/primary/ \n");
	}
	
	public static void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Main menu \n********* \nPlease select any option and "
				+ "press Enter: \n1. See files \n2. Business level operations \n3. Exit");
		
		int option = input.nextInt();
		
		switch(option) {
		case 1:
			ShowFiles.retrieveFiles();
			break;
			
		case 2:
			FileOperation.operations();
			break;
		case 3:
			Homepage.exit();
			break;
		default:
			System.out.println("You have entered a wrong number. Please enter again \n");
			Homepage.menu();
		}
		input.close();
	}
	public static void exit() {
		System.out.println("Thank you for using the application.");
		System.exit(0);
	}

}
