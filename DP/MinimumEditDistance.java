package DP;

import java.util.*;

public class MinimumEditDistance {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String A = sc.next();
		String B = sc.next();

		int a[][] = new int[B.length() + 1][A.length() + 1];

		for (int i = 0; i <= B.length(); i++) {
			a[i][0] = i;
		}

		for (int i = 0; i <= A.length(); i++) {
			a[0][i] = i;
		}
		

		for (int i = 1; i <= B.length(); i++) {
			for (int j = 1; j <= A.length(); j++) {
				if (B.charAt(i-1) == A.charAt(j-1)) {
					a[i][j] = a[i - 1][j - 1];
				} else {
					a[i][j] = Math.min(a[i - 1][j], Math.min(a[i - 1][j - 1], a[i][j - 1])) + 1;
				}
			}
		}
	
    System.out.println(a[B.length()][A.length()]);
	}

}
