# File Part Reader

JUnit tests for Java classes that reads the file and provide analysis about that file.

## Classes description

FilePartReader class

It has three private instance member variables:
- filePath as String
- fromLine as Integer
- toLine as Integer
It has one no-argument constructor:
- it sets the class' instance variables to some default values

It has three instance methods:

public void setup - it's parameters are: 
- filePath as a String
- fromLine as an Integer
- toLine as an Integer
it throws an IllegalArgumentException:
- if toLine is smaller than fromLine
- if fromLine is smaller than 1 

private String read 
- opens the file on filePath, and gives back it's content as a String
- it doesn't catch the exception being raised, if the file isn't present on filePath, so actually the method throws the exception it received

public String readLines:
- reads the file with read()
- it gives back every line from it's content between fromLine and toLine (both of them are included), and returns these lines as a String. Take care because if fromLine is 1, it means the very first row in the file. Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.

FileWordAnalyzer class 

It has one constructor:
- it's parameter is a FilePartReader object

It has three instance methods:

public ArrayList wordsByABC:
- calls FilePartReader.readLines()
- returns the words ordered by alphabetically as an ArrayList

public ArrayList wordsContainingSubString(String subString):
- calls FilePartReader.readLines()
- returns the words which contains the subString

public ArrayList wordsArePalindrome():
- calls FilePartReader.readLines()
- returns the words from the String which are palindrome

Your task is to write at least the following test methods:

- testReadLinesBeforeSetup(): tests whether calling readLines() before setup() throws a FileNotFoundException.
- testSetupFromLineLT1(): tests whether calling setup() with fromLine argument less than (LT) 1 throws a IllegalArgumentException.
- testSetupToLineLTFromLine(): tests whether calling setup() with argument toLine less than fromLine throws a IllegalArgumentException.
- testReadLines1_2(): tests whether readLines() called to read first two lines returns expected string.
- testReadLines2_4(): tests reading lines from 2 to 4.
- testReadLinesAll(): tests reading all lines from file.
- testReadLinesPastEof(): test reading when toLine is past End Of File.


## More info

Project made for [Codecool](https://codecool.com/) programming course.
