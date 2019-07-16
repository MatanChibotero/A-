package ass1_3;

import java.util.LinkedList;

public class Node {
	String struct;
	Node p;
	int G;
	int H;
	int F;
	LinkedList<Node> child = new LinkedList<Node>();

	Node(String s, int path, Node p_) {
		struct = s;
		G = path;
		H = heuristic();
		F = G + H;
		p = p_;
	}

	int heuristic() {
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < struct.length(); i++) {
			flag = false;
			if (struct.charAt(i) == 'W') {
				for (int j = i; j >= 0; j--) {
					if (struct.charAt(j) == 'B') {
						flag = true;
					}
				}
			}
			if (flag == true)
				sum++;
		}
		return sum;
	}

	boolean checkString(LinkedList<String> MemoryString, String s) {
		for (int i = 0; i < MemoryString.size(); i++) {
			if (MemoryString.get(i).equals(s))
				return false;
		}
		return true;
	}

	void SpreadChild(LinkedList<String> MemoryString) {
		int j = 0;
		for (int i = 0; i < struct.length(); i++) {
			if (struct.charAt(i) == '0') {
				j = i;
				break;
			}
		}
		for (int i = j + 1; i <= j + 3; i++) {
			if (i < struct.length()) {
				if (Math.abs(i - j) == 3) {
					if (checkString(MemoryString, swap(struct, j, i)))
						child.add(new Node(swap(struct, j, i), G + 2, this));
				} else {
					if (checkString(MemoryString, swap(struct, j, i)))
						child.add(new Node(swap(struct, j, i), G + 1, this));
				}

			}
		}
		for (int i = j - 1; i >= j - 3; i--) {
			if (i >= 0) {
				if (Math.abs(i - j) == 3) {
					if (checkString(MemoryString, swap(struct, j, i)))
						child.add(new Node(swap(struct, j, i), G + 2, this));
				} else {
					if (checkString(MemoryString, swap(struct, j, i)))
						child.add(new Node(swap(struct, j, i), G + 1, this));
				}
			}
		}

	}

	String swap(String s, int i, int j) {
		char[] newS = s.toCharArray();
		char temp = newS[i];
		newS[i] = newS[j];
		newS[j] = temp;
		return new String(newS);
	}

}
