package LinkedList;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedSubPath {
    public boolean isSubPath(ListNode head, TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        findHead(root, head.val, treeNodes);
        for (TreeNode treeNode : treeNodes) {
            boolean isSubPath = findListNodePath(head, treeNode);
            if(isSubPath) {
                return true;
            }
        }
        return false;
    }

    private boolean findListNodePath(ListNode head, TreeNode treeNode) {
        if (head == null) {
            return true;
        }
        if (head.val != treeNode.val) {
            return false;
        }
        return findListNodePath(head.next, treeNode.left) || findListNodePath(head.next, treeNode.right);
    }

    private void findHead(TreeNode root, int val, List<TreeNode> treeNodes) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            treeNodes.add(root);
        }
        if (root.left != null) {
            findHead(root.left, val, treeNodes);
        }
        if (root.right != null) {
            findHead(root.right, val, treeNodes);
        }
    }
}
