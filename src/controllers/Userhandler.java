package controllers;


import java.util.*;
public class Userhandler
{
    Scanner in = new Scanner(System.in);
    public void main()
    {
     Scanner in = new Scanner(System.in);
     Userhandler userHandler=new Userhandler();
	 System.out.println("WELCOME !!");
	System.out.println("1. Previous Record");
	System.out.println("2. Book Ticket");
    int choice=in.nextInt();
    switch(choice)
	{
		case 1:
		userHandler.PreviousRecord();
		break;
		case 2:
		userHandler.BookTicket();
		break;
		default:
		System.out.println("Select a choice");
	}
    }
	void BookTicket()
	{
		System.out.println("Enter Your Name");
		String username = in.nextLine();
		System.out.println("Enter Your Age");
		int age = in.nextInt();
		System.out.println("Enter Mode of transportation");
		System.out.println("1. Road");
		System.out.println("2. Railway");
		System.out.println("3 Airways");
	    int  mode = in.nextInt(); 
		switch(mode)
		{
			case 1:
			    System.out.println("Road");
		//	Road();
			break;
			case 2:
			     System.out.println("Railway");
		//	Railway();
			break;
			case 3:
			     System.out.println("Airways");
		//	Airways();
			break;
			default :
				BookTicket();
	}
	}	
	void PreviousRecord()
	{
	    //DisplayRoutes
	}
	void generateTicket()
	{
	    //generateTicket
	}
}