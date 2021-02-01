The SearchEngine.java file contains the main method to run the project.
QueryFile.txt has the queries that have been done in the corpus.

Format for QuerFile.txt is as follows:

Query <WordThatYouWantToSearch> 

(without the "<>")

The results will be provided in the ResultFile.txt.

To run the project, go to the directory that has all the .java files, then open the commandpropt there.
and run the following commands.

javac SearchEngine.java
java SearchEngine -CorpusDir <PathToTheHtmlFiles> -InvertedIndex InvertedIndex.txt -StopList StopList.txt -Queries QueryFIle.txt -Results ResultFile.txt -SnippetText Snippet.txt -FixedNum 25 -Enable


To run it without Porters Algorithm:
java SearchEngine -CorpusDir <PathToTheHtmlFiles> -InvertedIndex InvertedIndex.txt -StopList StopList.txt -Queries QueryFIle.txt -Results ResultFile.txt -SnippetText Snippet.txt -FixedNum 25


CommanLineFlags.java is the name of the class that has been used in the main method to read all the arguments that are passed in via the command line.
List of arguments with their description are as follows:

-CorpusDir      PathToTheHtmlFiles
-InvertedIndex  Name of the text file to save the inverted index in.
-StopList       Name of the text file to read the stop words from
-Queries        Name of the text file to read the queries that should be done on the corpus.
-Results        Name of the text file to save the results of the query in.
-SnippetText    Name of the text file to save the Snippet of the results from the corpus.
-FixedNum       How big of the snippet it should be from the exact result word, the number is Expected an integer.
-Enable         To enable Porters algorithm for stemming (Optional)


InvertedIndex.java class is used to read all the html files from the corpus directory and create a hashmap of inverted index and store them in a text file. 
The hashmap for storing the inverted index take the word itself as the key and the value is WordDetails obj which contains all the details of the word.
If there are multiple instances of words it uses hashing with chaining to store the information.


WordDetails.java is used to create object to store all the information regarding a word. 
It uses an Arraylist of docnames to store all the names of the document the word appeared in.
It also has another hashmap that takes the docname string as the key and returns the indexes in which the word appeared. The indexes are stored in an Arraylist

ArrayList<String> docNames = new ArrayList<>(); //So the ArrayList contains just the docnames of the word that appeared in.
HashMap<String, ArrayList<Integer>> indecies = new HashMap<>(); //For every word given a docname it has the integer ArrayList of values that gives all the instances


StopListGenerator.java take the stopList text and reads it and stores all the stop words in a hashmap which is returned to main method by a getter method.


Snippet.java is a class that is used by the Query.java class to create the snippets after querying every word from the inverted index. 
The snippets are stored in an arraylist in query.java which later passed on to the main method using a getter method.

Query.java is used to search the words that are provided in the QuerFile.txt. The constructor of of Query.java takes the invertedIndex hashmap, the queryfile text and the result file text.
It gets words from the queryfile.txt and searches the invertedIndex for it and then saves the result in the resultfile.txt. It also creates the snippets which would be used later
by the main method to write the snippets from the docs to the snippet.txt


WriteSnippets.java is a helper class that just takes the snippet object and the file to write the snippets in. It just uses file writer to write the snippets in the text file.


Stemmer.java contains the Porters Algorithm for stemming. It is taken from https://tartarus.org/martin/PorterStemmer/java.txt


Expected output in console should be similiar to this:
InvertedIndex= InvertedIndex.txt
Stoplist= StopList.txt
Finished making the stopList Hashmap
Corpus Directory= D:\CS_335\Tanzim\Java_Proj\HtmlFile
ResultFile= ResultFile.txt
In the constructor of  Index
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile This might take a while, please wait...
Writing the inverted index to the txt file now, please wait patiently
Porters algorithm enabled
Stemming all the words of inverted index, please wait patiently...
Check ResultFile.txt for results


SearchEngine.java contains the main method of the project. It build the other components such as invertedindex , queries that are necessary to run the project.
