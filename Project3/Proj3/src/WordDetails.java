import java.util.ArrayList;
import java.util.HashMap;

public class WordDetails {
    private ArrayList<String> docNames = new ArrayList<>(); // the ArrayList contains just the docnames of the word that
                                                            // appeared in

    /*
     * For every word given a docname it has the integer ArrayList of values that
     * gives all the instances
     */
    private HashMap<String, ArrayList<Integer>> indecies = new HashMap<>();

    public WordDetails(String doc, int index) {
        // Checking if the docname is already appeaered before if yes then just add to
        // the indecies
        if (!this.docNames.isEmpty() && this.docNames.contains(doc)) {
            (indecies.get(doc)).add(index);
        }
        // Else adding the docname to the arraylist, storing the index and the which doc
        // that index belongs to
        else {

            this.docNames.add(doc);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(index);
            indecies.put(doc, temp);
        }

    }

    // Method to update the details of a specific word
    public void updateDetails(String document, int index1) {
        if (!this.docNames.isEmpty() && this.docNames.contains(document)) {
            (indecies.get(document)).add(index1);
        } else {

            this.docNames.add(document);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(index1);
            indecies.put(document, temp);
        }
    }

    // Add method just add a docname to the arraylist for a specific word
    public void addDoc(String documentName) {
        this.docNames.add(documentName);
    }

    // Getters
    public ArrayList<String> getDocNames() {
        return this.docNames;
    }

    public HashMap<String, ArrayList<Integer>> getIndex() {
        return this.indecies;
    }
}
