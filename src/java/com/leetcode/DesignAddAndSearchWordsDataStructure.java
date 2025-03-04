package com.leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150

public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }


    static class WordDictionary {

        private static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isEndOfWord = false;
        }

        private final TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        public boolean search(String word) {
            return searchInNode(word, 0, root);
        }

        private boolean searchInNode(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node.isEndOfWord;
            }

            char c = word.charAt(index);
            if (c == '.') {
                for (TrieNode child : node.children.values()) {
                    if (searchInNode(word, index + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                TrieNode nextNode = node.children.get(c);
                return nextNode != null && searchInNode(word, index + 1, nextNode);
            }
        }
    }

}
