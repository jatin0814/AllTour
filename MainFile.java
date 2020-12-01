import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

class Graph
{
     static HashMap<String,HashMap<String,Integer>> mp=new HashMap<String,HashMap<String,Integer>>();
     static HashMap<String,Integer>dist=new HashMap<String,Integer>();
     static int cnt=0;
    static void CreateGraph(String a, String b,Integer c)
    {
        dist.put(a,Integer.MAX_VALUE);
        dist.put(b,Integer.MAX_VALUE);
        if(mp.containsKey(a))
        {
            HashMap<String,Integer>temp=new HashMap<String,Integer>();
            temp=mp.get(a);
            temp.put(b,c);
            mp.put(a,temp);
        }
        else{
            HashMap<String,Integer>temp=new HashMap<String,Integer>();
            temp.put(b,c);
            mp.put(a,temp);
            
        }
     
    }
    static void DisplayGraph()
    {
        for (Map.Entry mapElement : mp.entrySet())
        { 
            String key = (String)mapElement.getKey(); 
            System.out.print(key + "->");
            HashMap<String,Integer> value = (HashMap)mapElement.getValue() ;
            for(Map.Entry valueEl : value.entrySet())
            {
                String val1 = (String)valueEl.getKey();
                Integer val2 = (Integer)valueEl.getValue();
                System.out.print(val1+ ":" +val2+ "  ");
            }
            System.out.println("");
        }
        
        
    }
    static void shortestPath(String src,String des)
    {
        if(!mp.containsKey(src))
        {
            System.out.println("This city as a source is not available");
            return;
        }
        SortedMap<Integer, String> s = new TreeMap<Integer, String>();
        dist.put(src,0);
        s.put(0,src);
        while(s.size()>0)
        {
            int nodeDist =s.firstKey();
            String node =s.get(nodeDist);
            s.remove(nodeDist);
            HashMap<String,Integer> T = new HashMap<String,Integer>();
            if(mp.containsKey(node))
            T = mp.get(node);
            if(T.size()>0)
            {
                for(Map.Entry valueEl : T.entrySet())
              {
                int v= (int)valueEl.getValue();
                String k = (String)valueEl.getKey();
                if(nodeDist+v < dist.get(k))
                {
                    if(s.containsKey(v))
                    {
                        s.remove(v);
                    }
                    int c=nodeDist+v;
                    dist.put(k,c);
                    cnt=cnt+1;
                    s.put(c,k);
                }
               // System.out.println(dist);
          
                
              }
            }
        }
        System.out.println("Source is " + src);
        System.out.println("Destination is " + des);
        System.out.println("Shortest distance between "+ src + " and " + des+ " is " + dist.get(des));
    }
    static void DeleteNode(String src,String des)
    {
        if(!mp.containsKey(src))
        {
            System.out.println("This city as a source is not available");
            return;
        }
        else
        {
            HashMap<String,Integer>temp=new HashMap<String,Integer>();
            temp=mp.get(src);
            temp.remove(des);
            mp.put(src,temp);
        }
        
    }
    static void Ammend(String src,String des,Integer x)
    {
        HashMap<String,Integer>temp=new HashMap<String,Integer>();
        temp=mp.get(src);
        temp.put(des,x);
        mp.put(src,temp);
        
        
        
        
    }
   public static void main(String[] args)
    {
      
        CreateGraph("A","B",1);
        CreateGraph("A","F",3);
        CreateGraph("A","D",5);
        //CreateGraph("kanpur","Delhi",4);
        CreateGraph("A","E",6);
        CreateGraph("E","H",7);
        CreateGraph("D","G",9);
        CreateGraph("F","G",2);
        CreateGraph("B","C",4);
        CreateGraph("C","F",1);
        //CreateGraph("D","G",9);
        DisplayGraph();
        shortestPath("A","E");
        DeleteNode("A","E");
        Ammend("B","C",8);
        DisplayGraph();
        
        
        // CreateGraph()
        
      
        
    }
}


public class MainFile 
{

