import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * SearchEngine
 */
public class SearchEngine {
    // ArrayList of object Snippet to store all the snippets.
    static ArrayList<Snippet> snips = new ArrayList<>();

    public static void main(String[] args) {

        // Strings to store the name of of various text files.
        String stopListText, invertedIndexText, corpusDir, queryFile, resultFile, snippetText;

        // flags object is created to read the command line flags.
        CommanLineFlags flags = new CommanLineFlags(args);

        stopListText = flags.getStopListText();

        HashMap<Integer, String> stopList = new HashMap<>();

        // Hashmap to store the inverted index in. The key are the words it self and the
        // value is obj wordDetails.
        HashMap<String, WordDetails> invertedIndex = new HashMap<>();

        try {
            // Stop list generator is used to generate a hashmap of stoplist by reading the
            // stoplist text
            StopListGenerator sg = new StopListGenerator(stopListText);

            // Getting the hashmap and storing it in stoplist hashmap
            stopList = sg.getStopList();

        } catch (Exception e) {

            System.out.println("There are no stop list provided");
        }

        // Getting all the values from the commandLineFlags class.
        invertedIndexText = flags.getInvertedIndex();
        corpusDir = flags.getCorpusDir();
        queryFile = flags.getQueryFile();
        resultFile = flags.getResultFile();
        snippetText = flags.getSnippetText();

        boolean stemmerSwitch = flags.getStemmingSwitch();
        int fixedNum = flags.getFixedNum();

        // Checking if all the files are provided via the commandLine flags
        if (invertedIndexText == null) {
            System.out.println("No inverted index provided");
        }
        if (corpusDir == null) {
            System.out.println("No corpus dir provided");
        }
        if (queryFile == null) {
            System.out.println("No query file provided");
        }
        if (resultFile == null) {
            System.out.println("No result file provided to store the results");
        }
        if (snippetText == null) {
            System.out.println("No snippet file provided to write the snippets of the results");
        }

        else {
            System.out.println("Corpus Directory= " + corpusDir);
            System.out.println("ResultFile= " + resultFile);

            // Inerted index is created using the InvertedIndex class.
            InvertedIndex index = new InvertedIndex(invertedIndexText, corpusDir, stopList);

            invertedIndex = index.getInvertedIndex();

            if (stemmerSwitch == true) {
                System.out.println("Porters algorithm enabled");
                String[] argv = { invertedIndexText };
                Stemmer.main(argv);
            }

            // Querying the inverted index , taking the query words from query file and
            // saving the results to result file
            Query q = new Query(invertedIndex, queryFile, resultFile);

            // Getting the snippets after querying from the query object
            snips = q.getSnippets();
            try {
                WriteSnippets write = new WriteSnippets(snips, corpusDir, fixedNum, snippetText);
                System.out.println("Check Snippet.txt for snippets of the results.");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}