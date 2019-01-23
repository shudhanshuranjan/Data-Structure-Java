package open;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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

	public int heightUsingStack()
	{
		return heightUsingStack(this.root);
	}
	
	private int heightUsingStack(Node node)
	{
		LinkedList<Node> stack=new LinkedList<>();
		stack.addLast(node);
		Node prev=null;
		int maxH=0;
	
		while(!stack.isEmpty())
		{
			Node curr=stack.peek();
			if(prev==null || prev.left==curr || prev.right==curr)
			{
				if(curr.left!=null)
					stack.addLast(node.left);
				else if(curr.right!=null)
					stack.addLast(node.right);
			}
			else if(curr.left==prev)
			{
				if(curr.right!=null)
					stack.addLast(curr.right);
			}
			else
			{
				stack.pop();
			}
			prev=curr;
			
			if(stack.size()>maxH)
			{
				maxH=stack.size();
			}
			
		}
		return maxH;
		
		
	}
	
	public int size() {
		int s = size(this.root);
		return s;
	}

	private int size(Node node)
	{

	if(node==null)
	{
		return 0;
	}
	int ls=size(node.left);
	int rs=size(node.right);
	
	return ls + rs +1;
		
	}

	public int max() {
		int ma = max(this.root);
		return ma;
	}

	private int max(Node node) {

      if(node==null) {
    	  return Integer.MIN_VALUE;
      }
      int rs=node.data;
      int lh=max(node.left);
      int rh=max(node.right);
      if(rs<lh)
      {
    	  rs=lh;
      }
      if(rs<rh)
      {
    	  rs=rh;
      }
      return rs;

	}
	
	public int maxWithoutRecursion()
	{
		return maxWithoutRecursion(this.root);
	}
	
	private int  maxWithoutRecursion(Node node)
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		int max=root.data;
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			if(max<rn.data)
			{
				max=rn.data;
			}
			if (rn.left != null)
			{
				queue.addLast(rn.left);
			}
			if (rn.right != null)
			{
				queue.addLast(rn.right);
			}
		}
		return max;
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
	
	public boolean findWithoutRecursion( int item)
	{
		return findWithoutRecursion(this.root,item);
	}
	
    private boolean findWithoutRecursion(Node node,int item)
    {

		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
            if(rn.data==item)
            	return true;
            
			if (rn.left != null)
				queue.addLast(rn.left);
			if (rn.right != null)
				queue.addLast(rn.right);

		}	
    	
    	return false;
    	
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

    public void getpath(int data)
    {
    	ArrayList<Integer> list=new ArrayList<>();
    	System.out.println(getpath(this.root,data,list));
    	System.out.println(list);
    }
    
    private boolean getpath(Node root, int n, ArrayList<Integer> path) 
    { 
        
        if (root == null) { 
            return false; 
        } 
          
     
        path.add(root.data); 
  
        if (root.data == n) { 
            return true; 
        } 
  
        if(getpath(root.left,n,path) || getpath(root.right,n,path) )
        	return true;
  
   
        path.remove(path.size()-1); 
  
        return false; 
    } 
  
    public void preorderIteration()
    {
    	preorderIteration(this.root);
    }
    
    private void preorderIteration(Node node)
    {
    	ArrayList<Integer> res=new ArrayList<>();
    	LinkedList<Node> stack=new LinkedList<>();
    	stack.addFirst(node);
    	while(!stack.isEmpty())
    	{
    		Node temp=stack.pop();
    		res.add(temp.data);
    		if(temp.right!=null)
    		 stack.addFirst(temp.right);
    		if(temp.left!=null)
    		stack.addFirst(temp.left);	
    	}
    	System.out.println(res);
    }
    
    public void inorderIteration()
    {
    	inorderIteration(this.root);
    }
    
    private void inorderIteration(Node node)
    {
    	ArrayList<Integer> res=new ArrayList<>();
    	LinkedList<Node> stack=new LinkedList<>();
    	boolean d=false;
    	while(!d)
    	{
    		if(node!=null)
    		{
    			stack.addFirst(node);
    			node=node.left;
    		}
    		else
    		{
    			if(stack.isEmpty())
    			{
    				d=true;
    			}
    			else
    			{
    			   Node temp=stack.pop();
    			   res.add(temp.data);
    			   node=temp.right;
    			}
    		}
    	}
    	System.out.println(res);
    }
    
    public void postorderIteration() 
    {
    	postorderIteration(this.root);
    }
    
    private void postorderIteration(Node node)
    {
    	ArrayList<Integer> res=new ArrayList<>();
    	LinkedList<Node> stack1=new LinkedList<>();
    	LinkedList<Node> stack2=new LinkedList<>();
    	stack1.addFirst(node);
    	while(!stack1.isEmpty())
    	{
    		Node temp=stack1.pop();
    		stack2.addFirst(temp);
    		if(temp.left!=null)
    			stack1.addFirst(temp.left);
    		if(temp.right!=null)
    			stack1.addFirst(temp.right);
    	}
    	
    	while(!stack2.isEmpty())
    	{
    		Node temp=stack2.pop();
    		res.add(temp.data);
    	}
    	
    	System.out.println(res);
    }
    
    public void insertWithoutRecursion(int item)
    {
    	insertWithoutRecursion(this.root,item);
    }
    
    private void insertWithoutRecursion(Node node, int item)
    {
    	LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();

			if (rn.left != null)
				queue.addLast(rn.left);
			else
			{
				Node nn=new Node();
				nn.data=item;
				rn.left=nn;
				break;
			}
			
			if (rn.right != null)
				queue.addLast(rn.right);
			else
			{
				Node nn=new Node();
				nn.data=item;
				rn.right=nn;
				break;
			}
				
			}
	
    }
 
    public void levelorderreverse()
    {
    	levelorderreverse(this.root);
    }
    
    private void levelorderreverse(Node node)
    {
    	LinkedList<Node> queue=new LinkedList<>();
    	LinkedList<Node> stack=new LinkedList<>();
    	queue.addLast(node);
    	while(!queue.isEmpty())
    	{
    		Node temp=queue.removeFirst();
    		stack.addFirst(temp);
    		if(temp.right!=null)
            	queue.addLast(temp.right);
    		if(temp.left!=null)
    		queue.addLast(temp.left);

    	}
    	while(!stack.isEmpty())
    	{
    		System.out.print(stack.pop().data + " ");
    	}
    	
    }
    
    


    
}
