package suman.simplesearchpredicate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleSearchAttributes extends SimpleSearchPredicateBaseVisitor<String>{
	
	private Map<String, String> attributeValuePairs = new HashMap<String, String>();
	private Set<String> keywords = new HashSet<String>();
	
	@Override
	public String visitPair(SimpleSearchPredicateParser.PairContext ctx) {
		String attribute = visit(ctx.attrib());
		//don't visit value here - visitValue is dedicated to only keywords.
		String value = ctx.value().getText();
		attributeValuePairs.put(attribute, value);
		return value;
	}
	
	@Override
	public String visitValue(SimpleSearchPredicateParser.ValueContext ctx) {
		keywords.add(ctx.getText());
		return ctx.getText();
	}
	
	@Override
	public String visitAttrib(SimpleSearchPredicateParser.AttribContext ctx) {
		return ctx.getText();
	}

	public Set<String> getKeywords() {
		return keywords;
	}
	
	public Map<String, String> getPairs() {
		return attributeValuePairs;
	}
}
