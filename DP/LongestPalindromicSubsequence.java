package DP;

import java.util.*;
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();

		
		System.out.println(subseq(str1));

	}
	
	public static int subseq(String str1)
	{
		int a[][]=new int[str1.length()][str1.length()];
		
		for(int i=0;i<str1.length();i++)
		{
			a[i][i]=1;
		}
		
		for(int l=2;l<=str1.length();l++)
		{
			for(int i=0;i<str1.length()-l+1;i++)
			{
				int j=i+l-1;
				if(l==2 && str1.charAt(i)==str1.charAt(j))
				{
					a[i][j]=2;
				}
				else if(str1.charAt(i)==str1.charAt(j))
				{
					a[i][j]=a[i+1][j-1]+2;
				}
				else
				{
					a[i][j]=Math.max(a[i+1][j], a[i][j-1]);
				}
			}
		}
		return a[0][str1.length()-1];
	}
	

	

}
