package controllers;

import java.util.Scanner;

public class Adminhandler {
	
		private void addRecord() {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Mode of transportation");
			String mode = in.nextLine(); 
			System.out.println("Enter Source");
			String source = in.nextLine();
			System.out.println("Enter Destination");
			String destination = in.nextLine();
			System.out.println("Enter Cost");
			String cost = in.nextLine();
			
			//push in record file
		}
		
		private void updateRecord() {
			//?
		}
		
		private void deleteRecord() {
			//?
		}
	
		public void ammend(){
		Scanner in = new Scanner(System.in);
		System.out.println("1. Add a Record");
		System.out.println("2. Update a Record");
		System.out.println("3. Delete a Record");
		 int choice = in.nextInt();
		 switch(choice){
	        case 1:
	        	addRecord();
	            break;
	        case 2:
	        	
	            break;
	        case 3:
	        	
	        	break;
	    }
		}
		
		
		public void display(){
			System.out.println("In Display");
		}
		
		
		public void book(){
			System.out.println("In book");
		}
}
