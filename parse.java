import java.util.ArrayList;
import java.util.List;

public class parse {
    public static class ParseTree {
        public String type;
        public String value;
        public List<ParseTree> children;

        public ParseTree(String type, String value) {
            this.type = type;
            this.value = value;
            this.children = new ArrayList<>();
        }
    }

    public static ParseTree parseExpression(List<String> lexemes) {
        if (lexemes.isEmpty()) {
            return null;
        }
        String firstLexeme = lexemes.remove(0);
        ParseTree node = new ParseTree("expression", firstLexeme);

        if(isOperator(firstLexeme)) {
            node.children.add(parseExpression(lexemes));
            node.children.add(parseExpression(lexemes));
        }
        return node;
    }

    private static boolean isOperator(String lexeme) {
        return lexeme.equals("+") || lexeme.equals("-") || lexeme.equals("*") || lexeme.equals("/");
    }
    
}
System.out.println(System.getProperty("java.class.path"));