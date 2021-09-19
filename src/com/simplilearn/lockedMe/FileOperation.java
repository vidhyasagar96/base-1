package com.simplilearn.lockedMe;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperation {
	
	public static void operations() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease select any option and press Enter:\n "
				+ "\n1. Add files to the primary folder \n2. Delete a file from primary folder"
				+ "\n3. Search for a file in Primary folder \n4. Go back to previous menu \n5. Exit");
		int option = input.nextInt();
		input.nextLine();
		
		switch(option) {
		case 1:
			System.out.println("Please enter a file name with extension to add:");
			String addName = input.next();
			
			FileOperation.addFile(addName);
			FileOperation.returnMenu();
			break;
			
		case 2:
			System.out.println("Please enter a file name with extension to delete:");
			String deleteName = input.nextLine();
			
			FileOperation.deleteFile(deleteName);
			FileOperation.returnMenu();
			break;
			
		case 3:
			System.out.println("Please enter a file name with extension to search:");
			String searchName = input.next();
			
			FileOperation.searchFile(searchName);
			FileOperation.returnMenu();
			break;
		case 4:
			Homepage.menu();
			break;
			
		case 5:
			Homepage.exit();
			break;
			
		default:
			System.out.println("You have entered invalid number. Please enter again \n");
			FileOperation.operations();
		}
	  input.close();	
	}
	
	public static void addFile(String addName) {
		File file = new File("D:/projects/primary/"+addName);
		
		try {
			if(file.createNewFile())
				System.out.println("File is added to the folder\n");
			else
				System.out.println("File already exists\n");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void deleteFile(String deleteName) {
		
		File file = new File("D:/projects/primary/"+deleteName);
		
		if(file.delete())
			System.out.println(deleteName+" is deleted from primary folder \n");
		
		else
			System.out.println("File not found. Please check the file name \n");
	}
	
	public static void searchFile(String searchName) {
		
		File[] searching = new File("D:/projects/primary/").listFiles();
		
		if(searching!=null) {
			for(File x:searching) {
				if (x.getName().equalsIgnoreCase(searchName)) {
					System.out.println("Your file is found");
					return;
				}
		}
			System.out.println("File not found \n");
	}
	
	}
	public static void returnMenu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to continue? \nPress Y to go to previous menu or N to Exit.");
		char answer = input.next().charAt(0);
		answer = Character.toLowerCase(answer);
		
		switch(answer) {
		case 'n':
			Homepage.exit();
			break;
		case 'y':
			FileOperation.operations();
			break;
		default:
			System.out.println("Invalid command, Please choose again. \n");
			FileOperation.returnMenu();
			
		input.close();
		}
	}
}
	
