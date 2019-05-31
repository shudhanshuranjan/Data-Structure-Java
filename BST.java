package Tree;
public class BSTT {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BSTT(int arr[]) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int arr[], int lo, int hi) {
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
		System.out.println();
		display(this.root);
		System.out.println();
	}

	private void display(Node node) {
		String str = "";
		if (node == null) {
			return;
		}

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}
		str += " <- " + node.data + " -> ";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
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

		if (item > node.data)
			remove(node.right, node, false, item);
		else if (item < node.data)
			remove(node.left, node, true, item);
		else {
			if (node.left == null && node.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (node.left != null && node.right == null) {
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
				remove(node.left, node, true, max);
			}
		}

	}

}
