package demo;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
 private int data;
 private List<TreeNode>children=new ArrayList<TreeNode>(); 
 private TreeNode parent=null;
 
 public TreeNode(int data) {
	this.data = data;
}
 
 //logic to insert data into child  whose parent is "Parent"
 public TreeNode addchild(TreeNode child) {
	 child.setParent(this);
	 this.children.add(child);
	 return child;
	 
 }
 
 //lofic to insert data into children whose parent is child.
 /*public TreeNode addChildren(TreeNode children) {
	 children.forEach(each -> each.setParent(this));
	 this.children.addAll(children);
 }*/

public List<TreeNode> getChildren() {
	return children;
}

public int getData() {
	return data;
}

public void setData(int data) {
	this.data = data;
}

public TreeNode getParent() {
	return parent;
}

public void setParent(TreeNode parent) {
	this.parent = parent;
}
 
} 
 

 