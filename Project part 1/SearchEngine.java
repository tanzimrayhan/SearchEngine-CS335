import java.util.HashMap;

/**
 * SearchEngine
 */
public class SearchEngine {

    public static void main(String[] args) {
        String stopListText, invertedIndexText, corpusDir, queryFile, resultFile;
        CommanLineFlags flags = new CommanLineFlags(args);

        stopListText = flags.getStopListText();

        HashMap<Integer, String> stopList = new HashMap<>();
        HashMap<String, WordDetails> invertedIndex = new HashMap<>();

        try {
            StopListGenerator sg = new StopListGenerator(stopListText);

            stopList = sg.getStopList();

        } catch (Exception e) {

            System.out.println("There are no stop list provided");
        }

        invertedIndexText = flags.getInvertedIndex();
        corpusDir = flags.getCorpusDir();
        queryFile = flags.getQueryFile();
        resultFile = flags.getResultFile();

        if (invertedIndexText == null) {
            System.out.println("No inverted index provided");
        }
        if (corpusDir == null) {
            System.out.println("No corpus dir provided");
        }

        else {
            System.out.println("Corpus Directory= " + corpusDir);
            System.out.println("ResultFile= " + resultFile);

            InvertedIndex index = new InvertedIndex(invertedIndexText, corpusDir, stopList);

            invertedIndex = index.getInvertedIndex();

            Query q = new Query(invertedIndex, queryFile, resultFile);
        }

    }
}