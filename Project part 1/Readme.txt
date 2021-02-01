The SearchEngine.java file contains the main method to run the project.
QueryFile.txt has the queries that have been done in the corpus.

Format for QuerFile.txt is as follows:

Query <WordThatYouWantToSearch> 



(without the "<>")

The results will be provided in the ResultFile.txt.

To run the project, go to the directory that has all the .java files, then open the commandpropt there.
and run the following commands.

javac SearchEngine.java
java SearchEngine -CorpusDir <PathToTheHtmlFiles> -InvertedIndex InvertedIndex.txt -StopList StopList.txt -Queries QueryFIle.txt -Results ResultFile.txt


Expected output in console should be similiar to this:
InvertedIndex= InvertedIndex.txt
Stoplist= StopList.txt
Finished making the stopList Hashmap
Corpus Directory= D:\CS_335\Tanzim\Java_Proj\HtmlFile
ResultFile= ResultFile.txt
In the constructor of  Index
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile1.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile10.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile11.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile2.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile3.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile4.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile5.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile6.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile7.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile8.html
Reading all the files from the directory D:\CS_335\Tanzim\Java_Proj\HtmlFile\htmlFile9.html
Check ResultFile.txt for results


NOTE: Due to the excessive memory usage, it takes a long time to search through 200 htmlfiles. The recommended limit is 10 html files.