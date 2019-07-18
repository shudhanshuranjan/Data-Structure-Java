package Graphh;

import java.util.Arrays;
import java.util.LinkedList;

public class DetectCycleInAnUndirectedGraphUsingDFS {

	int v;
	LinkedList<Integer> adj[];
     
	DetectCycleInAnUndirectedGraphUsingDFS(int v)
	{
		this.v=v;
		adj=new LinkedList[v];
		
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
		
	}
	
	public void addEdge(int u, int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}
	
	
	public boolean isCycle(boolean visit[], int u, int parent)
	{
		
		visit[u]=true;
		
		for(int x: adj[u])
		{
			if(!visit[x])
			{
				if(isCycle(visit, x, u))
					return true;
			}
			else if(x!=parent)
			{
				return true;
			}
		}
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		
      DetectCycleInAnUndirectedGraphUsingDFS s=new DetectCycleInAnUndirectedGraphUsingDFS(5);
		
		s.addEdge(1,0);
		s.addEdge(0,2);
	//	s.addEdge(2,0);
		s.addEdge(0,3);
		s.addEdge(3,4);
		 
//      s.addEdge(0, 1); 
//      s.addEdge(1, 2);
      
      
		boolean visit[]=new boolean[5];
		int f=0;
		for(int i=0;i<5;i++)
		{
			if(!visit[i] && s.isCycle(visit,i,-1))
			{
				f=1;
				System.out.println("Cycle is present");
				break;
			}
		}
		if(f==0)
		{
			System.out.println("Cycle is not present");
		}

	}

}
