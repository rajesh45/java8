package demo;

public class Tree {

	public static void main(String args[]) {
		 TreeNode root = createTree();
		 
		 printTree(root, " ");
		
		
			
			
		}


	private static TreeNode createTree() {
		TreeNode root= new TreeNode(46);
		TreeNode node1=root.addchild(new TreeNode(37));
		TreeNode node11=node1.addchild(new TreeNode(35));
		//TreeNode node13 = node11.addChild(new TreeNode(11));
		TreeNode node111 = node11.addchild(new TreeNode(111));
		TreeNode node112 = node11.addchild(new TreeNode(112));
		 
		TreeNode node12 = node1.addchild(new TreeNode( 12));
		 
		TreeNode node2 = root.addchild(new TreeNode((2)));
		 
		TreeNode node21 = node2.addchild(new TreeNode(21));
		TreeNode node211 = node2.addchild(new TreeNode(22));
		
		
		return root;
	}
	private static  void printTree(TreeNode node, String appender) {
		   System.out.println(appender + node.getData());
		   node.getChildren().forEach(each ->  printTree(each, appender + appender));
		 }
	
}
