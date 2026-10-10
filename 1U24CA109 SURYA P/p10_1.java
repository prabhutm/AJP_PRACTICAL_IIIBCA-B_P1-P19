import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class ReadResponsesFromFile
{
public static void main(String[] args)
{
try
{
Scanner scanner = new Scanner(new File("numbers.txt"));
PrintWriter pw = new PrintWriter("output.txt");
while (scanner.hasNextInt())
{
int response = scanner.nextInt();
pw.println(response);
}
scanner.close(); pw.close();
System.out.println("Responses read from numbers.txt and written
to output.txt successfully.");
}
catch (FileNotFoundException e)
{
System.out.println("Error: File not found.");
}
}
}