	static void addRecord() 
	{
		Scanner sc = new Scanner(System.in);
		int choice1;
		
		System.out.println("------Enter Mode of transportation------");
		System.out.println("1. Airways");
		System.out.println("2. Railways");
		System.out.println("3. Roadways");
		
		choice1 = sc.nextInt();
		switch(choice1)
		{
			case 1: //System.out.println("Enter Source");
			try
			{	
				System.out.println("Enter Source");
				Scanner sc1 = new Scanner(System.in);
				File airways = new File("Airways.txt");
				if(airways.createNewFile())
				{
					System.out.println("BOOKING Through Airways ---->");
				}
//				else
//				{
//					System.out.println("Airways Mode already CHOSEN and CREATED");
//				}
//				FileWriter airR = new FileWriter("Airways.txt");
//				String dest1;
//				dest1 = sc1.nextLine();
//				airR.write("Source: "+dest1+"\n");
//				airR.close();	
				
				
				Scanner scccc1 = new Scanner(System.in);
				File fileee1 = new File("Airways.txt");
				FileWriter wrrr1 = null;
				String sourceee1;
				sourceee1 = scccc1.nextLine();
				
				wrrr1 = new FileWriter(fileee1,true);
				wrrr1.write("Source: "+sourceee1+"\n");
				wrrr1.close();
				
				
				// I have try catch block 'inside' outer 'try' block
				
				
				try
				{
					System.out.println("Enter Destination");
					Scanner scc1 = new Scanner(System.in);
					File file1 = new File("Airways.txt");
					FileWriter wr1 = null;
					String source1;
					source1 = scc1.nextLine();
					
					wr1 = new FileWriter(file1,true);
					wr1.write("Destination: "+source1+"\n");
					wr1.close();
				}
				
				catch(Exception e )
				{
					System.out.println("Error in Airways");
				}
				
				
				try
				{
					System.out.println("Distance");
					Scanner sccc1 = new Scanner(System.in);
					File filee1 = new File("Airways.txt");
					FileWriter wrr1 = null;
					String sourcee1;
					sourcee1 = sccc1.nextLine();
					
					wrr1 = new FileWriter(filee1,true);
					wrr1.write("Cost: "+sourcee1+"\n"+"\n");
					wrr1.close();
				}
				
				catch(Exception e )
				{
					System.out.println("Error in Airways");
				}
			}
			catch(Exception e)
			{
				System.out.println("Error in creating AIRWAYS File!");
			}
			break;
			
			case 2: System.out.println("Enter Source");
			try
			{	
				Scanner sc2 = new Scanner(System.in);
				File railways = new File("Railways.txt");
				if(railways.createNewFile())
				{
					System.out.println("BOOKING Through Railways ---->");
				}
//				else
//				{
//					System.out.println("Railways Mode already CHOSEN and CREATED");
//				}
				FileWriter railR = new FileWriter("Railways.txt");
				String dest2;
				dest2 = sc2.nextLine();
				railR.write("Source: "+dest2+"\n");
				railR.close();
				
				try
				{
					System.out.println("Enter Destination");
					Scanner scc2 = new Scanner(System.in);
					File file2 = new File("Railways.txt");
					FileWriter wr2 = null;
					String source2;
					source2 = scc2.nextLine();
					
					wr2 = new FileWriter(file2,true);
					wr2.write("Destination: "+source2+"\n");
					wr2.close();
				}
				
				catch(Exception e )
				{
					System.out.println("Error in Railways");
				}
				
				
				try
				{
					System.out.println("Distance");
					Scanner sccc2 = new Scanner(System.in);
					File filee2 = new File("Railways.txt");
					FileWriter wrr2 = null;
					String sourcee2;
					sourcee2 = sccc2.nextLine();
					
					wrr2 = new FileWriter(filee2,true);
					wrr2.write("Cost: "+sourcee2+"\n");
					wrr2.close();
				}
				
				catch(Exception e )
				{
					System.out.println("Error in Railways");
				}
			}
			catch(Exception e)
			{
				System.out.println("Error in creating RAILWAYS File!");
			}
			break;
			
			case 3: System.out.println("Enter Source");
			try
			{	
				Scanner sc3 = new Scanner(System.in);
				File roadways = new File("Roadways.txt");
				if(roadways.createNewFile())
				{
					System.out.println("BOOKING Through Roadways ---->");
				}
//				else
//				{
//					System.out.println("Roadways Mode already CHOSEN and CREATED");
//				}
				FileWriter roadR = new FileWriter("Roadways.txt");
				String dest3;
				dest3 = sc3.nextLine();
				roadR.write("Source: "+dest3+"\n");
				roadR.close();
				
				try
				{
					System.out.println("Enter Destination");
					Scanner scc3 = new Scanner(System.in);
					File file3 = new File("Roadways.txt");
					FileWriter wr3 = null;
					String source3;
					source3 = scc3.nextLine();
					
					wr3 = new FileWriter(file3,true);
					wr3.write("Destination: "+source3+"\n");
					wr3.close();
				}
				
				catch(Exception e )
				{
					System.out.println("Error in Airways");
				}
				
				
				try
				{
					System.out.println("Distance");
					Scanner sccc3 = new Scanner(System.in);
					File filee3 = new File("Roadways.txt");
					FileWriter wrr3 = null;
					String sourcee3;
					sourcee3 = sccc3.nextLine();
					
					wrr3 = new FileWriter(filee3,true);
					wrr3.write("Cost: "+sourcee3+"\n");
					wrr3.close();
				}
				
				catch(Exception e )
				{
					System.out.println("Error in Roadways");
				}
			}
			catch(Exception e)
			{
				System.out.println("Error in creating ROADWAYS File!");
			}
			break;
		}

	

	}
	
