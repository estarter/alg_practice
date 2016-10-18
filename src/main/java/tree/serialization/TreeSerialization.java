package tree.serialization;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Alexey Merezhin
 */
public class TreeSerialization {

    public String serializeTree(TreeNode root){
        if (root == null) return "";

        StringBuffer result = new StringBuffer();
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queueChild = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node == null) {
                result.append(",");
            } else {
                result.append(node.data + ",");
                queueChild.addLast(node.left);
                queueChild.addLast(node.right);
            }
            if (queue.isEmpty()) {
                queue = queueChild;
                queueChild = new LinkedList<>();
            }
        }
        return result.toString();
    }

    void serializeTree(StringBuffer result, TreeNode node) {
        if (node == null) return;
        result.append(node.data + ",");
        if (node.left != null) serializeTree(result, node.left);
        else result.append(",");
        if (node.right != null) serializeTree(result, node.right);
        else result.append(",");
    }


    public TreeNode restoreTree(String str){
        if (str.equals("")) return null;

        String[] datas = str.split(",");
        TreeNode root = new TreeNode(0, null, null);
        restoreTree(root, 0, datas);
        return root;
    }

    void restoreTree(TreeNode root, int pos, String [] datas) {
        root.data = Integer.parseInt(datas[pos]);
        int childPos = pos * 2+1;
        if (childPos < datas.length) {
            if (!"".equals(datas[childPos])) {
                root.left = new TreeNode(0, null, null);
                restoreTree(root.left, childPos, datas);
            }
        }
        childPos += 1;
        if (childPos < datas.length) {
            if (!"".equals(datas[childPos])) {
                root.right = new TreeNode(0, null, null);
                restoreTree(root.right, childPos, datas);
            }
        }
    }

}
