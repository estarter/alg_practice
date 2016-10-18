package tree.serialization;

import java.util.*;

/**
 * @author Alexey Merezhin
 */
public class TreeSerialization {

    public String serializeTree(TreeNode root){
        if (root == null) return "";

        StringBuffer result = new StringBuffer();
        serializeTree(result, root);

        return result.toString();
    }

    void serializeTree(StringBuffer result, TreeNode node) {
        if (node == null) {
            result.append("#,");
        } else {
            result.append(node.data + ",");
            serializeTree(result, node.left);
            serializeTree(result, node.right);
        }
    }


    public TreeNode restoreTree(String str){
        StringTokenizer tokens = new StringTokenizer(str, ",");

        TreeNode root = restoreTree(tokens);
        return root;
    }

    TreeNode restoreTree(StringTokenizer tokens) {
        if (!tokens.hasMoreElements()) return null;
        String value = tokens.nextToken();
        if (value.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(value), null, null);
        node.left = restoreTree(tokens);
        node.right = restoreTree(tokens);
        return node;
    }

}
