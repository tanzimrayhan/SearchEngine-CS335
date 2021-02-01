import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class StopListGenerator {
    public HashMap<Integer, String> stopList = new HashMap<>();

    public StopListGenerator(String txt) {
        try {
            File myObj = new File(txt);
            Scanner myReader = new Scanner(myObj);
            int i = 0;
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

    public HashMap<Integer, String> getStopList() {
        return stopList;
    }
}
