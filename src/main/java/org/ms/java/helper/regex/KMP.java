package org.ms.java.helper.regex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class KMP {

	public int KMPSearch(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		int counter = 0;

		int lps[] = new int[M];
		int j = 0; // index for pat[]

		computeLPSArray(pat, M, lps);

		int i = 0;
		while ((N - i) >= (M - j) && i < N) {
			if (j < M && pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			} else if (j != 0) {
				j = lps[j - 1];
			} else {
				i++;
			}

			if (j == M) {
				counter++;
				j = lps[j - 1]; // Reset j to avoid missing overlapping occurrences
			}
		}
		return counter;
	}

	public void computeLPSArray(String pat, int M, int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {

				if (len != 0) {
					len = lps[len - 1];

				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

}
