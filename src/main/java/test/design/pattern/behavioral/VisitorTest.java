package test.design.pattern.behavioral;

class TreeNode {
	private String name;
	public TreeNode(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void accept(NodeVisitor v) {
		v.visit(this);
	}
}


interface NodeVisitor {
	public void visit(TreeNode n);
}


class ConsoleVisitor implements NodeVisitor {
	@Override
	public void visit(TreeNode n) {
		System.out.println("console:" + n.getName());
	}
}

class EmailVisitor implements NodeVisitor {
	@Override
	public void visit(TreeNode n) {
		System.out.println("email:" + n.getName());
	}
}


public class VisitorTest {

	public static void main(String[] args) {
		TreeNode computer = new TreeNode("Java2s.com");
		computer.accept(new ConsoleVisitor());
		computer.accept(new EmailVisitor());

	}

}
