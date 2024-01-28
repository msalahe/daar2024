package org.ms.java.helper.regex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 *
 * @author @ALIREZA_KAY
 */

@Component
public class RegexToDfa {

	private static Set<Integer>[] followPos;
	private static Node root;
	private static Set<State> DStates;

	private static Set<String> input; // set of characters is used in input regex

	/**
	 * a number is assigned to each characters (even duplicate ones)
	 *
	 * @param symbNum is a hash map has a key which mentions the number and has a
	 *                value which mentions the corresponding character or sometimes
	 *                a string for characters is followed up by backslash like "\*"
	 */
	private static HashMap<Integer, String> symbNum;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String str = getStr(in);

		str = cleanText(str);

		String[] words = explodeWithSpace(str);
		String regex = getRegex(in);

		for (String book : words) {
			initialize(book,regex);

		}

	}

	public static void initialize(String str,String regex) {
		Scanner in = new Scanner(System.in);
		// allocating
		DStates = new HashSet<>();
		input = new HashSet<String>();

		System.out.println(regex);
		getSymbols(regex);

		/**
		 * giving the regex to SyntaxTree class constructor and creating the syntax tree
		 * of the regular expression in it
		 */
		SyntaxTree st = new SyntaxTree(regex);
		root = st.getRoot(); // root of the syntax tree
		followPos = st.getFollowPos(); // the followpos of the syntax tree

		/**
		 * creating the DFA using the syntax tree were created upside and returning the
		 * start state of the resulted DFA
		 */
		State q0 = createDFA();
		DfaTraversal dfat = new DfaTraversal(q0, input);

		// Display the results
		System.out.println("Cleaned Text: " + str);
		System.out.println("Exploded Text:");
		boolean acc = false;
		for (char c : str.toCharArray()) {
			if (dfat.setCharacter(c)) {
				acc = dfat.traverse();
			} else {

			}
		}
		if (acc) {
			System.out.println((char) 27 + "[32m" + "this string is acceptable by the regex!" + str);
		} else {
			System.out.println((char) 27 + "[31m" + "this string is not acceptable by the regex!" + str);
		}

		in.close();
	}

	public void searchRegex(String regex, String book) {
		Scanner in = new Scanner(System.in);
		// allocating
		DStates = new HashSet<>();
		input = new HashSet<String>();

		System.out.println(regex);
		getSymbols(regex);

		/**
		 * giving the regex to SyntaxTree class constructor and creating the syntax tree
		 * of the regular expression in it
		 */
		SyntaxTree st = new SyntaxTree(regex);
		root = st.getRoot(); // root of the syntax tree
		followPos = st.getFollowPos(); // the followpos of the syntax tree

		/**
		 * creating the DFA using the syntax tree were created upside and returning the
		 * start state of the resulted DFA
		 */
		State q0 = createDFA();
		DfaTraversal dfat = new DfaTraversal(q0, input);

		String str = book;

		// Explode the cleaned text into an array using spaces as delimiters

		// Display the results
		System.out.println("Cleaned Text: " + str);
		System.out.println("Exploded Text:");
		boolean acc = false;
		for (char c : str.toCharArray()) {
			if (dfat.setCharacter(c)) {
				acc = dfat.traverse();

			} else {

			}
		}
		if (acc) {
			System.out.println((char) 27 + "[32m" + "this string is acceptable by the regex!" + str);
		} else {
			System.out.println((char) 27 + "[31m" + "this string is not acceptable by the regex!" + str);
		}

		in.close();

	}

	private static String cleanText(String text) {
		// Replace double spaces with a single space
		return text.replaceAll("\\s+", " ");
	}

	private static String[] explodeWithSpace(String text) {
		// Split the text into an array using spaces as delimiters
		return text.split("\\s");
	}

	private static String getRegex(Scanner in) {
		System.out.print("Enter a regex: ");
		String regex = in.nextLine();
		return regex + "#";
	}

	private static void getSymbols(String regex) {
		/**
		 * op is a set of characters have operational meaning for example '*' could be a
		 * closure operator
		 */
		Set<Character> op = new HashSet<>();
		Character[] ch = { '(', ')', '*', '|', '&', '.', '\\', '[', ']', '+' };
		op.addAll(Arrays.asList(ch));

		input = new HashSet<>();
		symbNum = new HashMap<>();
		int num = 1;
		for (int i = 0; i < regex.length(); i++) {
			char charAt = regex.charAt(i);

			/**
			 * if a character which is also an operator, is followed up by backslash ('\'),
			 * then we should consider it as a normal character and not an operator
			 */
			if (op.contains(charAt)) {
				if (i - 1 >= 0 && regex.charAt(i - 1) == '\\') {
					input.add("\\" + charAt);
					symbNum.put(num++, "\\" + charAt);
				}
			} else {
				input.add("" + charAt);
				symbNum.put(num++, "" + charAt);
			}
		}
	}

	private static State createDFA() {
		int id = 0;
		Set<Integer> firstpos_n0 = root.getFirstPos();

		State q0 = new State(id++);
		q0.addAllToName(firstpos_n0);
		if (q0.getName().contains(followPos.length)) {
			q0.setAccept();
		}
		DStates.clear();
		DStates.add(q0);

		while (true) {
			boolean exit = true;
			State s = null;
			for (State state : DStates) {
				if (!state.getIsMarked()) {
					exit = false;
					s = state;
				}
			}
			if (exit) {
				break;
			}

			if (s.getIsMarked()) {
				continue;
			}
			s.setIsMarked(true); // mark the state
			Set<Integer> name = s.getName();
			for (String a : input) {
				Set<Integer> U = new HashSet<>();
				for (int p : name) {
					if (symbNum.get(p).equals(a)) {
						U.addAll(followPos[p - 1]);
					}
				}
				boolean flag = false;
				State tmp = null;
				for (State state : DStates) {
					if (state.getName().equals(U)) {
						tmp = state;
						flag = true;
						break;
					}
				}
				if (!flag) {
					State q = new State(id++);
					q.addAllToName(U);
					if (U.contains(followPos.length)) {
						q.setAccept();
					}
					DStates.add(q);
					tmp = q;
				}
				s.addMove(a, tmp);
			}
		}

		return q0;
	}

	private static String getStr(Scanner in) {
		System.out.print("Enter a string: ");
		String str;
		str = in.nextLine();
		return str;
	}

}
