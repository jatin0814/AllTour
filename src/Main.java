
import java.util.Scanner;

import login.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		 System.out.println("1.Admin");
		 System.out.println("2.User");
		 int choice = in.nextInt();
		 switch(choice){
	        case 1:
	            Admin admin = new Admin();
	            admin.auth();
	            System.out.println(admin.logedIn);
	            break;
	        case 2:
	            User user = new User();
	            user.auth();
	            break;
	    }
	}
}
