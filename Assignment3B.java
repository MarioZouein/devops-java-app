
interface Expression {
	public void printExpression();
	public void Accept(ExpressionVisitor visitor);

}

class Variable implements Expression {
    private String name;
    public Variable(String n) { name = n; }
    public String getName() { return name; }
    
	@Override
	public void printExpression() {
		System.out.print(name);
		
	}
	@Override
	public void Accept(ExpressionVisitor visitor) {
		visitor.Visit(this);
		
	}
    
    
}

class Negate implements Expression {
    private Expression operand;
    public Negate(Expression op) { operand = op; }
    public Expression getOperand() { return operand; }
    
	@Override
	public void printExpression() {
		System.out.print("!");
		operand.printExpression();
	}
	@Override
	public void Accept(ExpressionVisitor visitor) {
		visitor.Visit(this);
		
	}
    
    
}

class And implements Expression {
    private Expression operand1;
    private Expression operand2;
    public And(Expression op1, Expression op2) { operand1 = op1; operand2 = op2; }
    public Expression getOperand1() { return operand1; }
    public Expression getOperand2() { return operand2; }
       
	@Override
	public void printExpression() {
		operand1.printExpression();
		System.out.print(" && ");
		operand2.printExpression();
	}
	@Override
	public void Accept(ExpressionVisitor visitor) {
		visitor.Visit(this);
		
	}
    
}

class Or implements Expression {
    private Expression operand1;
    private Expression operand2;
    public Or(Expression op1, Expression op2) { operand1 = op1; operand2 = op2; }
    public Expression getOperand1() { return operand1; }
    public Expression getOperand2() { return operand2; }
    
	@Override
	public void printExpression() {
		operand1.printExpression();
		System.out.print(" || ");
		operand2.printExpression();
		
	}
	@Override
	public void Accept(ExpressionVisitor visitor) {
		visitor.Visit(this);
		
	}
}

class ExpressionVisitor{
	public void Traverse(Expression myVal) { myVal.Accept(this); }

	public void Visit(Variable v) {}
	public void Visit(Negate n) {}
	public void Visit(And a) {}
	public void Visit(Or o) {}
	
}

class ExpressionPrinter extends ExpressionVisitor{
	public void Visit(Variable v) {
		System.out.print(v.getName());
	}
	public void Visit(Negate n) {
		System.out.print("!");
		Traverse(n.getOperand());
	}
	public void Visit(And a) {
		Traverse(a.getOperand1());
		System.out.print(" && ");
		Traverse(a.getOperand2());
		
	}
	public void Visit(Or o) {
		Traverse(o.getOperand1());
		System.out.print(" || ");
		Traverse(o.getOperand2());
	}
}

public class Assignment3B {

    public static void main(String[] args) {
        // Create myTree
        Expression myTree = new Or(new And(new Variable("x"),new Negate(new Variable("y"))),new And(new Negate(new Variable("x")),new Variable("y")));
        // Dispatch method to print myTree
        myTree.printExpression();
        System.out.print("\n");
        // Use visitor to print myTree
        ExpressionPrinter printer = new ExpressionPrinter();
        printer.Traverse(myTree);
        System.out.print("\n");
    }

}
