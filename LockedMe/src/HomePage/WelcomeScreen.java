package HomePage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WelcomeScreen {
    private static JTabbedPane tabbedPane;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Welcome Screen");

        // Set the frame size and close operation
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a tabbed pane
        tabbedPane = new JTabbedPane();

        // Add the main tab
        JPanel mainTab = createMainTab();
        tabbedPane.addTab("Main", null, mainTab, "Main Options");

        // Add the tabbed pane to the frame
        frame.add(tabbedPane);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static JPanel createMainTab() {
        JPanel mainTabPanel = new JPanel(new BorderLayout());

        // Create a combo box for user options
        String[] options = {"Select an option", "List Files (Ascending Order)", "Add File", "Delete File", "Search File"};
        JComboBox<String> optionComboBox = new JComboBox<>(options);
        mainTabPanel.add(optionComboBox, BorderLayout.NORTH);

        // Create a text field for user input
        JTextField userInputField = new JTextField();
        mainTabPanel.add(userInputField, BorderLayout.CENTER);

        // Create a button to perform the selected action
        JButton actionButton = new JButton("Perform Action");
        mainTabPanel.add(actionButton, BorderLayout.SOUTH);

        // Add an action listener to the button
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = optionComboBox.getSelectedItem().toString();
                String userInput = userInputField.getText();

                switch (selectedOption) {
                    case "List Files (Ascending Order)":
                        listFilesInAscendingOrder();
                        break;
                    case "Add File":
                        addFile(userInput);
                        break;
                    case "Delete File":
                        deleteFile(userInput);
                        break;
                    case "Search File":
                        searchFile(userInput);
                        break;
                    default:
                        // Handle invalid option
                        JOptionPane.showMessageDialog(null, "Invalid option selected.");
                }
            }
        });

        return mainTabPanel;
    }

    private static void listFilesInAscendingOrder() {
        // Implement the logic to list files in ascending order here
        // You can use the File class to interact with the file system
        // Display the result to the user
        JOptionPane.showMessageDialog(null, "List of files in ascending order:\n" + "File1.txt\nFile2.txt");
    }

    private static void addFile(String fileName) {
        // Implement the logic to add a file to the directory list here
        // You can use the File class to create a new file
        // Handle case insensitivity
        // Display the result to the user
        JOptionPane.showMessageDialog(null, "File added successfully: " + fileName);
    }

    private static void deleteFile(String fileName) {
        // Implement the logic to delete a file from the directory list here
        // You can use the File class to delete a file
        // Handle case sensitivity and file not found
        // Display the result to the user
        JOptionPane.showMessageDialog(null, "File deleted successfully: " + fileName);
    }

    private static void searchFile(String fileName) {
        // Implement the logic to search for a file in the directory list here
        // You can use the File class to search for a file
        // Handle case sensitivity and display results upon success or failure
        JOptionPane.showMessageDialog(null, "File found: " + fileName);
    }
}
