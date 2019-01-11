package open;

import java.util.Scanner;

public class BinaryTree {

	Scanner sc=new Scanner(System.in);
	private class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	Node root=null;
	
	BinaryTree()
	{
		this.root=takeInput(root,false);
	}

	private Node takeInput(Node parent, boolean b) 
	{
		if(parent==null)
		{
			System.out.println("Enter the data for root node");
		}
		else
		{
			if(b)
			{
				System.out.println( " enter data for left child of " + parent.data );
			}
			else
			{
				System.out.println (" enter data for right child of " + parent.data);
			}
		}
		
		int item=sc.nextInt();
		Node nn=new Node();
		nn.data=item;
		 System.out.println(nn.data + " has left child ");
		 boolean ilc=sc.nextBoolean();
		 if(ilc)
		 {
			nn.left=takeInput(nn,true); 
		 }
		 System.out.println(nn.data + " has right child ");
		 boolean hrc=sc.nextBoolean();
		 if(hrc)
		 {
			nn.right=takeInput(nn,false); 
		 }
		 return nn;
	}
	
	public void display()
	{
		System.out.println();
		display(this.root);
		System.out.println();
	}

	private void display(Node node) {
		
		if(node==null)
		{
			return ;
		}
		String str="";
		if(node.left==null)
		{
			str+=".";
		}
		else
		{
			str+= node.left.data;
		}
		
		str+= "<-" + node.data + "->" ;
		if(node.right==null)
		{
			str+=".";
		}
		else
		{
			str+= node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int height()
	{
	int h=height(this.root);	
	return h;
	}

	private int height(Node node) {
		
		if(node==null)
		{
		return -1;
		}
		
		int lh=height(node.left);
		int rh=height(node.right);
		
		return Math.max(lh, rh)+1;
	}
	
	public int size()
	{
		int s=size(this.root);
		return s;
	}

	private int size(Node node) {
		
		
		if(node==null)
		{
			return 0;
		}
		
		int ls=size(node.left);
		int rs=size(node.right);
		
		return ls+rs+1;
	}
	
    public int max()
    {
    	int ma=max(this.root);
    	return ma;
    }

	private int max(Node node) {
		
		if(node==null)
		{
			return Integer.MIN_VALUE;
		}
		int rs=node.data;
		int lm=max(node.left);
		int rm=max(node.right);
		if(lm > rs)
		{
			rs=lm;
		}
		if(rm > rs)
		{
			rs=rm;
		}
		return rs;
		
	}

	public int min()
	{
		int mi=min(this.root);
		return mi;
	}

	private int min(Node node) {
		
		if(node==null)
		{
			return Integer.MAX_VALUE;
		}
		int res=node.data;
		int lmin=min(node.left);
		int hmin=min(node.right);
		if(res > lmin)
		{
			res = lmin;
		}
		if(res > hmin)
		{
			res = hmin;
		}
		
		return res;
	}

	public boolean find(int data)
	{
		return find(this.root,data);
	}
	
	private boolean find(Node node,int item)
	{
		if(node==null)
		{
			return false;
		}
		if(node.data==item)
		{
			return true;
		}
		return find(node.left,item) || find(node.right,item)  ;	
	}
}
