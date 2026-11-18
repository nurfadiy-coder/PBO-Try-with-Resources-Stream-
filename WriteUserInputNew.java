import java.io.*; 
import java.nio.file.*; 
import java.util.Scanner; 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteUserInputNew { 
    public static void main(String[] args) { 
        try (Scanner sc = new Scanner(System.in)) { 
            while (true) { 
                System.out.print("Enter text (type 'exit' to quit): "); 
                String text = sc.nextLine(); 
                if (text.equalsIgnoreCase("exit")) { 
                    break; 
                } 
                LocalDateTime timestamp = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedTimestamp = timestamp.format(formatter);
                try (BufferedWriter bw = Files.newBufferedWriter(Paths.get("user_input.txt"), 
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND)) { 
                    bw.write("[" + formattedTimestamp + "] " + text); 
                    bw.newLine();
                    System.out.println("Saved!" + " [" + formattedTimestamp + "] " + text); 
                } catch (IOException e) { 
                    System.out.println("Error: " + e.getMessage()); 
                } 
            }
        } 
    } 
}