
import java.util.Scanner;

import login.*;
import controllers.Adminhandler;

public class Main {
	
	public void adminController(){
		Scanner in = new Scanner(System.in);
		Adminhandler adminhandler = new Adminhandler();
		 System.out.println("WELCOME ADMIN!!");
		 System.out.println("1.Ammend");
		 System.out.println("2.Display");
		 System.out.println("3.Book");
		 int choice = in.nextInt();
		 switch(choice){
	        case 1:
	        	adminhandler.ammend();
	        	
	            break;
	        case 2:
	        	adminhandler.display();
	            break;
	        case 3:
	        	adminhandler.book();
	        	break;
	    }
	}
	
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		Admin admin = new Admin();
		Main main = new Main();
		 System.out.println("1.Admin");
		 System.out.println("2.User");
		 int choice = in.nextInt();
		 switch(choice){
	        case 1:
	            admin.auth();
	            break;
	        case 2:
	            User user = new User();
	            user.auth();
	            break;
	    }
		 if(admin.logedIn) {
			main.adminController();
		 }
	}
}
