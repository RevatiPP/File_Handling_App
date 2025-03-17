import java.io.*;
import java.util.Scanner;

public class FileHandlerApp {
    private static final String FILE_NAME = "sample.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nFile Handling Utility");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    writeFile();
                    break;
                case 2:
                    readFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Write data to file
    private static void writeFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            System.out.print("Enter text to write to file: ");
            String content = scanner.nextLine();
            writer.write(content + "\n");
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Read data from file
    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nFile Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Modify file content (Overwrite with new content)
    private static void modifyFile() {
        System.out.print("Enter new content to overwrite the file: ");
        String newContent = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME)) { // Overwrite file
            writer.write(newContent + "\n");
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }
}
