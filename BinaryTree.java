package Tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BT {

	Scanner sc = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	Node root = null;

	BT() {
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

	
	public int DeepestNode()
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		Node rn=null;
		while (!queue.isEmpty()) {

			rn = queue.removeFirst();
			if (rn.left != null)
				queue.addLast(rn.left);
			if (rn.right != null)
				queue.addLast(rn.right);
	}
		return rn.data;
	}
	
	public void delete(int item)  
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		int dep=DeepestNode();
		while (!queue.isEmpty()) {
			
			Node rn = queue.removeFirst();
			System.out.print(rn.data + " ");
			if(rn.data==item) ////////////////////DOUBTDOUBT
				rn.data=dep;
			if(rn.left!=null && rn.left.data==dep )
			{
		
				System.out.println(rn.left.data);
				System.out.println("yes");
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
	
	public void levelorderWithRecursion()
	{
		levelorderWithRecursion(this.root);	
	}
	
	private void levelorderWithRecursion(Node node)
	{
		int h=height(node);
    	int max=0;
    	for(int i=0;i<=h;i++)
    	{
    		levelord(node,i);
    	}
	}
	
	private void levelord(Node node,int l)
	{
		if(node==null)
		{
			return ;
		}
		if(l==0)
		{
			System.out.print(node.data + " ");
			return ;
		}
		levelord(node.left,l-1);
		levelord(node.right,l-1);
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
				if (rn.right != null)
					stack.addFirst(rn.right);
				if (rn.left != null)
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

    public void numofleaves()
    {
    	LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		int count=0;
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
              if(rn.left==null && rn.right==null)
              {
            	  count++;
              }
			if (rn.left != null)
				queue.addLast(rn.left);
			if (rn.right != null)
				queue.addLast(rn.right);

    }
		System.out.println(count);
    
    }
 
    public void noOfFullNodes()
    {
    	LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		int count=0;
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
              if(rn.left!=null && rn.right!=null)
              {
            	  count++;
              }
			if (rn.left != null)
				queue.addLast(rn.left);
			if (rn.right != null)
				queue.addLast(rn.right);

    }
		System.out.println(count);
    }

    public void noOfHalfNodes()
    {
    	LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		int count=0;
		while (!queue.isEmpty()) {

			Node rn = queue.removeFirst();
              if((rn.left!=null && rn.right==null) || (rn.left==null && rn.right!=null ))
              {
            	  count++;
              }
			if (rn.left != null)
				queue.addLast(rn.left);
			if (rn.right != null)
				queue.addLast(rn.right);
    }
		System.out.println(count);
   }

    public boolean CheckStructrallySameTree(BT other)
    {
    	return CheckStructrallySameTree(this.root,other.root);
    }

    private boolean CheckStructrallySameTree(Node node1, Node node2)
    {
    	if(node1 == null && node2 == null)
    	{
    		return true;
    	}
    	if(node1!=null && node2!=null)
    	return (CheckStructrallySameTree(node1.left,node2.left) &&CheckStructrallySameTree(node1.right,node2.right));
    	else
    		return false;
    	
    }
    
    public int diameter()
    {
    	return diameter(this.root);
    }
    
    private int diameter(Node node)
    {
    	if(node==null)
    	{
    		return 0;
    	}
    	
    	int len1=height(node.left)+height(node.right)+3;
    	int len2=Math.max(diameter(node.left),diameter(node.right));
   
    	return Math.max(len1, len2);
    }
    
    public int width()
    {
      return width(this.root);	
    }
    
    private int width(Node node)
    {
    	int h=height(node);
    	int max=0;
    	for(int i=0;i<=h;i++)
    	{
    		int width=getwidth(node,i);
    		if(width>max)
    			max=width;
    	}
    	return max;
    }
    
    private int getwidth(Node node,int l)
    {
       if(node==null)
       {
    	   return 0;
       }
       if(l==0)
       {
    	   return 1;
       }
       else if(l>0)
       {
    	   int lw=getwidth(node.left,l-1);
    	   int rw=getwidth(node.right,l-1);
    	   return lw+rw;
       }
       return 0;
    }

    public void widthWithoutRecursion()
    {
    	LinkedList<Node> queue=new LinkedList<>();
    	LinkedList<Node> helper=new LinkedList<>();
    	queue.addFirst(root);
    	int c=0;
    	int max=1;
    	while(!queue.isEmpty())
    	{
    		
    		Node rp=queue.removeFirst();
    		if(rp.left!=null)
    		{
    			c++;
    		helper.addFirst(rp.left);
    		}
    		if(rp.right!=null)
    		{
    			c++;
        		helper.addFirst(rp.right);
    		}
    		if(queue.isEmpty())
    		{
    			
    			if(c>max)
    			{
    				max=c;
    			}
    			c=0;
    			queue=helper;
    			helper=new LinkedList<>();	
    		}
    	}
    	System.out.println(max);
    }
    
    public void maximumLevelSum()
    {
    	LinkedList<Node> queue=new LinkedList<>();
    	LinkedList<Node> helper=new LinkedList<>();
    	queue.addFirst(root);
    	int c=0;
    	int max=root.data;
    	while(!queue.isEmpty())
    	{
    		
    		Node rp=queue.removeFirst();
    		if(rp.left!=null)
    		{
    			c+=rp.left.data;
    		helper.addFirst(rp.left);
    		}
    		if(rp.right!=null)
    		{
    			c+=rp.right.data;
        		helper.addFirst(rp.right);
    		}
    		if(queue.isEmpty())
    		{
    			
    			if(c>max)
    			{
    				max=c;
    			}
    			c=0;
    			queue=helper;
    			helper=new LinkedList<>();	
    		}
    	}
    	System.out.println(max);
    }

    public void rootToAllNodePath()
    {
    	rootToAllNodePath(this.root,this.root);
    }
    
    private void rootToAllNodePath(Node node,Node root)
    {
    	if(node==null)
    	{
    		return ;
    	}
    	ArrayList<Integer> l=new ArrayList<>();
    	rootToAllNodePath(root,node.data,l);
    	System.out.println(l);
    	rootToAllNodePath(node.left,root);
    	rootToAllNodePath(node.right,root);
    }
    
    private boolean rootToAllNodePath(Node node,int item,ArrayList<Integer> list)
    {
    	if(node==null)
    	{
    		return false;
    	}
    	list.add(node.data);
    	if(node.data==item)
    	{
    		return true;
    	}
    	if(rootToAllNodePath(node.left,item,list) || rootToAllNodePath(node.right,item,list))
    		return true;
    	
    	list.remove(list.size()-1);
    	return false;
   
    }
    
    public void rootToLeafPath()
    {
    	rootToLeafPath(this.root,this.root);
    }
    
    private void rootToLeafPath(Node node,Node root)
    {
    	if(node==null)
    	{
    		return ;
    	}
    	if(node.left==null  && node.right==null)
    	{
    		ArrayList<Integer> l=new ArrayList<>();
        	rootToLeafPath(root,node.data,l);
        	System.out.println(l);
    		return ;
    	}
    	rootToLeafPath(node.left,root);
    	rootToLeafPath(node.right,root);
    }
    
    private boolean rootToLeafPath(Node node,int item,ArrayList<Integer> list)
    {
    	if(node==null)
    	{
    		return false;
    	}
    	list.add(node.data);
    	if(node.data==item)
    	{
    		return true;
    	}
    	if( rootToLeafPath(node.left,item,list) ||  rootToLeafPath(node.right,item,list))
    		return true;
    	
    	list.remove(list.size()-1);
    	return false;
    }
    
    public void rootToLeafPath2()
    {
    	int path[]=new int[1000];
    	rootToLeafPath2(this.root,path,0);
    }
    
    private void rootToLeafPath2(Node node,int path[],int pathlen)
    {
    	if(node==null)
    	{
    		return ;
    	}
    	path[pathlen]=node.data;
    	pathlen++;
    	if(node.left==null && node.right==null)
    	{
    		printarray(path,pathlen);
    	}
    	else
    	{
    		rootToLeafPath2(node.left,path,pathlen);
    		rootToLeafPath2(node.right,path,pathlen);
    	}
    }
    
    private void printarray(int path[],int l)
    {
    	for(int i=0;i<l;i++)
    	{
    		System.out.print(path[i] + " ");
    	}
    	System.out.println();
    }
    
    public void hasPathSum(int sum)
    {
    	System.out.println(hasPathSum(this.root,sum));
    }
    
    private boolean hasPathSum(Node node,int sum)
    {
    	if(node==null)
    	{
    		return false;
    	}
    	if(node.left==null && node.right==null && node.data==sum)
    	{
    		return true;
    	}
    	
    	boolean res1=false,res2=false;
    	res1=hasPathSum(node.left,sum-node.data);
    	res2=hasPathSum(node.right,sum-node.data);
    	
    	if(res1 || res2)
    		return true;
    	else
    		return false;
    }
    
    public void sumOfAllNode()
    {
    	System.out.println(sumOfAllNode(this.root));
    }
    
    private int sumOfAllNode(Node node)
    {
      if(node==null)
      {
    	  return 0;
      }
      int ln=sumOfAllNode(node.left);
      int rn=sumOfAllNode(node.right);
      return ln+rn+node.data;
    }
   
    public void sumOfAllNodeWithoutRecursion()
    {
    	LinkedList<Node> queue=new LinkedList<>();
    	queue.addLast(this.root);
    	int sum=0;
    	while(!queue.isEmpty())
    	{
    	  Node temp=queue.removeLast();
    	  sum+=temp.data;
    	  if(temp.left!=null)
    		 queue.addFirst(temp.left);
    	  if(temp.right!=null)
    		  queue.addFirst(temp.right);
    	}
    	System.out.println(sum);
    }
    
    public void convertTOMIRROR()
    {
    	convertTOMIRROR(this.root);
    }
    
    public  Node convertTOMIRROR(Node root)
    {
    	if(root!=null)
    	{
    		convertTOMIRROR(root.left);
    		convertTOMIRROR(root.right);
    		Node temp=root.right;
    		root.right=root.left;
    		root.left=temp;
    	}
    	return root;
    }
    
    public boolean checkMirrorOfEachOther(BT other)
    {
        return checkMirrorOfEachOther(this.root,other.root);
    }
    
    public  boolean checkMirrorOfEachOther(Node root1, Node root2)
    {
       if(root1==null && root2==null)
       {
    	   return true;
       }
       if(root1 == null ||  root2==null)
       {
    	   return false;
       }
       if(root1.data!=root2.data)
       {
    	   return false;
       }
       else
       {
    	   return checkMirrorOfEachOther(root1.left, root2.right) || checkMirrorOfEachOther(root1.right, root2.left);
       }
    }
   
    public Node BinaryTree(int in[],int pre[],int ps, int pe, int is, int ie)
    {
    	if(ie<is || pe<ps )
    	{
    		return null;
    	}
    	int offset=is;
    	for(offset=is;offset<ie;offset++)
    	{
    	   if(in[offset]==pre[ps])
    	   {
    		 break;
    	   }
    	}
    	Node curr=new Node();
    	curr.data=pre[ps];
        curr.left= BinaryTree(in,pre,ps+1,ie-is+ps,is,offset-1);
        curr.right=BinaryTree(in,pre,ie-is+ps+1,pe,offset+1,ie);
        return curr;
    }
    
    public void allAncestor(int item)
    {
    	ArrayList<Integer> list1=new ArrayList<>();
        allAncestor(this.root,list1,item);
        System.out.println(list1);
    }
        
    public boolean allAncestor(Node node,ArrayList<Integer> list1,int item)
    {
    	if(node==null)
    	{
    		return false ;
    	}
    	list1.add(node.data);
    	if(node.data==item)
    	{
    		return true;
    	}
    	if( allAncestor(node.left,list1,item)  || allAncestor(node.right,list1,item))
    		return true;
    	list1.remove(list1.size()-1);
    	return false;
    }
    
    public void LCA(int item1,int item2)
    {
      ArrayList<Integer> list1=new ArrayList<>();
      getpath(this.root,item1,list1);
      ArrayList<Integer> list2=new ArrayList<>();
      getpath(this.root,item2,list2);
      int f=0;
      for(int i=list1.size()-1;i>=0;i--)
      {
    	  for(int j=list2.size()-1;j>=0;j--)
    	  {
    		  if(list1.get(i)==list2.get(j))
    		  {
    			  System.out.println(list1.get(i));
    			  f=1;
    			  break;
    		  }
    		  if(f==1)
    			  break;
    	  }
      }
      
    }
    
    public void printLCA(int item1,int item2)
    {
      Node t=	printLCA(this.root,item1,item2);
      System.out.println(t.data);
    }
    
    private Node printLCA(Node node,int n1, int n2)
    {
    	if(node==null)
    	{
    		return null;
    	}
    	if(node.data==n1 || node.data==n2)
    	{
    		return node;
    	}
    	Node left=printLCA(node.left,n1,n2);
     	Node right=printLCA(node.right,n1,n2);
     	if(left!=null && right!=null)
     	{
     		return node;
     	}
     	return left!=null ? left : right;
    }
    
    public void verticalsum()
    {
    	HashMap<Integer,Integer>map=new HashMap<>();
    	vsum(map,this.root,0);
    	System.out.println();
    	ArrayList<Integer>m=new ArrayList<>(map.keySet());
    	Collections.sort(m);
    	for(int k : m)
    		System.out.print(map.get(k)+ " ");
    }
    
    private void vsum(HashMap<Integer,Integer> map, Node node,int c)
    {
    	if(node.left!=null)
    		vsum(map,node.left,c-1);
    	
    	if(node.right!=null)
    		vsum(map,node.right,c+1);
    	
    	int data=0;
    	if(map.containsKey(c))
    		data=map.get(c);
    	
    	map.put(c, data+node.data);
   }
 
    public void sumofAllRootToLeaf()
    {
	  System.out.println( sumofAllRootToLeaf(0,this.root));
    }

     private int sumofAllRootToLeaf(int val, Node root) {
	
	 if(root==null)
	 {
		return 0;
	 }
	
	 val=val*10 + root.data;
	 if(root.left==null && root.right==null)
		return val;
	
	  return sumofAllRootToLeaf(val, root.left) + sumofAllRootToLeaf(val, root.right);
   }
 
     public void vertical()
     {
    	 HashMap<Integer,ArrayList<Integer>> m=new HashMap<>();
    	vertical(this.root,m,0); 
    	 ArrayList<Integer>li=new ArrayList<>(m.keySet());
    	 Collections.sort(li);
    	for(int k:li)
    	{
    	
    		for(int i=m.get(k).size()-1;i>=0;i--)
    		{
    		 System.out.print(m.get(k).get(i) + " ");
    		}
    		System.out.println();	
    	}
     }
     
     private void vertical(Node node, HashMap<Integer,ArrayList<Integer>> m,int c)
     {
    	 if(node.left!=null)
    		 vertical(node.left, m,c-1); 
    	 
    	 if(node.right!=null)
    		 vertical(node.right, m,c+1); 
    	 
    	 if(m.containsKey(c))
    		 m.get(c).add(node.data);
    	 else
    	 {
    		 ArrayList<Integer>li=new ArrayList<>();
    		 li.add(node.data);
    		 m.put(c,li);
    	 }
     }
     
     public static boolean printAncestors(Node node, int x)
     {
         ArrayList<Integer>l=new ArrayList<>();
         getpat(node,x,l);
         for(int i=0;i<l.size()-2;i++)
         {
         System.out.print(l.get(i)+ " ");
         }
		return false;
         
     }
     
     public static boolean getpat(Node node,int x,ArrayList<Integer> l)
     {
         if(node==null)
         {
             return false;
         }
         l.add(node.data);
         if(node.data==x)
         {
             return true;
         }
         if(getpat(node.left,x,l) || getpat(node.right,x,l))
         return true;
         
         l.remove(l.size()-1);
         return false;
     }
     
    public boolean haspathSum(int sum)
     {
    	 return haspathSum(root,sum);
     }

	private boolean haspathSum(Node node, int sum)
	{
		if(node==null)
		{
			return false;
		}
		else
		{
		boolean ans=false;	
		int subsum=sum-node.data;
		if(subsum==0 && node.left==null && node.right==null)
		{
			return true;
		}
		if(node.left!=null)
			 ans=ans || haspathSum(node.left,subsum);
		if(node.right!=null)
			 ans=ans || haspathSum(node.right,subsum);
		return ans;
		}
	}
     
	public int MinDepth()
	{
		return MinDepth(this.root);
	}
	
	private int MinDepth(Node node)
	{
		if(node==null)
		{
			return 0;
		}
		if(node.left==null && node.right==null)
		{
			return 1;
		}
		if(node.left==null)
		return MinDepth(node.right)+1;
		
		if(node.right==null)
		return MinDepth(node.left)+1;
		
		return Math.min(MinDepth(node.right),MinDepth(node.left))+1;
	}
	
	public ArrayList<ArrayList<Integer>> RootToLeafPathsWithSum(int sum)
	{
		 ArrayList<ArrayList<Integer>> res=RootToLeafPathsWithSum(root,sum);
			return res;
	}
	
	private ArrayList<ArrayList<Integer>> RootToLeafPathsWithSum(Node node,int sum)
	{
		if(node==null)
		{
			return null;
		}
		 ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		 ArrayList<Integer>l=new ArrayList<>();
		 l.add(node.data);
		RootToLeafPathsWithSum(root,sum-root.data,res,l);
		return res;
	}
	
	private void RootToLeafPathsWithSum(Node node,int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> l)
	{
		if(node.left==null && node.right==null && sum==0)
		{
			ArrayList<Integer>temp=new ArrayList<>();
			temp.addAll(l);
			res.add(temp);
		}
		
		if(node.left!=null)
		{
			l.add(node.left.data);
			RootToLeafPathsWithSum(node.left,sum-node.left.data,res,l);
			l.remove(l.size()-1);
		}
		if(node.right!=null)
		{
			l.add(node.right.data);
			RootToLeafPathsWithSum(node.right,sum-node.right.data,res,l);
			l.remove(l.size()-1);
		}
		
	}
	
	public void BinaryTreeToMirrorTree()
	{
		BinaryTreeToMirrorTree(this.root);
	}
	
	private Node BinaryTreeToMirrorTree(Node node)
	{
		if(node==null)
		{
			return node;
		}
		
		Node left=BinaryTreeToMirrorTree(node.left);
		Node right=BinaryTreeToMirrorTree(node.right);
		
		node.left=right;
		node.right=left;

		return node;
	}
	
}
    
    
    
    
    
    
    
   
