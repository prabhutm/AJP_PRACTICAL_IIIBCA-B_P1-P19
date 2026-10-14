class ExceptionA extends Exception
{
public ExceptionA(String message)
{
super(message);
}
// Additional constructors or methods can be added if needed
}
// ExceptionB inherits from ExceptionA
class ExceptionB extends ExceptionA
{
public ExceptionB(String message)
{
super(message);
}
// Additional constructors or methods can be added if needed
}
class Practical2
{
public static void main(String[] args)
{
// Step 2: Creating main() - Declare variables and objects as needed
// Step 3: Using try blocks to encapsulate code sections
try
{
// Throw an exception of type ExceptionA
throw new ExceptionA("This is ExceptionA");
} catch (Exception e) { // Catch block for ExceptionA
System.out.println("Caught: " + e.getMessage());
}
try
{
// Throw an exception of type ExceptionB
throw new ExceptionB("This is ExceptionB");
} catch (Exception e)
{ // Catch block for ExceptionB
System.out.println("Caught: " + e.getMessage());
}
try {
// Throw an IOException
throw new java.io.IOException("This is an IOException");
}
catch (Exception e)
{ // Catch block for IOException
System.out.println("Caught: " + e.getMessage());
}
try
{

// For NullPointerException, initialize a null string and calculate the length of the string
String nullString = null;
System.out.println(nullString.length());
}
catch (Exception e)
{ // Catch block for NullPointerException
System.out.println("Caught: " + e.getMessage());
}
}
}