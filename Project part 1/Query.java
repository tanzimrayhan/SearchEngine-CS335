import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Query {
    Query(HashMap<String, WordDetails> invertedIndex, String queryFile, String resultFile) {
        int condition = 0;
        File queryReader = new File(queryFile);
        Scanner myReader;
        FileWriter result;

        String word = "";

        try {
            myReader = new Scanner(queryReader);
            result = new FileWriter(resultFile);
            while (myReader.hasNextLine()) {
                String query = myReader.nextLine();
                word = query.split(" ")[1];
                for (String w : invertedIndex.keySet()) {

                    if (w.contains(word)) {
                        WordDetails details = invertedIndex.get(w);

                        ArrayList<String> docNames = details.getDocNames();

                        for (String s : docNames) {
                            ArrayList<Integer> indecies = details.getIndex().get(s);

                            for (int i : indecies) {

                                result.append(query + " " + " found in " + s + " at index " + i + "\n");

                                condition = 1;
                            }
                        }
                    }
                }

            }
            result.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (condition == 0) {
            System.out.println("Word not found in the corpus");
        } else {
            System.out.println("Check ResultFile.txt for results");
        }

    }

}
