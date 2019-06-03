package Queue;

import java.util.*;

public class FirstNegativeIntegerInWindowSizeB {
	public static void main(String[] args) {

		int arr[] = { -8, 2, 3, -6, 10 };
		int k = 2;
		printmax(arr, k, arr.length);
	}

	public static void printmax(int a[], int k, int n) {

		Deque<Integer> dq = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			if (a[i] < 0) {
				dq.addLast(i);
			}
		}

		for (int i = k; i < n; i++) {
			if (!dq.isEmpty())
				System.out.print(a[dq.peek()] + " ");
			else
				System.out.print(0 + " ");

			while (!dq.isEmpty() && dq.peek() <= i - k) {
				dq.removeFirst();
			}

			if (a[i] < 0) {
				dq.addLast(i);
			}
		}
		if (!dq.isEmpty())
			System.out.print(a[dq.peek()] + " ");
		else
			System.out.print(0 + " ");

	}

}