	static void updateRecord(String filepath,String oldString, String newString)
	{
		File change = new File(filepath);

		String oldContent = "";
		 
        BufferedReader reader = null;
         
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(change));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(change);
             
            writer.write(newContent);
          
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
        System.out.println("EDIT SUCCESSFUL");
		
	}
	
	
	
	static void deleteRecord(String filename)
	{
		try
		{
		FileWriter br = new FileWriter(filename);
		br.write("");
		
		br.close();
		}
		
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	
	static void choiceSelector(int userChoice)
	{
		Scanner abc = new Scanner(System.in);
	
		 switch(userChoice)
		{
	        case 1:
	        	addRecord();
	            break;
	        case 2:
				Scanner a = new Scanner(System.in);
				String oldWord,newWord,nameOfFile;				
				
				System.out.println("Enter Name of file: ");
				nameOfFile = a.nextLine();
				
				System.out.println("Enter old word: ");				
				oldWord = a.nextLine();
				
				System.out.println("Enter new word: ");
			
				newWord = a.nextLine();
				
				
				updateRecord(nameOfFile,oldWord,newWord);
	        	
	            break;
	            
	        case 3:
	        	Scanner b = new Scanner(System.in);
				String filename;
				System.out.println("Enter name of file to be DELETED");
				filename = b.nextLine();
				deleteRecord(filename);
	        	break;
	        	
	        case 4 : 
	        	System.out.println("Enter name of file");
	        	Scanner c = new Scanner(System.in);
	        	String filepath = c.nextLine();
	        	seeRecord(filepath);
	        	
	      default:
	        		System.out.println("LOGGED OUT OF ADMIN");
	    }
			System.out.println("1. Add a Record");
			System.out.println("2. Update a Record");
			System.out.println("3. Delete a Record");
			System.out.println("4. Print a Record");
			System.out.println("5. Hit 0 to EXIT");
			userChoice = abc.nextInt();
			while(userChoice!=0)
			{
				choiceSelector(userChoice);
			}
			if(userChoice == 0)
			{
				System.out.println("LOGGED OUT OF ADMIN");
			}
			
	}
	
	static void seeRecord(String filepath)
	{
		try
		{
		FileReader cr = new FileReader(filepath);
		Scanner sc = new Scanner(cr);
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		}
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
	}
	
	
	
	
	
//	public class Userhandler
//	{
//	    Scanner in = new Scanner(System.in);
//	    public void main()
//	    {
//	     Scanner in = new Scanner(System.in);
//	     Userhandler userHandler=new Userhandler();
//		 System.out.println("WELCOME !!");
//		System.out.println("1. Previous Record");
//		System.out.println("2. Book Ticket");
//	    int choice=in.nextInt();
//	    switch(choice)
//		{
//			case 1:
//			userHandler.PreviousRecord();
//			break;
//			case 2:
//			userHandler.BookTicket();
//			break;
//			default:
//			System.out.println("Select a choice");
//		}
//	    }
		
	static void BookTicket()
		{
			
			String a1,b1,c1;
			int god;
			Scanner in = new Scanner(System.in);
			System.out.println("Enter Your Name");			
			String username = in.nextLine();
			try
			{
			
			File user1 = new File(username);
			
			if(user1.createNewFile())
			{
				System.out.println("NAME is stored in "+username);
			}
			
			else
				System.out.println("User with this name already exists");
			
			
			FileWriter use = new FileWriter(username);
			Scanner a = new Scanner(System.in);
			use.write("USERNAME: "+username+"\n");
			use.close();
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
			
			try
			{
				System.out.println("Enter Your Age");
				//int age = in.nextInt();
				Scanner h = new Scanner(System.in);				
				File file2 = new File(username);				
				FileWriter u = null;
				String age;
				age = h.nextLine();
				
				u = new FileWriter(file2,true);
				u.write("Age: "+age+"\n");
				u.close();
			}
			
			catch(Exception e)
			{
				System.out.println("Error");
			}
			System.out.println("Enter Mode of transportation");
			System.out.println("1. Roadways");
			System.out.println("2. Railways");
			System.out.println("3. Airways");
		    int  mode = in.nextInt(); 
			switch(mode)
			{
				case 1:
				  //  System.out.println("Road");
					try
					{
						System.out.println("Roadways");
						//int age = in.nextInt();
						Scanner h = new Scanner(System.in);				
						File file2 = new File(username);				
						FileWriter u = null;
						String transport = "Roadways";
										
						u = new FileWriter(file2,true);
						u.write("Transportation: "+transport+"\n");
						u.close();
					}
					
					catch(Exception e)
					{
						System.out.println("Error");
					}
				    try
				    {
					    FileReader userR = new FileReader(username);
						Scanner r = new Scanner(userR);
						while(r.hasNextLine())
						{	
							Scanner p = new Scanner(System.in);
							File file1 = new File("Roadways.txt");
							FileReader fr1 = new FileReader(file1);
							BufferedReader br1 = new BufferedReader(fr1);
							String s1,s2,s3;
							int count1=0;
							int count2=0;
							int count3=0;
							String [] words1 = null;
							String [] words2 = null;
							String [] words3 = null;
							String input1,input2;
							int input3;
							System.out.println("Enter source: ");
							input1 = p.nextLine();
							try
							{
								Scanner h = new Scanner(System.in);				
								File file2 = new File(username);				
								FileWriter u = null;
								
								//input1 = p.nextLine();
								
								u = new FileWriter(file2,true);
								u.write("Source of Journey: "+input1+"\n");
								u.close();
							}
							
							catch(Exception e)
							{
								System.out.println("Error");
							}
							
//							System.out.println("Enter destination to ADD: ");
//							input2 = p.nextLine();
//							System.out.println("Enter distance to ADD");
//							input3 = p.nextInt();
							while((s1=br1.readLine())!=null)
							{
								words1 = s1.split(" ");
								 for (String word : words1) 
						          {
						                 if (word.equals(input1))   //Search for the given word
						                 {
						                	 a1 = input1;
						                	 //System.out.println("Word FOUND");
						                	 count1++;
						                 }
						      
						          }
//								 if(count1!=0)
//								 {
//									 System.out.println("not found");
//								 }
								 
								 
							fr1.close();
							}
						}
				    }
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
						    
						    try
						    {
							    FileReader userR = new FileReader(username);
								Scanner r = new Scanner(userR);
								while(r.hasNextLine())
								{	
									Scanner p = new Scanner(System.in);
									File file1 = new File("Roadways.txt");
									FileReader fr1 = new FileReader(file1);
									BufferedReader br1 = new BufferedReader(fr1);
									String s1,s2,s3;
									int count1=0;
									int count2=0;
									int count3=0;
									String [] words1 = null;
									String [] words2 = null;
									String [] words3 = null;
									String input1,input2;
									int input3;
//									System.out.println("Enter source to ADD: ");
//									input1 = p.nextLine();
									System.out.println("Enter destination: ");
									input2 = p.nextLine();
									try
									{
										Scanner h = new Scanner(System.in);				
										File file2 = new File(username);				
										FileWriter u = null;
										
										//input1 = p.nextLine();
										
										u = new FileWriter(file2,true);
										u.write("Destination: "+input2+"\n");
										u.close();
									}
									
									catch(Exception e)
									{
										System.out.println("Error");
									}
//									System.out.println("Enter distance to ADD");
//									input3 = p.nextInt();
									while((s1=br1.readLine())!=null)
									{
										words1 = s1.split(" ");
										 for (String word : words1) 
								          {
								                 if (word.equals(input2))   //Search for the given word
								                 {
								                	 b1 = input2;
								                	// System.out.println("Word FOUND");
								                	 count1++;
								                 }
								      
								          }
//										 if(count1!=0)
//										 {
//											 System.out.println("not found");
//										 }
										 
										 
									fr1.close();
									}
								}
						    }
//							
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
						    
						    try
						    {
							    FileReader userR = new FileReader(username);
								Scanner r = new Scanner(userR);
								while(r.hasNextLine())
								{	
									Scanner p = new Scanner(System.in);
									File file1 = new File("Roadways.txt");
									FileReader fr1 = new FileReader(file1);
									BufferedReader br1 = new BufferedReader(fr1);
									String s1,s2,s3;
									int count1=0;
									int count2=0;
									int count3=0;
									String [] words1 = null;
									String [] words2 = null;
									String [] words3 = null;
									//String input1,input2;
									String input3;
//									System.out.println("Enter source to ADD: ");
//									input1 = p.nextLine();
									//System.out.println("Enter destination to ADD: ");
									//input2 = p.nextLine();
									System.out.println("Enter distance: ");
									input3 = p.nextLine();
									try
									{
										Scanner h = new Scanner(System.in);				
										File file2 = new File(username);				
										FileWriter u = null;
										
										//input1 = p.nextLine();
										
										u = new FileWriter(file2,true);
										u.write("Distance: "+input3+"\n");
										u.close();
									}
									
									catch(Exception e)
									{
										System.out.println("Error");
									}
									while((s1=br1.readLine())!=null)
									{
										words1 = s1.split(" ");
										 for (String word : words1) 
								          {
								                 if (word.equals(input3))   //Search for the given word
								                 {
								                	 c1 = input3;
								                	 //System.out.println("Word FOUND");
								                	 count1++;
								                 }
								      
								          }
////										 if(count1!=0)
////										 {
////											 System.out.println("not found");
////										 }
//										 
										 
									fr1.close();
									}
								}
						    }
						    
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
			
				break;
				case 2:
				    //System.out.println("Railway");
					try
					{
						System.out.println("Railways");
						//int age = in.nextInt();
						Scanner h = new Scanner(System.in);				
						File file2 = new File(username);				
						FileWriter u = null;
						String transport = "Railways";
										
						u = new FileWriter(file2,true);
						u.write("Transportation: "+transport+"\n");
						u.close();
					}
					
					catch(Exception e)
					{
						System.out.println("Error");
					}
				    try
				    {
					    FileReader userR = new FileReader(username);
						Scanner r = new Scanner(userR);
						while(r.hasNextLine())
						{	
							Scanner p = new Scanner(System.in);
							File file1 = new File("Railways.txt");
							FileReader fr1 = new FileReader(file1);
							BufferedReader br1 = new BufferedReader(fr1);
							String s1,s2,s3;
							int count1=0;
							int count2=0;
							int count3=0;
							String [] words1 = null;
							String [] words2 = null;
							String [] words3 = null;
							String input1,input2;
							int input3;
							System.out.println("Enter source: ");
							input1 = p.nextLine();
							try
							{
								Scanner h = new Scanner(System.in);				
								File file2 = new File(username);				
								FileWriter u = null;
								
								//input1 = p.nextLine();
								
								u = new FileWriter(file2,true);
								u.write("Source of Journey: "+input1+"\n");
								u.close();
							}
							
							catch(Exception e)
							{
								System.out.println("Error");
							}
//							System.out.println("Enter destination to ADD: ");
//							input2 = p.nextLine();
//							System.out.println("Enter distance to ADD");
//							input3 = p.nextInt();
							while((s1=br1.readLine())!=null)
							{
								words1 = s1.split(" ");
								 for (String word : words1) 
						          {
						                 if (word.equals(input1))   //Search for the given word
						                 {
						                	 a1 = input1;
						                	 //System.out.println("Word FOUND");
						                	 count1++;
						                 }
						      
						          }
//								 if(count1!=0)
//								 {
//									 System.out.println("not found");
//								 }
								 
								 
							fr1.close();
							}
						}
				    }
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
						    
						    try
						    {
							    FileReader userR = new FileReader(username);
								Scanner r = new Scanner(userR);
								while(r.hasNextLine())
								{	
									Scanner p = new Scanner(System.in);
									File file1 = new File("Railways.txt");
									FileReader fr1 = new FileReader(file1);
									BufferedReader br1 = new BufferedReader(fr1);
									String s1,s2,s3;
									int count1=0;
									int count2=0;
									int count3=0;
									String [] words1 = null;
									String [] words2 = null;
									String [] words3 = null;
									String input1,input2;
									int input3;
//									System.out.println("Enter source to ADD: ");
//									input1 = p.nextLine();
									System.out.println("Enter destination : ");
									input2 = p.nextLine();
									try
									{
										Scanner h = new Scanner(System.in);				
										File file2 = new File(username);				
										FileWriter u = null;
										
										//input1 = p.nextLine();
										
										u = new FileWriter(file2,true);
										u.write("Destination: "+input2+"\n");
										u.close();
									}
									
									catch(Exception e)
									{
										System.out.println("Error");
									}
//									System.out.println("Enter distance to ADD");
//									input3 = p.nextInt();
									while((s1=br1.readLine())!=null)
									{
										words1 = s1.split(" ");
										 for (String word : words1) 
								          {
								                 if (word.equals(input2))   //Search for the given word
								                 {
								                	 b1 = input2;
								                	// System.out.println("Word FOUND");
								                	 count1++;
								                 }
								      
								          }
//										 if(count1!=0)
//										 {
//											 System.out.println("not found");
//										 }
										 
										 
									fr1.close();
									}
								}
						    }
//							
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
						    
						    try
						    {
							    FileReader userR = new FileReader(username);
								Scanner r = new Scanner(userR);
								while(r.hasNextLine())
								{	
									Scanner p = new Scanner(System.in);
									File file1 = new File("Railways.txt");
									FileReader fr1 = new FileReader(file1);
									BufferedReader br1 = new BufferedReader(fr1);
									String s1,s2,s3;
									int count1=0;
									int count2=0;
									int count3=0;
									String [] words1 = null;
									String [] words2 = null;
									String [] words3 = null;
									//String input1,input2;
									String input3;
//									System.out.println("Enter source to ADD: ");
//									input1 = p.nextLine();
									//System.out.println("Enter destination to ADD: ");
									//input2 = p.nextLine();
									System.out.println("Enter distance: ");
									input3 = p.nextLine();
									try
									{
										Scanner h = new Scanner(System.in);				
										File file2 = new File(username);				
										FileWriter u = null;
										
										//input1 = p.nextLine();
										
										u = new FileWriter(file2,true);
										u.write("Distance: "+input3+"\n");
										u.close();
									}
									
									catch(Exception e)
									{
										System.out.println("Error");
									}
									while((s1=br1.readLine())!=null)
									{
										words1 = s1.split(" ");
										 for (String word : words1) 
								          {
								                 if (word.equals(input3))   //Search for the given word
								                 {
								                	 c1 = input3;
								                	 //System.out.println("Word FOUND");
								                	 god = Integer.parseInt(c1);  // pass god as third argument in create graph
								                	 count1++;
								                	 
								                 }
								      
								          }
////										 if(count1!=0)
////										 {
////											 System.out.println("not found");
////										 }
//										 
										 
									fr1.close();
									}
								}
						    }
						    
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
			
				break;
				case 3:
				    //System.out.println("Railway");
					try
					{
						System.out.println("Airways");
						//int age = in.nextInt();
						Scanner h = new Scanner(System.in);				
						File file2 = new File(username);				
						FileWriter u = null;
						String transport = "Airways";
										
						u = new FileWriter(file2,true);
						u.write("Transportation: "+transport+"\n");
						u.close();
					}
					
					catch(Exception e)
					{
						System.out.println("Error");
					}
				    try
				    {
					    FileReader userR = new FileReader(username);
						Scanner r = new Scanner(userR);
						while(r.hasNextLine())
						{	
							Scanner p = new Scanner(System.in);
							File file1 = new File("Airways.txt");
							FileReader fr1 = new FileReader(file1);
							BufferedReader br1 = new BufferedReader(fr1);
							String s1,s2,s3;
							int count1=0;
							int count2=0;
							int count3=0;
							String [] words1 = null;
							String [] words2 = null;
							String [] words3 = null;
							String input1,input2;
							int input3;
							System.out.println("Enter source: ");
							input1 = p.nextLine();
							try
							{
								Scanner h = new Scanner(System.in);				
								File file2 = new File(username);				
								FileWriter u = null;
								
								//input1 = p.nextLine();
								
								u = new FileWriter(file2,true);
								u.write("Source of Journey: "+input1+"\n");
								u.close();
							}
							
							catch(Exception e)
							{
								System.out.println("Error");
							}
//							System.out.println("Enter destination to ADD: ");
//							input2 = p.nextLine();
//							System.out.println("Enter distance to ADD");
//							input3 = p.nextInt();
							while((s1=br1.readLine())!=null)
							{
								words1 = s1.split(" ");
								 for (String word : words1) 
						          {
						                 if (word.equals(input1))   //Search for the given word
						                 {
						                	 a1 = input1;
						                	// System.out.println("Word FOUND");
						                	 count1++;
						                 }
						      
						          }
//								 if(count1!=0)
//								 {
//									 System.out.println("not found");
//								 }
								 
								 
							fr1.close();
							}
						}
				    }
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
						    
						    try
						    {
							    FileReader userR = new FileReader(username);
								Scanner r = new Scanner(userR);
								while(r.hasNextLine())
								{	
									Scanner p = new Scanner(System.in);
									File file1 = new File("Airways.txt");
									FileReader fr1 = new FileReader(file1);
									BufferedReader br1 = new BufferedReader(fr1);
									String s1,s2,s3;
									int count1=0;
									int count2=0;
									int count3=0;
									String [] words1 = null;
									String [] words2 = null;
									String [] words3 = null;
									String input1,input2;
									int input3;
//									System.out.println("Enter source to ADD: ");
//									input1 = p.nextLine();
									System.out.println("Enter destination: ");
									input2 = p.nextLine();
									try
									{
										Scanner h = new Scanner(System.in);				
										File file2 = new File(username);				
										FileWriter u = null;
										
										//input1 = p.nextLine();
										
										u = new FileWriter(file2,true);
										u.write("Destination: "+input2+"\n");
										u.close();
									}
									
									catch(Exception e)
									{
										System.out.println("Error");
									}
//									System.out.println("Enter distance to ADD");
//									input3 = p.nextInt();
									while((s1=br1.readLine())!=null)
									{
										words1 = s1.split(" ");
										 for (String word : words1) 
								          {
								                 if (word.equals(input2))   //Search for the given word
								                 {
								                	 b1 = input2;
								                	 //System.out.println("Word FOUND");
								                	 count1++;
								                 }
								      
								          }
//										 if(count1!=0)
//										 {
//											 System.out.println("not found");
//										 }
										 
										 
									fr1.close();
									}
								}
						    }
//							
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
						    
						    try
						    {
							    FileReader userR = new FileReader(username);
								Scanner r = new Scanner(userR);
								while(r.hasNextLine())
								{	
									Scanner p = new Scanner(System.in);
									File file1 = new File("Airways.txt");
									FileReader fr1 = new FileReader(file1);
									BufferedReader br1 = new BufferedReader(fr1);
									String s1,s2,s3;
									int count1=0;
									int count2=0;
									int count3=0;
									String [] words1 = null;
									String [] words2 = null;
									String [] words3 = null;
									//String input1,input2;
									String input3;
//									System.out.println("Enter source to ADD: ");
//									input1 = p.nextLine();
									//System.out.println("Enter destination to ADD: ");
									//input2 = p.nextLine();
									System.out.println("Enter distance: ");
									input3 = p.nextLine();
									try
									{
										Scanner h = new Scanner(System.in);				
										File file2 = new File(username);				
										FileWriter u = null;
										
										//input1 = p.nextLine();
										
										u = new FileWriter(file2,true);
										u.write("Distance: "+input3+"\n");
										u.close();
									}
									
									catch(Exception e)
									{
										System.out.println("Error");
									}
									while((s1=br1.readLine())!=null)
									{
										words1 = s1.split(" ");
										 for (String word : words1) 
								          {
								                 if (word.equals(input3))   //Search for the given word
								                 {
								                	 c1 = input3;
								                	// System.out.println("Word FOUND");
								                	 god = Integer.parseInt(c1);  // pass god as third argument in create graph
								                	 count1++;
								                	 
								                 }
								      
								          }
////										 if(count1!=0)
////										 {
////											 System.out.println("not found");
////										 }
//										 
										 
									fr1.close();
									}
								}
						    }
						    
						    catch(Exception e)
						    {
						    	System.out.println("");
						    }
			
				break;
				
				//default :
					//BookTicket();
		}
			System.out.println("Called createGraph function here");
			Graph obj = new Graph();
//			obj.CreateGraph(a1,b1,god);				// --->ERRRROOOORRRR
//			obj.shortestPath(input1,input2);		// --->ERRRROOOORRRR
		}	
		// book ticket ends above
		
		static void previousRecord()
		{
		    Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name of File");
			String filename;
			filename = sc.nextLine();
			try
			{
			FileReader br1 = new FileReader(filename);
			Scanner a = new Scanner(br1);
			while(a.hasNextLine())
			{
				System.out.println(a.nextLine());
			}
			//br1.close();
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
		    
		}
		
		static void generateTicket()
		{
		    Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name of File");
			String filename;
			filename = sc.nextLine();
			try
			{
			FileReader br1 = new FileReader(filename);
			Scanner a = new Scanner(br1);
			while(a.hasNextLine())
			{
				System.out.println(a.nextLine());
			}
			//br1.close();
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
		}

	
	static void userChoiceSelector(int userChoice)
	{
		Scanner abc = new Scanner(System.in);
		switch(userChoice)
		{
		case 6: 
			BookTicket();
			break;
		
		case 7: 
			generateTicket();
		break;
		
		case 8: 
			previousRecord();
		break;
			
		}
		System.out.println("-----USER MENU-----");
		System.out.println("6. Book Ticket");
		System.out.println("7. Generate Ticket");
		System.out.println("8. View Previous Record");
		System.out.println("9. Hit -1 to EXIT");
		userChoice = abc.nextInt();
		while(userChoice!=-1)
		{
			userChoiceSelector(userChoice);
		}
		
		
	}
	
	
	public static void main(String[] args) 
	{


			Scanner ab = new Scanner(System.in);
			System.out.println("-----ADMIN MENU-----");
			System.out.println("1. Add a Record");
			System.out.println("2. Update a Record");
			System.out.println("3. Delete a Record");
			System.out.println("4. Print a Record");
			System.out.println("5. Hit 0 to EXIT");
			
			System.out.println("-----USER MENU-----");
			System.out.println("6. Book Ticket");
			System.out.println("7. Generate Ticket");
			System.out.println("8. View Previous Record");
			System.out.println("9. Hit -1 to EXIT");

			int userChoice = ab.nextInt();
			
			userChoiceSelector(userChoice);
			choiceSelector(userChoice);		


	}

}
