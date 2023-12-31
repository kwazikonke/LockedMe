package HomePage;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeApplication {

	//Defining constant DIRECTORY_PATH where the files will be stored
	
	private static final String DIRECTORY_PATH = "myDb";
	
	// Creating Scanner object named scanner to read user input
	private static final Scanner scanner = new Scanner(System.in); 
	 
	public static void main(String[] args) {
	
		// Creating the repository directory
		// Check if the myDb directory exists
		// If it doesn't exist, we create it using mkdir().
		
        File directory = new File(DIRECTORY_PATH);
        if (!directory.exists()) {
            directory.mkdir();
        }
        
        // Showing the first welcome screen with options
        
        WelcomeScreen();
        
        // getting the user's choice and execute the corresponding action
        // based on the selected menu option
        
        while (true) {
            int userChoice = userInput();

            switch (userChoice) {
                case 1:
                    viewFiles();
                    break;
                case 2:
                    uploadFile();
                    break;
                case 3:
                    deleteFile();
                    break;
                case 4:
                    searchFile();
                    break;
                case 5:
                	  System.out.println("Application closed!!!");
                      System.exit(0);
                  default:
                      System.out.println("Invalid choice, Please try again!");
              }
          }
      }
	
	  // Displaying the welcome screen and available menu options
	
        private static void WelcomeScreen() {
        System.out.println("Welcome to LockedMe Application!!!\n");
        System.out.println("Developer: Kwazikonke Mbatha\n");
        System.out.println("-------------!!-------------");
        System.out.println("Menu options:");
        System.out.println("1. View Files in Ascending Order");
        System.out.println("2. Upload a File");
        System.out.println("3. Delete a File");
        System.out.println("4. Search for a File");
        System.out.println("5. Close the Application\n");
    }
        
     // Prompting the user to enter their choice and returning the integer entered by the user
        
        private static int userInput() {
            System.out.print("Choose a task you wish to perform (1,2,3,4,5) : ");
            return scanner.nextInt();
        }
        
     // listing the files in the specified directory (myDB) in ascending order
        private static void viewFiles() {
        	
            File dir = new File(DIRECTORY_PATH);
            String[] files = dir.list();
            
    // Checking if there are files in the directory and sorts and displays them if found
            
            if (files != null && files.length > 0) {
                Arrays.sort(files);
                System.out.println("Files in ascending order:");
                
                for (String file : files) {
                    System.out.println(file);
                }
            } 
            else {
                System.out.println("The directory is empty.");
            }
        }
        
      // Prompting the user to enter a file name
        
        private static void uploadFile() {
            System.out.print("Enter the name of the file: ");
            String fileName = scanner.next();
            
       // Checking if the file already exists, and then creates the file if it doesn't exist
            
            File file = new File(DIRECTORY_PATH + File.separator + fileName);
            
            if (file.exists()) {
                System.out.println("File already exists");
            } 
            else {
                try {
                    if (file.createNewFile()) {
                        System.out.println("File added successfully.");
                    } else {
                        System.out.println("Failed to add the file.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Deleting a file by specifying the file name
        
        private static void deleteFile() {
            System.out.print("Enter the name of the file to delete: ");
            String fileName = scanner.next();
            File file = new File(DIRECTORY_PATH + File.separator + fileName);
            
         // Checking if the file exists and attempts to delete it, 
        // providing appropriate feedback to the user
            
            if (file.exists() && file.delete()) {
                System.out.println("File deleted successfully.");
            } 
            else {
                System.out.println("File not found or unable to delete.");
            }
        }
      
        //Searching for a file by specifying the file name
        
        private static void searchFile() {
            System.out.print("Enter the name of the file to search: ");
            String fileName = scanner.next();
            File file = new File(DIRECTORY_PATH + File.separator + fileName);
            
       // Checking if the file exists and provides the file's path if found 
       // or notifies the user if the file is not found
            
            if (file.exists()) {
                System.out.println("File found at: " + file.getAbsolutePath());
            } 
            else {
                System.out.println("File not found.");
            }
        }
	}
