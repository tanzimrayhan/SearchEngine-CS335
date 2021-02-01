import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class InvertedIndex {

    HashMap<String, WordDetails> invertedIndex = new HashMap<>(); // Hashmap to store all the words and the deatils of
                                                                  // each words
    StringBuilder document = new StringBuilder(); // StringBuilder is used to store the html files as a string
    HashMap<Integer, String> stopList = new HashMap<>(); // An empty hashmap to store the stoplists for later usage

    public InvertedIndex(String invertedIndexText, String corpusDir, HashMap<Integer, String> stopList) {
        this.stopList = stopList;

        File folder = new File(corpusDir); // The folder of the html files
        File[] listOFiles = folder.listFiles(); // All the html files are stored in an array

        System.out.println("\n \n Reading all the files from the directory " + corpusDir
                + "This might take a while, please wait...");
        BufferedReader reader;

        // Reading all the files from the listOfFiles array
        for (File f : listOFiles) {

            try {
                // Taking one file at a time and reading each line.
                reader = new BufferedReader(new FileReader(f));
                String line; // To store each lines of the file.

                while ((line = reader.readLine()) != null) {

                    // Removing all the special characters and html tags from the lines.
                    line = line.replaceAll("<[^>]*>", "\n");
                    line = line.replaceAll("[^a-zA-Z0-9\\s+]", " ");

                    // Adding the line to document stringBuilder
                    if (!line.isEmpty()) {
                        document.append(line);
                    }

                }

                // Create index method is called to create the index of the file.
                createIndex(f.getName().toString());
                document = new StringBuilder();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
        System.out.println("Writing the inverted index to the txt file now, please wait patiently");

        // Write file method is called to write the inverted index in a text file.
        writeFile(invertedIndexText);

    }

    public void createIndex(String fileName) {
        String doc = "";

        // Removing all the stoplists from the document stringBuilder and separating
        // words with new lines
        for (int i : stopList.keySet()) {
            doc = document.toString().replaceAll(stopList.get(i), " \n");
        }

        // Getting all the words from a line
        for (String w : doc.split(" ")) {
            if (!w.isEmpty()) {
                // Creating the object WordDeatails from a given word and putting it in the
                // hashmap with the key of that word.
                WordDetails wd = new WordDetails(fileName, document.indexOf(w));
                invertedIndex.put(w, wd);
            }
        }
    }

    // Method to write the inverted index in a text file.
    public void writeFile(String fileToWrite) {
        FileWriter writer;
        try {
            writer = new FileWriter(fileToWrite);

            for (String s : invertedIndex.keySet()) {
                writer.write(s + "\t\t\n");
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public HashMap<String, WordDetails> getInvertedIndex() {
        return this.invertedIndex;
    }
}
