package leetcode;

import java.util.ArrayList;

/*
 This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 word1 and word2 may be the same and they represent two individual words in the list.
 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 Given word1 = ��makes��, word2 = ��coding��, return 1.
 Given word1 = "makes", word2 = "makes", return 3.
 */
public class Q245_ShortestWordDistanceIII {

	public int shortestDistance(String[] words, String word1, String word2) {
		int idx1 = -1;
		int idx2 = -1;

		int dist = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				idx1 = i;
			else if (words[i].equals(word2))
				idx2 = i;
			if (idx1 != -1 && idx2 != -1 && idx1 != idx2)
				dist = Math.min(dist, Math.abs(idx1 - idx2));
			if (word1.equals(word2))
				idx2 = idx1;
		}

		return dist;
	}
}
