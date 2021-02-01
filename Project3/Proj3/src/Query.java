/* Query.java is used to search the words that are provided in the QuerFile.txt. The constructor of of Query.java takes the invertedIndex hashmap, the queryfile text and the result file text.
It gets words from the queryfile.txt and searches the invertedIndex for it and then saves the result in the resultfile.txt. It also creates the snippets which would be used later
by the main method to write the snippets from the docs to the snippet.txt */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class Query {
    ArrayList<Snippet> snips = new ArrayList<>(); // Arraylist of snippets to store all the snippets of each results
    DefaultListModel<String> listModel = new DefaultListModel<>();

    Query(HashMap<String, WordDetails> invertedIndex, String searchWord) {

        int condition = 0;

        for (String w : invertedIndex.keySet()) {

            if (w.contains(searchWord)) {

                // If the word is found getting wordDetails from the invertedIndex
                WordDetails details = invertedIndex.get(w);

                ArrayList<String> docNames = details.getDocNames();

                // Writing where the word has been appeared at what index and every details
                for (String s : docNames) {
                    ArrayList<Integer> indecies = details.getIndex().get(s);

                    for (int i : indecies) {

                        listModel.addElement(searchWord + " " + " found in " + s + " at index " + i + "\n");

                        condition = 1;
                        Snippet snippet = new Snippet(searchWord, s, i);
                        snips.add(snippet);
                    }
                }
            }
        }

        if (condition == 0) {
            System.out.println("Word not found in the corpus");
        } else {
            System.out.println("Check ResultFile.txt for results");
        }
    }

    Query(HashMap<String, WordDetails> invertedIndex, String queryFile, String resultFile) {
        int condition = 0; // Condition is an integer which is used to check if the word is found.
        File queryReader = new File(queryFile); // QueryFile.txt
        Scanner myReader;
        FileWriter result; // To write the result file

        String word = "";

        try {
            myReader = new Scanner(queryReader);
            result = new FileWriter(resultFile);

            // Reading all the lines of query file.
            while (myReader.hasNextLine()) {
                String query = myReader.nextLine();
                word = query.split(" ")[1]; // Getting the word to query

                // Checking if the word is in inverted index
                for (String w : invertedIndex.keySet()) {

                    if (w.contains(word)) {

                        // If the word is found getting wordDetails from the invertedIndex
                        WordDetails details = invertedIndex.get(w);

                        ArrayList<String> docNames = details.getDocNames();

                        // Writing where the word has been appeared at what index and every details
                        for (String s : docNames) {
                            ArrayList<Integer> indecies = details.getIndex().get(s);

                            for (int i : indecies) {

                                result.append(query + " " + " found in " + s + " at index " + i + "\n");

                                condition = 1;
                                Snippet snippet = new Snippet(word, s, i);
                                snips.add(snippet);
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
        // Checking if the word is found or not. if not printing not found message
        if (condition == 0) {
            System.out.println("Word not found in the corpus");
        } else {
            System.out.println("Check ResultFile.txt for results");
        }

    }

    public ArrayList<Snippet> getSnippets() {

        return this.snips;
    }

    public DefaultListModel<String> getListModel() {
        return this.listModel;
    }

}
