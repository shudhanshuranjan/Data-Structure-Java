package DP;

import java.util.*;
import java.lang.*;
import java.io.*;

class LongestBitonicSubsequence {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc > 0) {
			int nn = sc.nextInt();
			ArrayList<Integer> A = new ArrayList<>();
			for (int i = 0; i < nn; i++) {
				int y = sc.nextInt();
				A.add(y);
			}
			int a1[] = new int[A.size()];
			int a2[] = new int[A.size()];
			for (int i = 0; i < a1.length; i++) {
				a1[i] = 1;
			}
			for (int i = 0; i < a1.length; i++) {
				a2[i] = 1;
			}
			int n = a1.length;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (A.get(j) < A.get(i)) {
						a1[i] = Math.max(a1[j] + 1, a1[i]);
					}
				}
			}

			for (int i = n - 2; i >= 0; i--) {
				for (int j = n - 1; j > i; j--) {
					if (A.get(j) < A.get(i)) {
						a2[i] = Math.max(a2[j] + 1, a2[i]);
					}
				}
			}
			int a3[] = new int[A.size()];

			for (int i = 0; i < n; i++) {
				a3[i] = a1[i] + a2[i] - 1;
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				if (a3[i] > max)
					max = a3[i];
			}
			System.out.println(max);
			tc--;
		}

	}
}