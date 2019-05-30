package DP;

import java.util.*;

public class MinJumpsReq {

	public static void main(String[] args) {

      Scanner sc=new Scanner(System.in);
      int tc=sc.nextInt();
      while(tc>0)
      {
int n=sc.nextInt();
      int a[]=new int[n];
      for(int i=0;i<n;i++)
      {
    	  a[i]=sc.nextInt();
      }
      int u=0;
     int Z=0;
     int z=0;
 
      ArrayList<Integer>f=new ArrayList<>();
      f.add(0);
      for(int i=1;i<n;i++)
      {
    	  int min=Integer.MAX_VALUE;
    	  for(int j=0;j<i;j++)
    	  {
    		  if(j+a[j]>=i)
    		  {
    			 u=f.get(j)+1;
    			 if(u<min)
    			 {
    				 min=u;
    			 }
    		  }
    	  }
    	  f.add(min);
      }
      System.out.println(f);
    //  System.out.println(f.get(f.size()-1));
      tc--;
      }
	}

}
