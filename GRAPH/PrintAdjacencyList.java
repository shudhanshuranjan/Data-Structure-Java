package Graphh;
import java.util.*; 
 
public class PrintAdjacencyList
{
	static class Graph
	{
		int V;
		LinkedList<Integer>adjlist[];
		
		Graph(int V)
		{
			this.V=V;
			adjlist=new LinkedList[V];
			for(int i=0;i<V;i++)
			{
				adjlist[i]=new LinkedList<>();
			}
		}
		
	}
	
	static void addEdge(Graph graph,int src, int dest)
	{
		graph.adjlist[src].add(dest);
		graph.adjlist[dest].add(src);
	}
	
	static void printgraph(Graph graph)
	{
		for(int i=0;i<graph.V;i++)
		{
			System.out.print(i);
			for(Integer pcrawl : graph.adjlist[i])
			{
				System.out.print("->" + pcrawl);
			}
			System.out.println();
		}
		
	}
	
	public static void main(String args[])
	{
		int V=5;
		Graph graph=new Graph(V);
		addEdge(graph,0,1);
		addEdge(graph, 0, 4); 
        addEdge(graph, 1, 2); 
        addEdge(graph, 1, 3); 
        addEdge(graph, 1, 4); 
        addEdge(graph, 2, 3); 
        addEdge(graph, 3, 4); 
		printgraph(graph);
	}
}