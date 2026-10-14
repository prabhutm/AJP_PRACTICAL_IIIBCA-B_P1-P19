import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class WriteResponsesToFile
{
public static void main(String[] args)
{
try {
Formatter formatter = new Formatter("e:\\numbers.txt");
Scanner scanner = new Scanner(System.in);
System.out.println("Enter survey responses type done to finish");
String input;
while (!(input = scanner.nextLine()).equalsIgnoreCase("done"))
{
try
{
int number = Integer.parseInt(input);
formatter.format("%d%n", number);
}
catch (NumberFormatException e)
{
System.out.println("Invalid input"+e);
}
}

formatter.close();
scanner.close();
System.out.println("Responses written to numbers.txt successfully.");
}
catch (FileNotFoundException e)
{
System.out.println("Error: File not found.");
}
}
}