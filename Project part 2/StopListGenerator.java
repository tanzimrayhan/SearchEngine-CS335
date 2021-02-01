/*StopListGenerator.java take the stopList text and reads it and stores all the stop words
 in a hashmap which is returned to main method by a getter method.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class StopListGenerator {
    public HashMap<Integer, String> stopList = new HashMap<>(); // hashmap to store all the stop words

    // Constructor that takes the name of the text file to read stop words from
    public StopListGenerator(String txt) {
        try {
            File myObj = new File(txt);
            Scanner myReader = new Scanner(myObj);
            int i = 0;

            // Reading all the lines from the file and putting it in the hashmap
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stopList.put(i, data);
                i++;
            }
            myReader.close();
            System.out.println("Finished making the stopList Hashmap");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Getter method
    public HashMap<Integer, String> getStopList() {
        return stopList;
    }
}
