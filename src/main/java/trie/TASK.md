# Trie (Prefix Tree)

## Description

A Trie is a tree-like data structure used for efficient retrieval of keys in a dataset of strings.
Each node represents a single character, and paths from root to marked nodes form stored words.

## Use Cases

- Autocomplete / type-ahead suggestions
- Spell checking
- Prefix matching and filtering
- IP routing (longest prefix match)
- Word games (e.g., Boggle solvers)

## Node Structure

Each TrieNode contains:
- `children` - a map (or array) of character to child TrieNode
- `isEndOfWord` - boolean flag marking whether this node completes a valid word

## Complexity

| Operation      | Time     | Space    |
|----------------|----------|----------|
| insert(word)   | O(L)     | O(L)     |
| search(word)   | O(L)     | O(1)     |
| startsWith(prefix) | O(L) | O(1)     |
| wordsWithPrefix(prefix) | O(L + N*M) | O(N*M) |

Where L = length of word/prefix, N = number of matching words, M = average word length.
