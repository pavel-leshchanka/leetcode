package solutions.task_208;

/**
 * 208. Implement Trie (Prefix Tree)
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
 * in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 * and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has
 * the prefix prefix, and false otherwise.
 */
class Trie {
    Node node = new Node();

    public Trie() {
    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        Node thisNode = node;
        Node[] keys = thisNode.keys;
        for (int i = 0; i < charArray.length - 1; i++) {
            int i1 = charArray[i] - 'a';
            Node key = keys[i1];
            if (key != null) {
                thisNode = key;
                keys = thisNode.keys;
            } else {
                keys[i1] = new Node();
                thisNode = keys[i1];
                keys = thisNode.keys;
            }
        }
        int i1 = charArray[charArray.length - 1] - 'a';
        Node key = keys[i1];
        if (key != null) {
            key.isWord = true;
        } else {
            keys[i1] = new Node();
            keys[i1].isWord = true;
        }
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Node thisNode = node;
        Node[] keys = thisNode.keys;
        for (int i = 0; i < charArray.length - 1; i++) {
            int i1 = charArray[i] - 'a';
            Node key = keys[i1];
            if (key != null) {
                thisNode = key;
                keys = thisNode.keys;
            } else {
                return false;
            }
        }
        int i1 = charArray[charArray.length - 1] - 'a';
        Node key = keys[i1];
        if (key != null) {
            return key.isWord;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        Node thisNode = node;
        Node[] keys = thisNode.keys;
        for (int i = 0; i < charArray.length - 1; i++) {
            int i1 = charArray[i] - 'a';
            Node key = keys[i1];
            if (key != null) {
                thisNode = key;
                keys = thisNode.keys;
            } else {
                return false;
            }
        }
        int i1 = charArray[charArray.length - 1] - 'a';
        Node key = keys[i1];
        return key != null;
    }

    static class Node {
        Node[] keys = new Node[26];
        boolean isWord = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */