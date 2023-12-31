import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class searchFileForString {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong number of arguments. Try: java searchFileForString <searchString> <fileName>");
            return;
        }

        String searchString = args[0];
        String fileName = args[1];

       try {
            List<String> allLinesInFile = Files.readAllLines(Paths.get(fileName));

            int lineCounter = 1;
            boolean foundAtLeastOnce = false;
            for (String line : allLinesInFile) {
                if(line.toLowerCase().contains(searchString.toLowerCase())){
                    
                    if(!foundAtLeastOnce){
                        foundAtLeastOnce = true;
                        System.out.println("\nFound the word \"" + searchString + "\": ");
                    }
                    System.out.println("Line " + lineCounter + ": " + line + "\n");
                }
                lineCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}