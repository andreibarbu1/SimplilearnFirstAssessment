package simplilearn.vdf.assessment1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
	
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Welcome user!  Choose one of the following:");
		System.out.println("1.SORT files in ASCENDING order");
		System.out.println("2.ADD file");
		System.out.println("3.DELETE file");
		System.out.println("4.SEARCH file");
		System.out.println("0.EXIT");
		choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			
			// User input for the file path
	         Scanner sc1 = new Scanner(System.in);
	         System.out.println("Enter the file path: ");
	         String dirPath = sc1.nextLine();  

	        //list the number of files in specified path
	         File folder = new File(dirPath);
	         if(folder.isDirectory()){
	             File[] fileList = folder.listFiles();
	             Arrays.sort(fileList);
	             System.out.println("\nIn the specified folder are a total number of " + fileList.length + " files." );
	             	             
	             // Shows the files from specified folder in unsorted order
	             for(File file:fileList){
	                 System.out.println(file.getName());
	             }
	             
	             // Creating a filter to return only files.
	             FileFilter fileFilter = new FileFilter(){
	                 @Override
	                 public boolean accept(File file) {
	                     return !file.isDirectory();
	                 }
	             };

	             fileList = folder.listFiles(fileFilter);
	            
	             // Sort files by name
	             Arrays.sort(fileList, new Comparator(){
	                 @Override
	                 public int compare(Object f1, Object f2) {
	                     return ((File) f1).getName().compareTo(((File) f2).getName());
	                 }
	             });	             
	             System.out.println("---------------");
	             
	             // Show the files in ascending order
	             for(File file:fileList){
	            	 
	                 System.out.println(file.getName());
	             }

	         }
	         break;
		case 2:
			try {
				// User input for file name
			Scanner sc2 = new Scanner(System.in);
	        System.out.print("Please enter a file name: ");
	        String fileName = sc2.nextLine();
	        fileName = fileName + ".txt";
	        
	       
	        File file = new File(fileName);
	        
	        
	        if (file.createNewFile()) {
	            System.out.println("File created.");
	        } else {
	            System.out.println("File already exists.");
	        }
	        }
	        catch(Exception exc) {
	        exc.printStackTrace();
	        }
			break;
		case 3:
			String filename;
			//User input for file name
		      Scanner sc3 = new Scanner(System.in);
		      System.out.print("Please enter a file name: ");
		      filename = sc3.nextLine();
		      
		      File myfile = new File(filename);
		      
		      if(myfile.delete())
		         System.out.println("File deleted.");
		      else
		         System.out.println("File doesn't exist.");
		      
		      break;
		      
		case 4:
			File fileName;
		    Scanner sc4 = new Scanner(System.in);
		    String userInput;
		 
		    //User input for file name
		    System.out.print("Please enter a file name: ");
		    userInput = sc4.nextLine();
		    fileName = new File(userInput);
		     
		    //Repeat prompt if invalid until valid
		    while(!(fileName).exists()){ 
		    System.out.println("Invalid file input.");
		    System.out.println("\nPlease reenter a file name: ");
		    userInput = sc4.nextLine();
		    fileName = new File(userInput);
		    }
		    break;
					
		}}while(choice != 0);
}}


