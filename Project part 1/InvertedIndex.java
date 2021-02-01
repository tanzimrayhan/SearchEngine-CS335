import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;

public class InvertedIndex {

    HashMap<String, WordDetails> invertedIndex = new HashMap<>();

    public InvertedIndex(String invertedIndexText, String corpusDir, HashMap<Integer, String> stopList) {

        System.out.println("In the constructor of  Index");

        File folder = new File(corpusDir);
        File[] listOFiles = folder.listFiles();

        StringBuilder document = new StringBuilder();

        try {
            FileWriter writer = new FileWriter(invertedIndexText);
            BufferedReader reader;
            for (File f : listOFiles) {

                System.out.println("Reading all the files from the directory " + f);
                try {

                    reader = new BufferedReader(new FileReader(f));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        line = line.replaceAll("<[^>]*>", "");
                        if (!line.isEmpty()) {
                            document.append(line);
                        }

                    }
                    String doc = "" + document;
                    doc.replaceAll("<[^>]*>", "");
                    doc.replaceAll("[\\\r\\\n]+", "");
                    for (int i : stopList.keySet()) {
                        doc.replaceAll(stopList.get(i), "\n");
                    }

                    String[] words = doc.split(" ");

                    writer.write("Word\t\t" + "DocName\t\t" + "Index\n");
                    for (String w : words) {
                        if (!w.isEmpty()) {
                            writer.write(w + "\t\t" + f.getName().toString() + "\t\t" + document.indexOf(w) + "\n");
                            WordDetails wd = new WordDetails((f.getName().toString()), document.indexOf(w));
                            invertedIndex.put(w, wd);
                        }

                    }

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    public HashMap<String, WordDetails> getInvertedIndex() {
        return this.invertedIndex;
    }
}
