package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DP {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
//		int a[]= {2,3,1,1,2,4,2,0,1,1};
//		MinimumJumpToReachEnd(a);
	//	int n = sc.nextInt();
	//	uglyNumber(n);
	}


	public static void MinimumJumpToReachEnd(int a[]) {
		ArrayList<Integer> f = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		ArrayList<Integer> t = new ArrayList<>();
		f.add(0);
		int u = 0;
		for (int i = 1; i < a.length; i++) {
			int min = Integer.MAX_VALUE;
			int y = 0;
			for (int j = 0; j <= i - 1; j++) {
				if (j + a[j] >= i) {
					u = f.get(j) + 1;
					if (u < min) {
						y = j;
						min = u;
					}
				}
			}
			s.add(y);
			f.add(min);
		}
//    	System.out.println(s);
//   System.out.println(f);
		for (int i = 0; i < s.size(); i++) {
			if (t.contains(s.get(i))) {

			} else {
				t.add(s.get(i));
			}
		}
		// System.out.println(t);
		for (int i = 0; i < t.size(); i++) {
			System.out.print(a[t.get(i)] + " -> ");
		}
		System.out.print(a[a.length - 1]);
		System.out.println();
		if (f.contains(Integer.MAX_VALUE) || f.contains(Integer.MIN_VALUE))
			System.out.println(-1);
		else
			System.out.println(f.get(f.size() - 1));
	}

	public static void uglyNumber(int n) {

	      ArrayList<Long> l = new ArrayList<>();
			long num[] = { 2, 3, 5 };
			l.add((long) 1);
			HashMap<Integer, Integer> m = new HashMap<>();
			m.put(2, 0);
			m.put(3, 0);
			m.put(5, 0);
			long a = 2, b = 3, c = 5;
			for (int i = 1; i < n; i++) {
			//	System.out.println(a+ " " + b + " " + c);
				long ad = Math.min(a, Math.min(b, c));
			//	if(!l.contains(ad))
				l.add(ad);
				if (ad == a) {
					long t = m.get(2);
					t++;
					m.put(2, (int) t);
					a = 2 * l.get(m.get(2));
				}
			   if (ad == b) {
					long t = m.get(3);
					t++;
					m.put(3, (int) t);
					b = 3 * l.get(m.get(3));
				}
			 if (ad == c) {
				   long t = m.get(5);
					t++;
					m.put(5, (int) t);
					c = 5 * l.get(m.get(5));
				}
			}
			System.out.println(l.get(l.size()-1));  
	}
}
