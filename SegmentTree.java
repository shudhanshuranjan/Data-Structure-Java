package open;

public class SegmentTree {
	
	public class Node
	{
		int startInterval;
		int endInterval;
		Node left;
		Node right;
		int data;
	}
	
	Node root;
	
	public SegmentTree(int arr[])
	{
		this.root=construct(arr,0,arr.length-1);
	}
	
	private Node construct(int arr[],int si,int ei)
	{
		
		if(si==ei)
		{
			Node leafNode=new Node();
			  leafNode.data=arr[si];
			leafNode.startInterval=si;
		    leafNode.endInterval=ei;
		    return leafNode;
		}
		
		Node node=new Node();
		node.startInterval=si;
		node.endInterval=ei;
		int mid=(si+ei)/2;
		node.left=construct(arr,si,mid);
		node.right=construct(arr,mid+1,ei);
		node.data=node.left.data+node.right.data;
		return node;
	
	}
	
	public void display()
	{
		display(this.root);
	}
	
	private void display(Node node)
	{
		if(node==null)
		{
			return ;
		}
		String str=" ";
		if(node.left!=null)
		{
			str += " Interval = [ " + node.left.startInterval + "-" + node.left.endInterval + " ] and Data is " + node.left.data;
		}
		else
		{
			str += " No left Child  => " ;
		}
		
		str +=  " Interval = [ " + node.startInterval + "-" + node.endInterval + " ] " + " Data is " + node.data;
		
		if(node.right!=null)
		{
			str += " Interval = [ " + node.right.startInterval + "-" + node.right.endInterval + " ] " + " Data is " + node.right.data;
		}
		else
		{
			str += " <=  No right Child";
		}
		System.out.println(str);
		
		display(node.left);
		display(node.right);
		
	}
	
    public int query(int qsi,int qei)
    {
    	return query(this.root,qsi,qei);
    }
    
    private int query(Node node, int qsi, int qei)
    {
    
    	if(node.startInterval >= qsi && node.endInterval <= qei )
    	{
    		return node.data;
    	}
    	else if(node.startInterval > qei || node.endInterval < qsi)
    	{
    		return 0;
    	}
    	else 
    	{
    	   int leftans=query(node.left,qsi,qei);
    	   int rightans=query(node.right,qsi,qei);
    	   return leftans+rightans;
    	}
    	
    }

    public void update(int q, int value)
    {
    	this.root.data=update(this.root,q,value);
    }
    
    private int update(Node node,int q, int value)
    {
    	
    	if(q>=node.startInterval && q<=node.endInterval)
    	{
    		if(q==node.startInterval && q==node.endInterval)
    		{
    			node.data=value;
    		}
    		else
    		{
    			int leftans=update(node.left,q,value);
    			int rightans=update(node.right,q,value);
    			node.data=leftans+rightans;
    		}
    	}
    	return node.data;
    	
    	
    	
    }
}
