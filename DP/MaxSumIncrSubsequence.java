package DP;

import java.util.Scanner;

public class MaxSumIncrSubsequence {

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
		int a1[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a1[i]=a[i];
		}
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i])
				{
					a1[i]=Math.max(a1[i], a1[j]+a[i]);
				}
		
			}
		//	System.out.println(a1[i]);
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(a1[i]>max)
				max=a1[i];
		}
	System.out.println(max);
		tc--;
		}

	}

}
