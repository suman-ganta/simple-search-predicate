package suman.simplesearchpredicate;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class SimpleSearchPredicateMain {
	public static void main(String[] args) throws IOException {
		String inputStr = "val0 attr1:val1 attr2:val2 val3 val4 attr5:val5\n";
		System.out.println("Input: " + inputStr);
		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(new ByteArrayInputStream(
				inputStr.getBytes()));
		// create a lexer that feeds off of input CharStream
		SimpleSearchPredicateLexer lexer = new SimpleSearchPredicateLexer(input);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		// create a parser that feeds off the tokens buffer
		SimpleSearchPredicateParser parser = new SimpleSearchPredicateParser(tokens);
		ParseTree tree = parser.query(); // begin parsing at init rule
		System.out.println("AST: " + tree.toStringTree());
		SimpleSearchAttributes attributeVisitor = new SimpleSearchAttributes();
		attributeVisitor.visit(tree);
		Map<String, String> pairs = attributeVisitor.getPairs();
		Set<String> keywords = attributeVisitor.getKeywords();
		
		System.out.println("Pairs: " + pairs + "\nKeywords: " + keywords);
	}
}
