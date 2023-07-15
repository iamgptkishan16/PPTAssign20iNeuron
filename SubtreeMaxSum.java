/*
💡 Question-1

Given a binary tree, your task is to find subtree with maximum sum in tree.

Examples:

Input1 :       

       1

     /   \

   2      3

  / \    / \

4   5  6   7

Output1 : 28

As all the tree elements are positive, the largest subtree sum is equal to sum of all tree elements.

Input2 :

       1

     /    \

  -2      3

  / \    /  \

4   5  -6   2

Output2 : 7

Subtree with largest sum is :

 -2

 / \

4   5

Also, entire tree sum is also 7.

*/

package Java_DSA.Trees.Assignment20;
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

class SubtreeMaxSum {
    private static int maxSum = Integer.MIN_VALUE;
    private static TreeNode maxSumSubtree = null;

    public static int findMaxSubtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        calculateSum(root);

        return maxSum;
    }

    private static int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = calculateSum(node.left);
        int rightSum = calculateSum(node.right);
        int currentSum = node.val + leftSum + rightSum;

        if (currentSum > maxSum) {
            maxSum = currentSum;
            maxSumSubtree = node;
        }

        return currentSum;
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);

        int maxSubtreeSum = findMaxSubtreeSum(root);
        System.out.println("Maximum subtree sum: " + maxSubtreeSum);
        System.out.println("Subtree with maximum sum: " + maxSumSubtree.val);
    }
}
