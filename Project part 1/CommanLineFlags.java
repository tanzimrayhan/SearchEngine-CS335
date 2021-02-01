public class CommanLineFlags {
    private String stopListText, invertedIndex, corpusDir, queryFile, resultFile;

    CommanLineFlags(String[] argv) {
        for (int i = 0; i < argv.length; i++) {

            if (argv[i].startsWith("-StopList")) {
                System.out.println("Stoplist= " + argv[i + 1]);
                this.stopListText = argv[i + 1];
            }

            if (argv[i].startsWith("-InvertedIndex")) {
                System.out.println("InvertedIndex= " + argv[i + 1]);
                this.invertedIndex = argv[i + 1];
            }

            if (argv[i].startsWith("-CorpusDir")) {
                this.corpusDir = argv[i + 1];
            }
            if (argv[i].startsWith("-Queries")) {
                this.queryFile = argv[i + 1];
            }
            if (argv[i].startsWith("-Results")) {
                this.resultFile = argv[i + 1];
            }

        }
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
