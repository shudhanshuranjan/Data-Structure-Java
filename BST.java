package Tree;
public class BST {
	
	private class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	private Node root;
	
	public BST(int arr[])
	{
		this.root=construct(arr,0,arr.length-1);
	}
	
	private Node construct(int arr[],int lo, int hi)
	{
		if(lo>hi)
		{
			return null;
		}
		
		int mid=(lo+hi)/2;
		Node nn=new Node();
		nn.data=arr[mid];
		nn.left=construct(arr,lo,mid-1);
		nn.right=construct(arr,mid+1,hi);
		return nn;
	}
	
	public void display()
	{
		System.out.println();
		display(this.root);
		System.out.println();
	}
	
	private void display(Node node)
	{
		String str ="";
		if(node==null)
		{
			return ;
		}
		
		if(node.left!=null)
		{
		 str += node.left.data;	
		}
		else
		{
			str+= ".";
		}
		
		if(node.right!=null)
		{
		 str += node.right.data;	
		}
		else
		{
			str+= ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
}
