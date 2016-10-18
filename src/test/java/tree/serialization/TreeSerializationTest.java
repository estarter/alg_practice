package tree.serialization;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexey Merezhin
 */
public class TreeSerializationTest {
    TreeSerialization serialization = new TreeSerialization();

    @Test
    public void testNull() throws Exception {
        String tt = serialization.serializeTree(null);
        assertNull(serialization.restoreTree(tt));
    }

    @Test
    public void testSingleNode() throws Exception {
        TreeNode root = new TreeNode(1, null, null);
        String tt = serialization.serializeTree(root);
        assertEquals(serialization.restoreTree(tt), root);
    }

    @Test
    public void testTwoNodes() throws Exception {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        String tt = serialization.serializeTree(root);
        assertEquals(serialization.restoreTree(tt), root);
    }

    @Test
    public void testBalanced2Levels() throws Exception {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        root.right = new TreeNode(3, null, null);
        String tt = serialization.serializeTree(root);
        System.out.println(tt);
        assertEquals(serialization.restoreTree(tt), root);
    }

    @Test
    public void testUnBalanced() throws Exception {
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, null, null);
        root.left.right = new TreeNode(3, null, null);
        root.left.right.left = new TreeNode(4, null, null);
        String tt = serialization.serializeTree(root);
        System.out.println(tt);
        assertEquals(serialization.restoreTree(tt), root);
    }
}