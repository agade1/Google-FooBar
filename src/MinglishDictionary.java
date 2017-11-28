import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution by : Amol Gade
 * <p>
 * Note: for education purpose only
 * <p>
 * Problem statement:
 * Minglish lesson
 * ===============
 * <p>
 * Welcome to the lab, minion. Henceforth you shall do the bidding of Professor Boolean. Some say he's mad, trying to develop a zombie serum and all... but we think he's brilliant!
 * <p>
 * First things first - Minions don't speak English, we speak Minglish. Use the Minglish dictionary to learn! The first thing you'll learn is how to use the dictionary.
 * <p>
 * Open the dictionary. Read the page numbers, figure out which pages come before others. You recognize the same letters used in English, but the order of letters is completely different in Minglish than English (a < b < c < ...).
 * <p>
 * Given a sorted list of dictionary words (you know they are sorted because you can read the page numbers), can you find the alphabetical order of the Minglish alphabet? For example, if the words were ["z", "yx", "yz"] the alphabetical order would be "xzy," which means x < z < y. The first two words tell you that z < y, and the last two words tell you that x < z.
 * <p>
 * Write a function answer(words) which, given a list of words sorted alphabetically in the Minglish alphabet, outputs a string that contains each letter present in the list of words exactly once; the order of the letters in the output must follow the order of letters in the Minglish alphabet.
 * <p>
 * The list will contain at least 1 and no more than 50 words, and each word will consist of at least 1 and no more than 50 lowercase letters [a-z]. It is guaranteed that a total ordering can be developed from the input provided (i.e. given any two distinct letters, you can tell which is greater), and so the answer will exist and be unique.
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (string list) words = ["y", "z", "xy"]
 * Output:
 * (string) "yzx"
 * <p>
 * Inputs:
 * (string list) words = ["ba", "ab", "cb"]
 * Output:
 * (string) "bac"
 */

public class MinglishDictionary {

    public static void main(String args[]) {

        String[] words = {"bac", "ab", "cbx", "cdyh", "cdy", "caq", "f", "g"};

        int index = 0;
        String char1 = "", char2 = "", nodes = "";
        ArrayList<String> wordlist = new ArrayList<String>();
        //object
        MinglishDictionary instance = new MinglishDictionary();

        for (int i = 0; i < words.length - 1; i++) {
            wordlist = instance.get_order(words, i, wordlist, index, instance);
        }

        for (int i = 0; i < wordlist.size(); i++) {
            char1 = "";
            char2 = "";
            char1 += wordlist.get(i).charAt(0);
            if (!nodes.contains(char1)) {
                nodes += char1;
            }

            char2 += wordlist.get(i).charAt(1);
            if (!nodes.contains(char2)) {
                nodes += char2;
            }
        }

        int n = nodes.length();
        List<Integer>[] list = new List[n];
        nodes = "";
        String sorted_list = "";
        for (int i = 0; i < wordlist.size(); i++) {
            char1 = "";
            char2 = "";
            char1 += wordlist.get(i).charAt(0);
            if (nodes.contains(char1)) {
            } else {
                nodes += char1;
                list[nodes.length() - 1] = new ArrayList<Integer>();
            }

            char2 += wordlist.get(i).charAt(1);
            if (nodes.contains(char2)) {
            } else {
                nodes += char2;
                list[nodes.length() - 1] = new ArrayList<Integer>();
            }

            list[nodes.indexOf(char1)].add(nodes.indexOf(char2));
        }
        System.out.println("\nnodes:" + nodes);

        List<Integer> res = topologicalSort(list);
        for (int i = 0; i < nodes.length(); i++) {
            sorted_list += nodes.charAt(res.get(i));

        }
        System.out.println("order is==>" + sorted_list);

        //return sorted_list;
    }


    public ArrayList<String> get_order(String[] words, int i, ArrayList<String> wordlist, int index, MinglishDictionary instance) {

        String str1, str2, temp = "";
        char char1, char2;
        int index1 = index;
        str1 = words[i];
        str2 = words[i + 1];
        if (index1 < str1.length() && index1 < str2.length()) {
            char1 = str1.charAt(index1);
            char2 = str2.charAt(index1);

            if (char1 == char2) {
                index1++;
                wordlist = instance.get_order(words, i, wordlist, index1, instance);
            }
            if (char1 != char2) {
                temp += char1;
                temp += char2;
                wordlist.add(temp);
                temp = "";
            }
        }
        return wordlist;
    }


    static void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res, int u) {
        used[u] = true;
        for (int v : graph[u])
            if (!used[v])
                dfs(graph, used, res, v);
        res.add(u);
    }

    public static List<Integer> topologicalSort(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
            if (!used[i])
                dfs(graph, used, res, i);
        Collections.reverse(res);
        return res;
    }
}