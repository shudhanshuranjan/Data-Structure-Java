package DP;
import java.util.*;
import java.lang.*;
import java.io.*;

class PathInMatrixMax {
	public static void main (String[] args) {
	
	  Scanner sc=new Scanner(System.in);
	  int t=sc.nextInt();
	  
	  while(t>0)
	  {
	      int n=sc.nextInt();
	      int c[][]=new int[n+1][n+1];
	      for(int i=1;i<=n;i++)
	      {
	          for(int j=1;j<=n;j++)
	          {
	              int k=sc.nextInt();
	              c[i][j]=k;
	          }
	      }
	      int tc[][]=new int[n+1][n+1];
	      for(int i=1;i<=n;i++)
	      {
	          tc[1][i]=c[1][i];
	      }
	      int aa=0,bb=0,cc=0;
	      for(int i=2;i<=n;i++)
	      {
	         for(int j=1;j<=n;j++)
	          {
	           if(j-1>=1)
	           aa=tc[i-1][j-1];
	           
	           bb=tc[i-1][j];
	           
	           if(j+1<=n)
	           cc=tc[i-1][j+1];
	        //     System.out.println(aa +" "+bb+ " "+cc);
	         //      System.out.println(c[i][j]);
	           tc[i][j]=Math.max(aa,Math.max(bb,cc))+c[i][j];
	          }
	      }
	  
	      
	      int max=0;
	      
	      for(int i=1;i<=n;i++)
	      {
	          if(tc[n][i]>max)
	          max=tc[n][i];
	      }
	    System.out.println(max);   
	      
	      t--;
	  }
	   
	}
}