package DP;

import java.util.*;

public class UniquePathsWithObstacles {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
			int n = sc.nextInt();
			int m = sc.nextInt();

			ArrayList<ArrayList<Integer>> ll = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				ll.add(new ArrayList<Integer>());
				for (int j = 0; j < m; j++) {
					int kk = sc.nextInt();
					ll.get(i).add(kk);
				}
			}
		System.out.println(uniquePathsWithObstacles(ll));

	}

	public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {

		int n = A.size();
		int m = A.get(0).size();

		if (A.get(0).get(0) == 1) {
			return 0;
		}

		int a[][] = new int[n][m];

		a[0][0] = 1;
		int a1 = 0;
		int b1 = 0;
		// for(int i=0;i<n;i++)
		// {
		// for(int j=0;j<m;j++)
		// {
		// System.out.print(a[i][j]+ " ");
		// }
		// System.out.println();
		// }
		for (int i = 0; i < n; i++) {
			a1 = 0;
			b1 = 0;
			for (int j = 0; j < m; j++) {
				if (A.get(i).get(j) != 1 && a[i][j] != 1) {
					if (j - 1 >= 0) {
						a1 = a[i][j - 1];
					}
					if (i - 1 >= 0) {
						b1 = a[i - 1][j];
					}
					a[i][j] = a1 + b1;
				}
			}
		}
		// for(int i=0;i<n;i++)
		// {
		// for(int j=0;j<m;j++)
		// {
		// System.out.print(a[i][j]+ " ");
		// }
		// System.out.println();
		// }

		return a[n - 1][m - 1];

	}

}
