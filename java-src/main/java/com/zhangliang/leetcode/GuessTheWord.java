package com.zhangliang.leetcode;
/*
This problem is an interactive problem new to the LeetCode platform.

We are given a word list of unique words, each word is 6 letters long, 
and one word in this list is chosen as secret.

You may call master.guess(word) to guess a word.  The guessed word should 
have type string and must be from the original list with 6 lowercase letters.

This function returns an integer type, representing the number of exact 
matches (value and position) of your guess to the secret word.  
Also, if your guess is not in the given wordlist, it will return -1 instead.

For each test case, you have 10 guesses to guess the word. At the end of any 
number of calls, if you have made 10 or less calls to master.guess and at least 
one of these guesses was the secret, you pass the testcase.

Besides the example test case below, there will be 5 additional test cases, each 
with 100 words in the word list.  The letters of each word in those testcases 
were chosen independently at random from 'a' to 'z', such that every word in 
the given word lists is unique.

Example 1:
Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]

Explanation:

master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
master.guess("acckzz") returns 6, because "acckzz" is secret and has all 
6 matches.
master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
master.guess("abcczz") returns 4, because "abcczz" has 4 matches.

We made 5 calls to master.guess and one of them was the secret, so we 
pass the test case.
Note:  Any solutions that attempt to circumvent the judge will result in 
disqualification.
*/

import java.util.*;

public class GuessTheWord {
    static interface Master {
        abstract public int guess(String word);
    }

    private int getNextGuessing(int[][] dists, List<Integer> choices) {
        int[] counts = new int[7];
        int target = choices.get(0);
        int minMaxSameCount = choices.size();
        for (Integer choice : choices) {
            Arrays.fill(counts, 0);
            for (Integer other : choices) {
                if (choice != other) {
                    counts[dists[choice][other]]++;
                }
            }
            int maxSameCount = 0;
            for (int count : counts) {
                maxSameCount = Math.max(maxSameCount, count);
            }
            if (minMaxSameCount > maxSameCount) {
                target = choice;
                minMaxSameCount = maxSameCount;
            }
        }
        return target;
    }

    private int getWordDist(String a, String b) {
        int value = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                value++;
            }
        }
        return value;
    }

    public void findSecretWord(String[] wordlist, Master master) {
        // Build the distance graph.
        int[][] dists = new int[wordlist.length][wordlist.length];
        for (int i = 0; i < wordlist.length; i++) {
            for (int j = i + 1; j < wordlist.length; j++) {
                dists[i][j] = getWordDist(wordlist[i], wordlist[j]);
                dists[j][i] = dists[i][j];
            }
        }

        // Init the choices.
        List<Integer> choices = new ArrayList<>();
        for (int i = 0; i < wordlist.length; i++) {
            choices.add(i);
        }
        Set<Integer> visited = new HashSet<>();

        // Begin guess.
        for (int i = 0; i < 10 && !choices.isEmpty(); i++) {
            int target = getNextGuessing(dists, choices);
            visited.add(target);
            int dist = master.guess(wordlist[target]);
            // System.out.println("Guessing: " + wordlist[target] + ", dist: " + dist);
            if (dist == 6) {
                return;
            }
            List<Integer> nextChoices = new ArrayList<>();
            for (int j = 0; j < choices.size(); j++) {
                int choice = choices.get(j);
                if (dists[choice][target] == dist && !visited.contains(choice)) {
                    nextChoices.add(choice);
                }
            }
            choices = nextChoices;
        }
    }
}
