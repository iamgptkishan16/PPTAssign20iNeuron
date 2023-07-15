/*
💡 Question-2

Construct the BST (Binary Search Tree) from its given level order traversal.

Example:

Input: arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}

Output: BST:

            7

         /    \

       4     12

     /  \     /

    3   6  8

   /    /     \

 1    5      10

*/


package Java_DSA.Trees.Assignment20;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BSTConstruction {
    public static TreeNode constructBST(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (index < levelOrder.length) {
            TreeNode current = queue.poll();

            if (index < levelOrder.length) {
                current.left = new TreeNode(levelOrder[index]);
                queue.offer(current.left);
                index++;
            }

            if (index < levelOrder.length) {
                current.right = new TreeNode(levelOrder[index]);
                queue.offer(current.right);
                index++;
            }
        }

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int[] levelOrder = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

        TreeNode root = constructBST(levelOrder);
        System.out.print("Inorder traversal of the constructed BST: ");
        inorderTraversal(root);
    }
}
