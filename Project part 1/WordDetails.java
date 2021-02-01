import java.security.DomainCombiner;
import java.util.ArrayList;
import java.util.HashMap;

public class WordDetails {
    private ArrayList<String> docNames = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> indecies = new HashMap<>();

    public WordDetails(String doc, int index) {

        if (!this.docNames.isEmpty() && this.docNames.contains(doc)) {
            (indecies.get(doc)).add(index);
        } else {

            this.docNames.add(doc);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(index);
            indecies.put(doc, temp);
        }

    }

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

    public void addDoc(String documentName) {
        this.docNames.add(documentName);
    }

    public ArrayList<String> getDocNames() {
        return this.docNames;
    }

    public HashMap<String, ArrayList<Integer>> getIndex() {
        return this.indecies;
    }
}
