import java.util.HashMap;class CharacterCount
{
public static void main(String[] args)
{
String inputString = "HELLO THERE";
HashMap<Chger> charCountMap=countCharacters(inputString);
printCharacterCount(charCountMap);
}
public static HashMap<Character, Integer> countCharacters(String inputString)
{
HashMap<Character, Integer> charCountMap = new HashMap<>();
// Iterate through the characters of the string
for (int i = 0; i < inputString.length(); i++)
{
char c = inputString.charAt(i);
if (Character.isLetter(c))
{
// Convert character to uppercase to ignore case
c = Character.toUpperCase(c);
// Update count in the map
if (charCountMap.containsKey(c))
{
charCountMap.put(c, charCountMap.get(c) + 1);
}
else
{
charCountMap.put(c, 1);
}
}
return charCountMap;
}
public static void printCharacterCount(HashMap<Character, Integer>
charCountMap)
{
// Iterate through the map and print the counts
for (char c : charCountMap.keySet())
{
System.out.println(c + ": " + charCountMap.get(c));
}

} }