/*
 * Copyright 2021 Synopsys Inc. All rights reserved.
 * This file is confidential material. Unauthorized distribution prohibited.
 */
package Chapter14;

/**
 * No.208 实现前缀树
 *
 * 其实就是字典树，用于检索字符串数据集中的键，比如自动补全，拼写检查，打字预测等等
 */
public class Trie {
  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }


  // Insert a word into the trie.
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (!node.containKey(ch)) {
        node.put(ch, new TrieNode());
      }
      node = node.get(ch);
    }
    node.setEnd();
  }

  public TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (node.containKey(ch)) {
        node = node.get(ch);
      } else {
        return null;
      }
    }
    return node;
  }
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  public boolean startWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }
}

class TrieNode {
  // R links to node children
  private TrieNode[] links;

  private final int R = 26;

  private boolean isEnd;

  public TrieNode() {
    links = new TrieNode[R];
  }

  public boolean containKey(char ch) {
    return links[ch - 'a'] != null;
  }

  public TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  public void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }
  public void setEnd() {
    isEnd = true;
  }
  public boolean isEnd() {
    return isEnd;
  }
}
