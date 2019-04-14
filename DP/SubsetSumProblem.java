package DP;

import java.util.*;

public class SubsetSumProblem {

	public static void main(String[] args) {
		
		
	Scanner sc=new Scanner(System.in);
	
	int n=sc.nextInt();
	int a[]=new int[n];
	int sum=sc.nextInt();
	for(int i=0;i<n;i++)
	{
		a[i]=sc.nextInt();
	}

	
	boolean aa[][]=new boolean[n][sum+1];
	
	for(int i=0;i<n;i++)
	{
		aa[i][0]=true;
	}

	for(int i=0;i<=sum;i++)
	{
		if(a[0]==i)
		{
			aa[0][i]=true;	
		}
	}
	
	for(int i=1;i<n;i++)
	{
		for(int j=0;j<=sum;j++)
		{
		   if(a[i]>j)
		   {
			   aa[i][j]=aa[i-1][j];
		   }
		   else
		   {
			   aa[i][j]=aa[i-1][j] || aa[i-1][j-a[i]];
		   }
		}
	}
	
	
	
	
//	for(int i=0;i<n;i++)
//	{
//		for(int j=0;j<=sum;j++)
//		{
//			System.out.print(aa[i][j]+ " ");
//		}
//		System.out.println();
//	}
	
	System.out.println(aa[aa.length-1][aa[0].length-1]);
	
	
	
	
	}

}
