package DP;

import java.util.*;

public class MaximumSumBitonicSubarray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc > 0)

		{
			int n = sc.nextInt();
			long a[] = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}

			long a1[] = new long[n];
			long a2[] = new long[n];
			long a3[] = new long[n];

			a1[0] = a[0];
			for (int i = 1; i < n; i++) {
				if (a[i] > a[i - 1]) {
					a1[i] = a1[i - 1] + a[i];
				} else {
					a1[i] = a[i];
				}
			}
			a2[n - 1] = a[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				if (a[i] > a[i + 1]) {
					a2[i] = a2[i + 1] + a[i];
				} else {
					a2[i] = a[i];
				}
			}

			for (int i = 0; i < n; i++) {
				a3[i] = a1[i] + a2[i] - a[i];
			}

			long max = -1;
			for (int i = 0; i < n; i++) {
				if (max < a3[i]) {
					max = a3[i];
				}
			}

			System.out.println(max);

			tc--;
		}

	}

}
