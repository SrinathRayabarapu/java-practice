package com.dsalgo.trees;

import lombok.extern.slf4j.Slf4j;

/**
 * given a binary search tree, find it's max height.
 *
 * Idea: find left and right children heights and compare then return
 * https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class FindMaxMinHeightOfBinaryTreeMain {

    public static void main(String[] args) {

        // binary search tree - but can be any binary tree!
        TreeNode root = new TreeNode(40, "forty");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(60, "sixty");
        root.leftChild.leftChild = new TreeNode(10, "ten");
        root.leftChild.leftChild.leftChild = new TreeNode(5, "five");
        root.leftChild.leftChild.rightChild = new TreeNode(15, "fifteen");
        root.leftChild.rightChild = new TreeNode(30, "thirty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(70, "seventy");

        int height = findMaxHeightRecursive(root);
        log.info("Max height of the Tree : " + height);

        height = findMinHeightRecursive(root);
        log.info("Min height of the Tree : " + height);

    }

    private static int findMaxHeightRecursive(TreeNode root) {

        if (root == null)
            return 0;

        int lHeight = findMaxHeightRecursive(root.leftChild);
        int rHeight = findMaxHeightRecursive(root.rightChild);

        // +1 for root to first child node height
        if (lHeight < rHeight) {
            return rHeight + 1;
        } else {
            return lHeight + 1;
        }
    }

    private static int findMinHeightRecursive(TreeNode root) {

        if (root == null)
            return 0;

        int lHeight = findMinHeightRecursive(root.leftChild);
        int rHeight = findMinHeightRecursive(root.rightChild);

        // +1 for root to first child node height
        if (lHeight ==0 || rHeight == 0) {
            return Math.max(lHeight, rHeight) + 1;
        } else {
            return Math.min(lHeight, rHeight) + 1;
        }
    }

}