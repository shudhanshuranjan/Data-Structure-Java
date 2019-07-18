package Graphh;

import java.util.*;

public class DetectCycleInAnUndirectedGraphUsingBFS {

	int v;
	LinkedList<Integer> adj[];
     
	DetectCycleInAnUndirectedGraphUsingBFS(int v)
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
	
	public boolean isCycle(boolean visit[], int s)
	{
		
        LinkedList<Integer> q=new LinkedList<>();		
		
       int parent[]=new int[v];
		q.add(s);
		visit[s]=true;
		
		Arrays.fill(parent, -1);
		
		while(!q.isEmpty())
		{
			int u=q.poll();
			
			for(int x:adj[u])
			{
				if(!visit[x])
				{
					visit[x]=true;
					q.add(x);
					parent[x]=u;
				}
				else if(parent[u]!=x)
				{
					return true;
				}
			}
			
		}
		
		
		return false;
	}
	
	public static void main(String[] args) {
	
		DetectCycleInAnUndirectedGraphUsingBFS s=new DetectCycleInAnUndirectedGraphUsingBFS(4);
		
		s.addEdge(0,1);
		s.addEdge(1,2);
		s.addEdge(2,0);
		s.addEdge(2,3);
		
		boolean visit[]=new boolean[4];
		int f=0;
		for(int i=0;i<4;i++)
		{
			if(!visit[i] && s.isCycle(visit,i))
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
