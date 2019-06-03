package Queue;
import java.util.*;
public class MaximumSlidingWindow {

	public static void main(String[] args) {
		
	       int arr[]={23,4,57,90,87,76,39,80}; 
	       int k=3;
	       printmax(arr,k,arr.length); 
	}
	
	public static void printmax(int arr[], int k, int n)
	{
		Deque<Integer> dq=new LinkedList<>();
		
		for(int i=0;i<k;i++)
		{
			while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
			{
				dq.removeLast();
			}
			dq.addLast(i);
		}
		
		for(int i=k;i<n;i++)
		{
			System.out.print(arr[dq.peek()] + " ");
			while(!dq.isEmpty() && dq.peek() <= i-k)
			{
				dq.removeFirst();
			}
			while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
			{
				dq.removeLast();
			}
			dq.addLast(i);
		}
		System.out.print(arr[dq.peek()] + " ");
	}

}
