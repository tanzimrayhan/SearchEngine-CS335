***Installation***
To install the project, place all the java files and the text files in the same directory


***Compiling***
To compile the project open up command prompt, navigate to the directory where all the files are placed and run the following command :

javac SearchEngine.java

***Run the Program***
To run the program enter the following command in the command prompt/terminal and enter the following command:
java SearchEngine -CorpusDir <PathToTheHtmlFiles> -InvertedIndex InvertedIndex.txt -StopList StopList.txt -Queries QueryFIle.txt -Results ResultFile.txt -SnippetText Snippet.txt -FixedNum 25 -Enable

Please Make sure to put your own Corpus Directory withouth the '<>'

-CorpusDir      PathToTheHtmlFiles
-InvertedIndex  Name of the text file to save the inverted index in.
-StopList       Name of the text file to read the stop words from
-Queries        Name of the text file to read the queries that should be done on the corpus.
-Results        Name of the text file to save the results of the query in.
-SnippetText    Name of the text file to save the Snippet of the results from the corpus.
-FixedNum       How big of the snippet it should be from the exact result word, the number is Expected an integer.
-Enable         To enable Porters algorithm for stemming (Optional)



List of Input Files:
StopList.txt
QueryFile.txt



List of Output File:
InvertedIndex.txt
ResultFile.txt
Snippet.txt
PorteredInvertedIndex.txt