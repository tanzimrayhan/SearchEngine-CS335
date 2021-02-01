
// Object to store snippets of every query result
/* Snippet.java is a class that is used by the Query.java class to create the snippets after querying every word from the inverted index. 
The snippets are stored in an arraylist in query.java which later passed on to the main method using a getter method.*/
class Snippet {

    private String doc, word;
    private int index;

    // Constructor for qeury. It takes the word the docname to take snippet from and
    // the index of the word in the doc
    Snippet(String word, String docName, int index) {
        this.doc = docName;
        this.index = index;
        this.word = word;

    }

    // All the getters of the object
    public String getDocName() {
        return this.doc;
    }

    public String getWord() {
        return this.word;
    }

    public int getIndex() {
        return this.index;
    }
}
