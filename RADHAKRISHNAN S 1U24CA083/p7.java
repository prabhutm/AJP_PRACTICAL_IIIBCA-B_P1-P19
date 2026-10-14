import java.util.Scanner;
import java.util.TreeSet;
public class TokenizeAndSort
{
public static void main(String[] args)
{
// Get the input from the user
Scanner scanner = new Scanner(System.in);
System.out.println("Enter a line of text:");
// String inputText ="this is unit2 Java program";
String inputText = scanner.nextLine();
// Tokenize the Input text into individual words
String[] tokens = inputText.split("\\s+");
TreeSet<String> tokenSet = new TreeSet<>();
for (int i = 0; i < tokens.length; i++){
tokenSet.add(tokens[i]);
}
System.out.println("Tokens in ascending sorted order:");
for (String token : tokenSet){
System.out.println(token);
}
scanner.close();

}}