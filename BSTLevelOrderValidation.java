/*

💡 Question-3

Given an array of size n. The problem is to check whether the given array can represent the level order traversal of a Binary Search Tree or not.

Examples:

Input1 : arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10}

Output1 : Yes

For the given arr[], the Binary Search Tree is:

            7

         /    \

       4     12

     /  \     /

    3   6  8

   /    /     \

 1    5      10

Input2 : arr[] = {11, 6, 13, 5, 12, 10}

Output2 : No

The given arr[] does not represent the level order traversal of a BST.

*/

package Java_DSA.Trees.Assignment20;

import java.util.LinkedList;
import java.util.Queue;

class BSTLevelOrderValidation {
    public static boolean isValidBSTLevelOrder(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return true;
        }

        int n = levelOrder.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(levelOrder[0]);

        int i = 1;
        while (i < n && !queue.isEmpty()) {
            int current = queue.poll();

            // Find the left child
            if (i < n && levelOrder[i] < current) {
                queue.offer(levelOrder[i]);
                i++;
            }

            // Find the right child
            if (i < n && levelOrder[i] > current) {
                queue.offer(levelOrder[i]);
                i++;
            }

            // Check if there are any elements in the remaining array
            if (i < n && (levelOrder[i] < queue.peek() || levelOrder[i] > current)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] levelOrder1 = { 7, 4, 9, 2, 6, 8, 10 };
        System.out.println("Is valid BST level order traversal? " + isValidBSTLevelOrder(levelOrder1));

        int[] levelOrder2 = { 7, 4, 9, 2, 6, 3, 10 };
        System.out.println("Is valid BST level order traversal? " + isValidBSTLevelOrder(levelOrder2));
    }
}
