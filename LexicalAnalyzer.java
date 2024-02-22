
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import parse.ParseTree;
import parse;


public class LexicalAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {        
        //Take code input from file
    ArrayList<String> lines = new ArrayList<>(); // Declare the 'lines' variable
    Scanner reader = new Scanner(new File("C:\\Users\\matth\\Downloads\\Sem 2, Junior Year\\COMP 360\\input.txt"));
    while (reader.hasNextLine()) {
        String str = reader.nextLine();
        if (!(str.length() == 0)) {
            String [] strSplit = str.trim().split("\\s+|\\s*,\\s*|\\;+|\\\"+|\\:+|\\[+|\\]+");     
            List <String> list = Arrays.asList(strSplit);
            lines.addAll(list);
        }
    }
    reader.close();
    List<String> lexemes = lines;
    ParseTree parseTree = parse.parseExpression(lexemes);
    System.out.println("The lexemes: ");
    System.out.println(lines);
        
        //Add values from ArrayList to HashMap Key keywords
        List<String> keywords = new ArrayList<String>(); 
        String [] keywordArray = lines.toArray(new String [0]);
        if (lines.contains("int") || lines.contains("float") || lines.contains("while") || lines.contains("void")) {         
        	 for (int count = 0;  count < keywordArray.length; count++) {
             	if (keywordArray[count].equals("float")) {
                     // Add a descriptive label for left parenthesis
                     keywords.add("float-Keyword \n");
                 } else if (keywordArray[count].equals("void")) {
                     // Add a descriptive label for right parenthesis
                     keywords.add("void-Keyword \n");
                 } else if (keywordArray[count].equals("while")) {
                     // Add a descriptive label for left brace
                     keywords.add("while-Keyword \n");
                 } else if (keywordArray[count].equals("}")) {
                     // Add a descriptive label for right brace
                     keywords.add("}-Right Bracket \n");
                 }
             
        	 }
        }
        
        //Put the ArrayLists in HashMap for particular Keys
        // symbolTable.put("Keywords", keywords);
        // System.out.println("Keywords:");
        for (String keyword : keywords) {
            System.out.println(keyword);
        }
        
        
        //Add values from ArrayList to HashMap Key keywords
        List<String> operators = new ArrayList<String>();   
        String [] OperationArray = lines.toArray(new String [0]);
        if (lines.contains("=") || lines.contains("-") || lines.contains("+") || lines.contains("*") || lines.contains(">=") || lines.contains("<=")) {         
        	for (int count = 0;  count < keywordArray.length; count++) {
             	if (OperationArray[count].equals("=")) {
                     // Add a descriptive label for left parenthesis
                     operators.add("=- Assignment operator \n");
                 } else if (OperationArray[count].equals("+")) {
                     // Add a descriptive label for right parenthesis
                     operators.add("+-Add operator- \n");
                 } else if (OperationArray[count].equals("-")) {
                     // Add a descriptive label for left brace
                     operators.add("- Minus operator \n");
                 } else if (OperationArray[count].equals("*")) {
                     // Add a descriptive label for right brace
                     operators.add("*- Multiply operator \n");
                 }
                 else if (OperationArray[count].equals(">=")) {
                     // Add a descriptive label for right brace
                     operators.add(">=- Greater than or equal to operator \n");
                 }
                 else if (OperationArray[count].equals(">=")) {
                     // Add a descriptive label for right brace
                     operators.add("<=- Less than or equal to operator \n");
                 }
             	
             
        	 }           
        }
        
        for (String symbol: operators) {
        	System.out.println(symbol);
        }
        
        
        //Put the ArrayLists in HashMap for particular Keys
        //symbolTable.put("Math Operators", operators); 
        
        //Add values from ArrayList to HashMap Key keywords
                 
        
        //Convert the array list into an array
        String [] linesArray = lines.toArray(new String [0]);
        
        //Add values from ArrayList to HashMap Key keywords
        //List<String> digits = new ArrayList<String>();     
        for (int count = 0;  count < linesArray.length; count++) {
            if (linesArray[count].matches("\\d+|\\d+\\.\\d+")) {  //Use regex here for numbers                 
                // digits.add(linesArray[count]);     
            	System.out.println(linesArray[count]+ "- Integer literal \n");
            }        
        }
        
        //Put the ArrayLists in HashMap for particular Keys
        
        //Add values from ArrayList to HashMap Key keywords
        //List<String> identifiers = new ArrayList<String>(); 
        String [] identifierArray = lines.toArray(new String [0]);
        
        for (int count = 0;  count < linesArray.length; count++) {
            if (identifierArray[count].matches("\\w+") && !identifierArray[count].matches("\\d+") && !linesArray[count].matches("int|float|if|else")) {  //Use regex here for variables  
                System.out.println(identifierArray[count] + "- Identifier \n");
            }        
        }
        
        //Put the ArrayLists in HashMap for particular Keys
        //symbolTable.put("Identifiers", identifiers);
        
        //Add values from ArrayList to HashMap Key keywords
        List<String> others = new ArrayList<String>();     
        for (int count = 0;  count < linesArray.length; count++) {
        	if (linesArray[count].equals("(")) {
                // Add a descriptive label for left parenthesis
                others.add("(- Left Parenthesis \n");
            } else if (linesArray[count].equals(")")) {
                // Add a descriptive label for right parenthesis
                others.add(")-Right Parenthesis \n");
            } else if (linesArray[count].equals("{")) {
                // Add a descriptive label for left brace
                others.add("{-Left Bracket \n");
            } else if (linesArray[count].equals("}")) {
                // Add a descriptive label for right brace
                others.add("}-Right Bracket \n");
            }
        } 
        
        //Put the ArrayLists in HashMap for particular Keys
      
        for (String symbol: others) {
        	System.out.println(symbol);
        }
        
        //Prints the ArrayList
        // System.out.print("The Lexemes: ");
        // System.out.println(lines);  
        
        System.out.println();
    }
}
