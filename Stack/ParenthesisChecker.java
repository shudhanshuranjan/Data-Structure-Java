package Stack;

import java.util.*;

public class ParenthesisChecker {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		while (tc > 0) {
			String str = sc.next();

			if (check(str))
				System.out.println("balanced");
			else
				System.out.println("not balanced");

			tc--;
		}
	}

	public static boolean check(String str) {
		int n = str.length();

		if (n % 2 != 0) {
			return false;
		}

		Stack<Character> s = new Stack<>();

		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);

			if (ch == '(' || ch == '{' || ch == '[') {
				s.push(ch);
			} else if (ch == ')') {
				if (!s.isEmpty() && s.peek() == '(') {
					s.pop();
				} else {
					return false;
				}
			} else if (ch == ']') {
				if (!s.isEmpty() && s.peek() == '[') {
					s.pop();
				} else {
					return false;
				}
			} else if (!s.isEmpty() && ch == '}') {
				if (s.peek() == '{') {
					s.pop();
				} else {
					return false;
				}
			}

		}

		return true;
	}

}
