package Graphh;
import java.util.*;

public class ConnectedComponents {

	 int v;
	 LinkedList<Integer>[] adj;
	 
	 ConnectedComponents(int v)
	 {
		 this.v=v;
		adj=new LinkedList[v];
		
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	 }
	 
	 public void addEdge(int src, int dest)
	 {
		 adj[src].add(dest);
		 adj[dest].add(src);
	 }
	 
	 public void  DFSUtil(int i,boolean visited[])
	 {
		visited[i]=true;
		System.out.print(i + " ");
		for(int x:adj[i])
		{
			if(!visited[x])
			{
				 DFSUtil(x,visited);	
			}
		}
	 }
	 
	 public void connectedComponents()
	 {
		 boolean visited[]=new boolean[v];
		 for(int i=0;i<v;i++)
		 {
		 if(!visited[i])
		 {
			 DFSUtil(i,visited);
			 System.out.println();
		 }
		 }
	 }
	 
	 public static void main(String args[])
	 {
		 
		 ConnectedComponents  g=new ConnectedComponents (5);
	     g.addEdge(1, 0);
	     g.addEdge(2, 3);
	     g.addEdge(3, 4);
	     g.connectedComponents();
	 }
	
}
