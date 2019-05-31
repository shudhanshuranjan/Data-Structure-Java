package Stack;

import java.util.*;

public class StockSpanProblem {

	public static void main(String[] args) {


		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		
		while(tc>0)
		{
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			int k=sc.nextInt();
			a[i]=k;
		}
		int ans[]=new int[n];
		ans[0]=1;
		
		Stack<Integer>s=new Stack<>();
		s.push(0);
		for(int i=1;i<n;i++)
		{
			
			while(!s.isEmpty() && a[s.peek()]<=a[i])
			{
				s.pop();
			}
			if(s.isEmpty())
			{
				ans[i]=i+1;
			}
			else
			{
				ans[i]=i-s.peek();
			}
			
			s.push(i);
		}
		
		
		
		
		for(int i=0;i<n;i++)
		{
			System.out.print(ans[i]+ " ");
		}
		
		System.out.println();
        tc--;
		}
	}

}
