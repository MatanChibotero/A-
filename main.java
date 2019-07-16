package ass1_3;

import java.util.LinkedList;
import java.util.Scanner;
public class main {

	static void CheckDiff(String s, String s2) {
		int k = 0, m = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				k = i;
				break;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == '0') {
				m = i;
				break;
			}
		}
		int cost = 1;
		if (Math.abs(m - k) == 3)
			cost = 2;
		System.out.println("Switching '" + s.charAt(m) + "' in index " + k + " and blank in index " + m);
		System.out.println("Cost of this action is: " + cost);

	}

	public static void main(String[] args) {
		System.out.println("Enter string with 7 characters for example:BBB0WWW");
		Scanner s=new Scanner(System.in);
		String Word=s.nextLine();
		LinkedList<Node> frontier = new LinkedList<Node>();
		Node Head = new Node(Word, 0, null);
		frontier.add(Head);
		Node tempMin = null;
		int iter = 0;
		LinkedList<String> MemoryString = new LinkedList<String>();
		MemoryString.add(Head.struct);
		while (true) {
			tempMin = frontier.getFirst();
			for (int i = 0; i < frontier.size(); i++) {
				if (frontier.get(i).F < tempMin.F)
					tempMin = frontier.get(i);
			}
			if (tempMin.p != null) {
				System.out.println(iter + "." + tempMin.p.struct);
				CheckDiff(tempMin.struct, tempMin.p.struct);
				System.out.println("Total cost so far is: " + tempMin.G);
				iter++;
			}
			if (tempMin.H == 0) {
				break;
			}
			tempMin.SpreadChild(MemoryString);
			for (int i = 0; i < tempMin.child.size(); i++) {
				frontier.add(tempMin.child.get(i));
				MemoryString.add(tempMin.child.get(i).struct);
			}
			frontier.remove(tempMin);
		}
		System.out.println();
		System.out.print("Solution found, lowest cost possible is: ");
		System.out.println(tempMin.G);
		s.close();
		
	}
}
