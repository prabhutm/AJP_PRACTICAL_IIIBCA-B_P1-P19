import java.util.Scanner;
import java.util.ArrayList;
class Practical3
{
public static void main(String[] args)
{
Scanner scanner = new Scanner(System.in);
// Step 1: Input Handling
System.out.println("Enter a line of text:");
String inputLine = scanner.nextLine();
// Step 2: Tokenization
String[] words = inputLine.split(" ");
// Step 3: Filtering Words starting with "b"
ArrayList<String> wordsStartingWithB = new ArrayList<>();
for (String word : words)
{

if (word.toLowerCase().startsWith("b"))

{ // Case insensitive check

wordsStartingWithB.add(word);
}
}
// Step 4: Filtering Words Ending with "ED"
ArrayList<String> wordsEndingWithED = new ArrayList<>();
for (String word : words)
{
if (word.toUpperCase().endsWith("ED"))

{ // Case insensitive check

wordsEndingWithED.add(word);
}
}
// Step 5: Print the Results

System.out.println("Words starting with 'b': " + wordsStartingWithB);
System.out.println("Words ending with 'ED': " + wordsEndingWithED);
}
}