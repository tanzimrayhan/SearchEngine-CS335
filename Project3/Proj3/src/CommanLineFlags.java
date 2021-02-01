public class CommanLineFlags {
    private String stopListText, invertedIndex, corpusDir, queryFile, resultFile, snippetText;
    private boolean stemmingSwitch = false;

    // Fixed num is used to store the int fixed num to cut the snippets from the
    // index.
    // It is initialed as a default value of 10 so that in case if user does not
    // provide it, the code will still run
    private int fixedNum = 10;

    CommanLineFlags(String[] argv) {
        for (int i = 0; i < argv.length; i++) {

            // Reading the StopList flag
            if (argv[i].startsWith("-StopList")) {
                System.out.println("Stoplist= " + argv[i + 1]);
                this.stopListText = argv[i + 1];
            }
            // Reading the InvertedIndex flag
            if (argv[i].startsWith("-InvertedIndex")) {
                System.out.println("InvertedIndex= " + argv[i + 1]);
                this.invertedIndex = argv[i + 1];
            }
            // Reading the Corpus Directory flag
            if (argv[i].startsWith("-CorpusDir")) {
                this.corpusDir = argv[i + 1];
            }
            // Reading the Query file flag
            if (argv[i].startsWith("-Queries")) {
                this.queryFile = argv[i + 1];
            }

            // Reading the Results file flag
            if (argv[i].startsWith("-Results")) {
                this.resultFile = argv[i + 1];
            }

            // Reading the snippet file flag
            if (argv[i].startsWith("-SnippetText")) {
                System.out.println("SnippetText= " + argv[i + 1]);
                this.snippetText = argv[i + 1];
            }

            // Checking if porters algorithm is enabled or not
            if (argv[i].startsWith("-Enable")) {
                this.stemmingSwitch = true;
            }

            // Getting the fixed number to cut the snippets from the command line
            if (argv[i].startsWith("-FixedNum")) {
                this.fixedNum = Integer.parseInt(argv[i + 1]);
            }
        }
    }

    // All the getters to get the values from other classes.
    public int getFixedNum() {
        return this.fixedNum;
    }

    public boolean getStemmingSwitch() {
        return this.stemmingSwitch;
    }

    public String getSnippetText() {
        return this.snippetText;
    }

    public String getStopListText() {
        return this.stopListText;
    }

    public String getInvertedIndex() {
        return this.invertedIndex;
    }

    public String getCorpusDir() {
        return this.corpusDir;
    }

    public String getResultFile() {
        return this.resultFile;
    }

    public String getQueryFile() {
        return this.queryFile;
    }
}
