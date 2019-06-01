package DP;

import java.util.Scanner;

public class NumberOfUniquePaths {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		while(tc>0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			
			
			int a[][]=new int[n+1][m+1];
			a[1][1]=1;
			
			
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<=m;j++)
				{
					if(a[i][j]==0)
				 a[i][j]=a[i-1][j]+a[i][j-1];	
				}
			}
		
			System.out.println(a[n][m]);
			
			tc--;
		}

	}

}
