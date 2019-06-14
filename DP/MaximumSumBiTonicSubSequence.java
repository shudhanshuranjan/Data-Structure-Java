package DP;

import java.util.Scanner;

public class MaximumSumBiTonicSubSequence {

	public static void main(String[] args) {
		
		

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc > 0) {
			
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=sc.nextInt();
			}
			
			int a1[]=new int[n];
			int a2[]=new int[n];
			int a3[]=new int[n];
			
			for(int i=0;i<n;i++)
			{
				a1[i]=a[i];
				a2[i]=a[i];
			}
			
			
			for(int i=1;i<n;i++)
			{
				for(int j=0;j<i;j++)
				{
					if(a[i]>a[j] && a1[i]<a1[j]+a[i])
					a1[i]=a1[j]+a[i];
				}
			}
			
			for(int i=n-2;i>=0;i--)
			{
				for(int j=n-1;j>i;j--)
				{
					if(a[i]>a[j] && a2[i]<a2[j]+a[i])
					a2[i]=a2[j]+a[i];
				}
			}
			
			for(int i=0;i<n;i++)
			{
				a3[i]=a1[i]+a2[i]-a[i];
			}
			int mx=-1;
			for(int i=0;i<n;i++)
			{
				if(mx<a3[i])
				{
					mx=a3[i];
				}
			}
			System.out.println(mx);
			tc--;
		}

	}

}
