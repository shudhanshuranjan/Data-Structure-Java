package open;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	
	Scanner sc=new Scanner(System.in);
	
	public class Node
	{
		int data;
		ArrayList<Node> children=new ArrayList<>();
	}

	private Node root=null;
	
	public GenericTree()
	{
		this.root=takeinput(root,-1);
	}


	private Node takeinput(Node node,int ith) 
	{
	
		if(node==null)
		{
			System.out.println(" Enter the data for root node ");
		}
		else
		{
			System.out.println("Enter the " + ith + " child of " + node.data);
		}
		
		int item=sc.nextInt();
		Node nn=new Node();
		nn.data = item;
	    System.out.println(" enter the no. of children of " + nn.data);
		int noc=sc.nextInt();
		
		for(int i=0;i<noc;i++)
		{
		Node child=takeinput(nn,i);
		nn.children.add(child);
		}
		
		return nn;
	}
	
	public void display() {
		System.out.println("---------------------");
		display(this.root);
		System.out.println("---------------------");
	}
	
	private void display(Node node) 
	{
		String str = node.data + "->";
		for(Node child : node.children)
		{
			str+=child.data + ", ";
		}
		str+= ".";
		
		System.out.println(str);
		
		for(Node child : node.children )
		{
			display(child);
		}
		
	}
	
	public int size()
	{
		int si=size(this.root);
		return si;
	}
	
	private int size(Node node)
	{
	
		int ans=0;
		for(Node n : node.children)
		{
			int cs=size(n); 
			ans += cs;
		}
		return ans+1;
		
	}

}
