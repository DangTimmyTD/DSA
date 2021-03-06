package leetCode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import data_structures.TreeNode;

public class Palantir_Groupon_BT_Traversal_Iterative {
   

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	if (root == null) {
	    return list;
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();

	TreeNode p = root;

	while (!stack.isEmpty() || p != null) {
	    if (p != null) {
		stack.push(p);
		p = p.left;
	    } else {
		TreeNode t = stack.pop();
		list.add(t.val);
		t = t.right;
	    }
	}

	return list;
    }

    public ArrayList<Integer> preTraversal(TreeNode root) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	if (root == null) {
	    return list;
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();

	stack.push(root);

	while (!stack.isEmpty()) {
	    TreeNode n = stack.pop();
	    list.add(n.val);

	    if (n.left != null) {
		stack.push(n.left);
	    }

	    if (n.right != null) {
		stack.push(n.right);
	    }
	}

	return list;
    }

    public List<Integer> postTraversal(TreeNode root) {
	List<Integer> list = new LinkedList<Integer>();
	if (root == null) {
	    return list;
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode curr = root;
	while (curr != null) {
	    list.add(0, curr.val);
	    if (curr.left != null) {
		stack.push(curr.left);
	    }
	    curr = curr.right;
	    if (curr == null || !stack.isEmpty()) {
		curr = stack.pop();
	    }
	}

	return list;
    }

    public ArrayList<Integer> postTraversal2(TreeNode root) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	if (root == null) {
	    return list;
	}

	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);

	TreeNode prev = null;
	while (!stack.isEmpty()) {
	    TreeNode curr = stack.peek();

	    // go down the tree.
	    // check if current node is leaf, if so, process it and pop stack,
	    // otherwise, keep going down
	    if (prev == null || prev.left == curr || prev.right == curr) {
		if (curr.left != null) {
		    stack.push(curr.left);
		} else if (curr.right != null) {
		    stack.push(curr.right);
		} else {
		    stack.pop();
		    list.add(curr.val);
		}

		// go up the tree from left node
		// need to check if there is a right child
		// if yes, push it to stack
		// otherwise, process parent and pop stack
	    } else if (curr.left == prev) {
		if (curr.right != null) {
		    stack.push(curr.right);
		} else {
		    stack.pop();
		    list.add(curr.val);
		}
		// go up the tree from right node
		// after coming back from right node, process parent node and
		// pop stack.
	    } else if (curr.right == prev) {
		stack.pop();
		list.add(curr.val);
	    }

	    prev = curr;
	}

	return list;
    }
}