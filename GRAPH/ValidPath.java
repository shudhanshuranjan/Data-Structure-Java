package Graphh;
import java.util.*;
public class ValidPath {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
        int x=sc.nextInt();
        int y=sc.nextInt();
        int n=sc.nextInt();
        int r=sc.nextInt();
        ArrayList<Integer>e=new ArrayList<>();
        e.add(2);
        ArrayList<Integer>f=new ArrayList<>();
        f.add(3);
        System.out.println(solve(x,y,n,r,e,f));
	}
	
	public static String solve(int A,int B,int C,int D,ArrayList<Integer> E, ArrayList<Integer> F)
	{
		int n=C;
		int r=D;
		int valid[][]=new int[A+1][B+1];
		for(int i=0;i<=A;i++)
		{
			for(int j=0;j<=B;j++)
			{
			  for(int z=0;z<n;z++)
			  {
				  if(Math.sqrt(Math.pow(E.get(z)-i,2)+Math.pow(F.get(z)-j,2))<=r)
				{
					valid[i][j]=-1;
				}
			  }
			}
		}
		
		 if(valid[0][0]==-1 || valid[A][B]==-1)
		        return "NO";
		        
		        int[] x = {1,1,1,-1,-1,-1,0,0};
		        int[] y = {-1,1,0,-1,1,0,1,-1};
		        boolean visit[][]=new boolean[A+1][B+1]; 
		        
		        visit[0][0]=true;
		        Queue<Integer> q=new LinkedList<>();
		        
		        q.add(0);
		        q.add(0);
		
		       while(!q.isEmpty())
		       {
			     int c=q.poll();
			     int d=q.poll();
			     
			     for(int i=0;i<8;i++)
			     {
			    	 int ix=x[i]+c;
			    	 int iy=y[i]+d;
			    	 
			    	 if(!(ix<0 || iy<0 || ix>A || iy>B) && !visit[ix][iy] && valid[ix][iy]!=-1)
			    	 {
			    		 if(ix==A && iy==B)
			                {
			                    return "YES";
			                }
			                q.add(ix);
			                q.add(iy);
			    		visit[ix][iy]=true; 
			    	 }
			    	 
			     }
			     
		       }
		   return "NO";
	}

}
