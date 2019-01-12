package open;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root = null;

	BinaryTree() {
		this.root = takeInput(root, false);
	}

	private Node takeInput(Node parent, boolean b) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (b) {
				System.out.println(" enter data for left child of " + parent.data);
			} else {
				System.out.println(" enter data for right child of " + parent.data);
			}
		}

		int item = sc.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println(nn.data + " has left child ");
		boolean ilc = sc.nextBoolean();
		if (ilc) {
			nn.left = takeInput(nn, true);
		}
		System.out.println(nn.data + " has right child ");
		boolean hrc = sc.nextBoolean();
		if (hrc) {
			nn.right = takeInput(nn, false);
		}
		return nn;
	}

	public void display() {
		System.out.println();
		display(this.root);
		System.out.println();
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}
		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += "<-" + node.data + "->";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int height() {
		int h = height(this.root);
		return h;
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	public int size() {
		int s = size(this.root);
		return s;
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		int ma = max(this.root);
		return ma;
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int rs = node.data;
		int lm = max(node.left);
		int rm = max(node.right);
		if (lm > rs) {
			rs = lm;
		}
		if (rm > rs) {
			rs = rm;
		}
		return rs;

	}

	public int min() {
		int mi = min(this.root);
		return mi;
	}

	private int min(Node node) {

		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int res = node.data;
		int lmin = min(node.left);
		int hmin = min(node.right);
		if (res > lmin) {
			res = lmin;
		}
		if (res > hmin) {
			res = hmin;
		}

		return res;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		return find(node.left, item) || find(node.right, item);
	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	public void levelorder() {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();

			System.out.print(rn.data + " ");
			if (rn.left != null)
				queue.addLast(rn.left);
			if (rn.right != null)
				queue.addLast(rn.right);

		}
	}

	public void levelorderLW() {

		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.addLast(this.root);
		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();

			System.out.print(rn.data + " ");
			if (rn.left != null)
				helper.addLast(rn.left);
			if (rn.right != null)
				helper.addLast(rn.right);
			if (primary.isEmpty()) {
				primary = helper;
				helper = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public void zigzag() {

		int count = 0;
		LinkedList<Node> queue = new LinkedList<>();
		LinkedList<Node> stack = new LinkedList<>();
		queue.addLast(this.root);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");
			if (count % 2 == 0) {
				if (rn.left != null)
					stack.addFirst(rn.left);
				if (rn.right != null)
					stack.addFirst(rn.right);
			}

			else {
				if (rn.left != null)
					stack.addFirst(rn.right);
				if (rn.right != null)
					stack.addFirst(rn.left);
			}
			if (queue.isEmpty()) {
				count++;
				queue = stack;
				stack = new LinkedList<>();
			}
		}
	}

	public void printatlevel(int level) {
		printatlevel(this.root, 0, level);
	}

	private void printatlevel(Node node, int count, int level) {
		if (count == level) {
			System.out.print(node.data + " ");
			return;
		}
		printatlevel(node.left, count + 1, level);
		printatlevel(node.right, count + 1, level);
	}

}
