package Queue;

import java.util.*;

public class RottenOranges {

	static class cell
	{
		int i;
		int j;
		cell(int i,int j)
		{
			this.i=i;
			this.j=j;
		}
	}
	
	public static void main(String[] args) {
		

		  Scanner sc=new Scanner(System.in);
		  int tc=sc.nextInt();
		  while(tc>0)
		  {
		      int n=sc.nextInt();
		      int m=sc.nextInt();
		      int a[][]=new int[n][m];
		      for(int i=0;i<n;i++)
		      {
		          for(int j=0;j<m;j++)
		          {
		              a[i][j]=sc.nextInt();
		          }
		      }
		      
			     Queue<cell>q=new LinkedList<>(); 
		      for(int i=0;i<n;i++)
		      {
		          for(int j=0;j<m;j++)
		          {
		             if(a[i][j]==2)
		             {
		            	 q.add(new cell(i,j));
		             }
		          }
		      }
		    
		     q.add(new cell(-1,-1));
		     int ans=0;
		     
		     while(!q.isEmpty())
		     {
		    	 boolean flag=false;
		    	 while(!isD(q.peek()))
		    	 {
		    		 cell t=q.peek();
		    		 if(isValid(t.i+1,t.j,n,m) && a[t.i+1][t.j]==1)
		    		 {
		    			if(!flag)
		    			{
		    				flag=true;
		    				ans++;
		    			}
		    			t.i=t.i+1;
		    			a[t.i][t.j]=2;
		    			q.add(new cell(t.i,t.j));
		    			t.i=t.i-1;
		    		 }
		    		 if(isValid(t.i-1,t.j,n,m) && a[t.i-1][t.j]==1)
		    		 {
		    			if(!flag)
		    			{
		    				flag=true;
		    				ans++;
		    			}
		    			t.i=t.i-1;
		    			a[t.i][t.j]=2;
		    			q.add(new cell(t.i,t.j));
		    			t.i=t.i+1;
		    		 }
		    		 if(isValid(t.i,t.j+1,n,m) && a[t.i][t.j+1]==1)
		    		 {
		    			if(!flag)
		    			{
		    				flag=true;
		    				ans++;
		    			}
		    			t.j=t.j+1;
		    			a[t.i][t.j]=2;
		    			q.add(new cell(t.i,t.j));
		    			t.j=t.j-1;
		    		 }
		    		 if(isValid(t.i,t.j-1,n,m) && a[t.i][t.j-1]==1)
		    		 {
		    			if(!flag)
		    			{
		    				flag=true;
		    				ans++;
		    			}
		    			t.j=t.j-1;
		    			a[t.i][t.j]=2;
		    			q.add(new cell(t.i,t.j));
		    			t.j=t.j+1;
		    		 }
		    		 q.remove();
		    	 }
		    	 q.remove();
		    	 if(!q.isEmpty())
		    	 {
		    		 q.add(new cell(-1,-1));
		    	 }
		     }
		     int h=0;
		     for(int i=0;i<n;i++)
		     {
		    	 for(int j=0;j<m;j++)
		    	 {
		    	    if(a[i][j]==1)
		    	    {
		    	    	h=1;
		    	    }
		    	 }
		     }
		     
		     if(h==1)
		    	 System.out.println(-1);
		     else
		    	 System.out.println(ans);
		     
          tc--;
		  }
	}
	
	 
	public static boolean isD(cell q)
	{
		return (q.i==-1 && q.j==-1);
	}
	
	public static boolean isValid(int i,int j,int n,int m)
	{
		return (i>=0 && j>=0 && i<n && j<m);
	}
	
}
