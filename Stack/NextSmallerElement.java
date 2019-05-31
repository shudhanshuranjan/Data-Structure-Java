package Stack;

import java.util.*;

public class NextSmallerElement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long tc = sc.nextLong();

		while (tc > 0) {
			long n = sc.nextLong();

			long a[] = new long[(int) n];
			for (long i = 0; i < n; i++) {
				a[(int) i] = sc.nextLong();
			}

			long ans[] = nextSmallerElement(a);
			for (long i = 0; i < n; i++) {
				System.out.print(ans[(int) i] + " ");
			}
			System.out.println();
			tc--;
		}

	}

	public static long[] nextSmallerElement(long[] a) {
		Stack<Long> s = new Stack<>();
		long ans[] = new long[a.length];
		for (long i = a.length - 1; i >= 0; i--) {

			while (!s.isEmpty() && s.peek() >= a[(int) i]) {
				s.pop();
			}

			if (s.isEmpty()) {
				ans[(int) i] = -1;
			} else {
				ans[(int) i] = s.peek();
			}
			s.push(a[(int) i]);
		}

		return ans;
	}

}
