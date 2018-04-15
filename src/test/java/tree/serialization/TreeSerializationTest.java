package tree.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Alexey Merezhin
 */
class TreeSerializationTest {
    private final TreeSerialization serialization = new TreeSerialization();

    @Test
    void testNull() {
        String tt = serialization.serializeTree(null);
        assertNull(serialization.restoreTree(tt));
    }

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(1, null, null);
        String tt = serialization.serializeTree(root);
        assertEquals(serialization.restoreTree(tt), root);
    }

    @Test
    void testTwoNodes() {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        String tt = serialization.serializeTree(root);
        assertEquals(serialization.restoreTree(tt), root);
    }

    @Test
    void testBalanced2Levels() {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        root.right = new TreeNode(3, null, null);
        String tt = serialization.serializeTree(root);
        System.out.println(tt);
        assertEquals(serialization.restoreTree(tt), root);
    }

    @Test
    void testUnBalanced() {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        root.left.right = new TreeNode(3, null, null);
        root.left.right.left = new TreeNode(4, null, null);
        String tt = serialization.serializeTree(root);
        System.out.println(tt);
        assertEquals(serialization.restoreTree(tt), root);
    }
}