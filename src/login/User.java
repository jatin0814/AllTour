package login;

import java.util.Scanner;

public class User {
	 Scanner in = new Scanner(System.in);
	 
	void createAccount(){
		System.out.println("Enter your username:-");
		in.nextLine();
		String username = in.nextLine();
		System.out.println("Enter your password:-");
		String password = in.nextLine();
		//McAsh here you have to push username and password in the file
		System.out.println("Account created successfully");
		userAuth();
	}
	
	void userAuth() {
		System.out.println("Username:-");
		String username = in.nextLine();
		System.out.println("Password:-");
		String password = in.nextLine();
		/*here you have to check user is exist or not by fetching username and password from file and if
		it is exist then return true otherwise call createAccount method*/
	}
	
	public void auth() {
		 System.out.println("1.Create Account");
		 System.out.println("2.Already have Account");
		 int choice = in.nextInt();
		 switch(choice){
	        case 1:
	            this.createAccount();
	            break;
	        case 2:
	            this.userAuth();
	            break;
	    }
	}
}


