package test.design.pattern.behavioral;
/*
The Interpreter Design Pattern is one of the Gang of Four design patterns which specifies how to evaluate sentences in a language.
The Interpreter pattern is a behavioral pattern that provides a way to evaluate language grammar or expression.
The Interpreter pattern uses an expression interface that tells how to interpret a particular context.
The Interpreter pattern is used to define a grammatical representation for a language and also provides an interpreter to deal with the grammar.
The basic idea of the Interpreter pattern is to have a class for each symbol:
Terminal - are the elementary symbols of the language defined by a formal grammar. 
NonTerminal -  also known as syntactic variables that are replaced by groups of terminal symbols according to the production rules. The NonTerminal uses a composite design pattern in general.
A grammar is defined by production rules that specify which symbols may replace which other symbols. The production rules or simply called productions may be used to generate and parse strings.  
SQL interpreter is a good example of this pattern.
Language interpreters are another great example of this.
 * 
 */

interface Expression {
	public boolean evaluate(String context);
}
class IsInExpression implements Expression {
	private String data;

	public IsInExpression(String data) {
		this.data = data;
	}

	@Override
	public boolean evaluate(String context) {
		if (context.contains(data)) {
			return true;
		}
		return false;
	}
}
class OrExpression implements Expression {

	private Expression expr1 = null;
	private Expression expr2 = null;

	public OrExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean evaluate(String context) {
		return expr1.evaluate(context) || expr2.evaluate(context);
	}
}
class AndExpression implements Expression {

	private Expression expr1 = null;
	private Expression expr2 = null;

	public AndExpression(Expression expr1, Expression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	@Override
	public boolean evaluate(String context) {
		return expr1.evaluate(context) && expr2.evaluate(context);
	}
}
public class InterpretorTest {
	public static void main(String[] args) {
		Expression select = new IsInExpression("Select");
		Expression from = new IsInExpression("From");
		Expression isSelectFrom = new AndExpression(select, from);

		Expression insert = new IsInExpression("Insert");
		Expression update = new IsInExpression("Update");
		Expression isInsertOrUpdate = new OrExpression(insert, update);

		System.out.println(isSelectFrom.evaluate("Select"));
		System.out.println(isInsertOrUpdate.evaluate("Insert"));

		System.out.println(isSelectFrom.evaluate("Select From"));
		System.out.println(isInsertOrUpdate.evaluate("Update"));
	}
}
