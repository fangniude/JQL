import java.util.List;
import java.util.Map.Entry;
import org.antlr.v4.Tool;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.tool.ast.GrammarAST;
import org.junit.Test;
import org.stringtemplate.v4.misc.MultiMap;

/**
 * @author lipengpeng
 */
public class G4Test {

    @Test
    public void test() {
        final Tool tool = new Tool();
//        tool.parseGrammar("src/main/resources/PostgreSQLLexer.g4");
//        final GrammarRootAST parseGrammar = tool.parseGrammar("src/main/resources/PostgreSQLParser.g4");
//        final Grammar grammar = tool.createGrammar(parseGrammar);
//        tool.process(grammar, false);

        final Grammar grammar = Grammar.load("src/main/resources/PostgreSQLParser.g4");
        final Rule updateStmt = grammar.getRule("updatestmt");
        final MultiMap<String, GrammarAST> ruleRefs = updateStmt.alt[1].ruleRefs;
        for (Entry<String, List<GrammarAST>> e : ruleRefs.entrySet()) {
            final GrammarAST grammarAST = e.getValue().get(0);
            System.out.println(e.getKey() + "   " + grammarAST);
        }
        System.out.println("hello");
    }

}
