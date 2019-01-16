package open;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] arr) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.data = arr[mid];
		nn.left = construct(arr, lo, mid - 1);
		nn.right = construct(arr, mid + 1, hi);
		return nn;
	}

	public void display() {
		System.out.println("------------------------------------------------------");
		display(this.root);
		System.out.println("------------------------------------------------------");
	}

	private void display(Node node) {
		String str = "";
		if (node == null) {
			return;
		}

		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}

		str += "->" + node.data + "<-";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);

	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}

		if (node.data < item) {
			return find(node.right, item);
		} else if (node.data > item) {
			return find(node.left, item);
		} else {
			return true;
		}
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}
		return max(node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh) + 1;
	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {
		if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}
		} else {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		}
	}

	public void remove(int item) {
		remove(this.root, null, false, item);
	}

	

	private void remove(Node node, Node parent, boolean ilc, int item) {
		if (node == null) {
			return;
		}
		if (item > node.data) {
			remove(node.right, node, false, item);
		} else if (item < node.data) {
			remove(node.left, node, true, item);
		} else {
			if (node.left == null && node.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} 
	
	
	  else if (node.left != null && node.right == null) {
				if (ilc) {
					parent.left = node.left;
				} else {
					parent.right = node.left;
				}
			} else if (node.right != null && node.left == null) {
				if (ilc) {
					parent.left = node.right;
				} else {
					parent.right = node.right;
				}
			} else {
				int max = max(node.left);
				node.data = max;
				remove(node.left,node,true,max);
			}
		}
	}

	public void printInrange(int lo, int hi) {
		printInrange(lo, hi, this.root);
	}

	private void printInrange(int lo, int hi, Node node) {
		if (node == null) {
			return;
		}

		if (lo > node.data) {
			printInrange(lo, hi, node.right);
		}
		if (hi < node.data) {
			printInrange(lo, hi, node.left);
		}

		if (lo <= node.data && hi >= node.data) {
			printInrange(lo, hi, node.left);
			System.out.print(node.data + " ");
			printInrange(lo, hi, node.right);
		}
	}

	public void printDec() {
		printDec(this.root);
	}

	private void printDec(Node node) {
		if (node == null) {
			return;
		}
		printDec(node.right);
		System.out.print(node.data + " ");
		printDec(node.left);
	}

	private class HeapMover {
		int sum = 0;
	}

	public void replaceWithSumLarger() {
		replaceWithSumLarger(this.root, new HeapMover());
	}

	private void replaceWithSumLarger(Node node, HeapMover mover) {

		if (node == null) {
			return;
		}

		replaceWithSumLarger(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replaceWithSumLarger(node.left, mover);

	}
	
	



}
