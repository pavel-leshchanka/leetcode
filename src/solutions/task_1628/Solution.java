package solutions.task_1628;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1268. Search Suggestions System
 * You are given an array of strings products and a string searchWord.
 * Design a system that suggests at most three product names from products after each character of searchWord is typed.
 * Suggested products should have common prefix with searchWord. If there are more than three products with a common
 * prefix return the three lexicographically minimums products.
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        List<List<String>> objects = new ArrayList<>();
        for (String product : products) {
            trie.insert(product);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);
            objects.add(trie.startsWith(substring));
        }
        return objects;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                    node.children[index].strings.add(word);
                } else {
                    node.children[index].strings.add(word);
                }
                node = node.children[index];
            }
        }

        public List<String> startsWith(String prefix) {
            TrieNode node = root;
            List<String> objects = new ArrayList<>();
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return objects;
                }
                node = node.children[index];
            }
            int i = Math.min(node.strings.size(), 3);
            return node.strings.subList(0, i);
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<String> strings = new ArrayList<>();

            TrieNode() {
                for (int i = 0; i < 26; i++) {
                    children[i] = null;
                }
            }
        }
    }
}