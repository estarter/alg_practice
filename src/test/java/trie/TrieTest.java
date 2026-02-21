package trie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class TrieTest {
    private final Trie trie = new Trie();

    @Test
    void searchEmptyTrie() {
        assertFalse(trie.search("hello"));
    }

    @Test
    void insertAndSearch() {
        trie.insert("hello");
        assertTrue(trie.search("hello"));
        assertFalse(trie.search("hell"));
        assertFalse(trie.search("helloo"));
    }

    @Test
    void startsWith() {
        trie.insert("hello");
        assertTrue(trie.startsWith("hel"));
        assertTrue(trie.startsWith("hello"));
        assertFalse(trie.startsWith("helloo"));
        assertFalse(trie.startsWith("abc"));
    }

    @Test
    void insertOverlappingWords() {
        trie.insert("app");
        trie.insert("apple");
        assertTrue(trie.search("app"));
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("ap"));
    }

    @Test
    void wordsWithPrefix() {
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("dog");

        List<String> result = trie.wordsWithPrefix("car");
        Collections.sort(result);
        assertEquals(Arrays.asList("car", "card", "care", "careful"), result);
    }

    @Test
    void wordsWithPrefixNoMatch() {
        trie.insert("hello");
        List<String> result = trie.wordsWithPrefix("xyz");
        assertTrue(result.isEmpty());
    }

    @Test
    void wordsWithPrefixExactWord() {
        trie.insert("test");
        List<String> result = trie.wordsWithPrefix("test");
        assertEquals(Collections.singletonList("test"), result);
    }

    @Test
    void emptyStringInsertAndSearch() {
        trie.insert("");
        assertTrue(trie.search(""));
        assertTrue(trie.startsWith(""));
    }

    @Test
    void startsWithEmptyPrefix() {
        trie.insert("a");
        assertTrue(trie.startsWith(""));
    }

    @Test
    void duplicateInsert() {
        trie.insert("hello");
        trie.insert("hello");
        assertTrue(trie.search("hello"));
    }
}
