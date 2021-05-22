package com.dsalgo.trees;

/**
 * Given a binary tree and a sum, return true if there is a path from the root down to a leaf, such that
 * adding up all the values along the path equals the given sum.<br>
 * <p>
 *
 * idea: subtract the node value from the sum when recurring down, and check to see if the sum is 0 when
 * you run out of tree.
 *
 * @author Srinath.Rayabarapu
 */
public class BinaryTreeLeafToPathSumMain {

    static TreeNode root;

    public static void main(String[] args) {

        BinaryTreeLeafToPathSumMain pathDemo = new BinaryTreeLeafToPathSumMain();
        pathDemo.root = new TreeNode(15);
        pathDemo.root.leftChild = new TreeNode(6);
        pathDemo.root.rightChild = new TreeNode(17);

        boolean hasPathtoLeaf = hasPathFromRootToLeaf(root, 21);
        System.out.println("Has path - " + hasPathtoLeaf);

        TreeNode root = new TreeNode(10, "ten");
        root.leftChild = new TreeNode(20, "twenty");
        root.rightChild = new TreeNode(30, "thirty");
        root.leftChild.leftChild = new TreeNode(70, "seventy");
        root.leftChild.rightChild = new TreeNode(60, "sixty");
        root.rightChild.leftChild = new TreeNode(50, "fifty");
        root.rightChild.rightChild = new TreeNode(40, "forty");

        findAllPathsFromRootToLeaf(root, 90);

    }

    private static void findAllPathsFromRootToLeaf(TreeNode root, int sum) {
        // TODO -
    }

    /**
     * returns true if there is a path exists from root to leaf node which adds up to given sum
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathFromRootToLeaf(TreeNode root, int sum) {

        if (root == null) {
            return (sum == 0);
        }

        int remainingSum = sum - root.data;

        // sum at root value is 0 and it's a leaf since both left and child are NULL
        if (remainingSum == 0 && root.leftChild == null && root.rightChild == null) {
            return true;
        }

        //look for left root recursively if it's present
        boolean left = false;
        if (root.leftChild != null)
            left = hasPathFromRootToLeaf(root.leftChild, remainingSum);

        //look for right root recursively if it's present
        boolean right = false;
        if (root.leftChild != null)
            right = hasPathFromRootToLeaf(root.rightChild, remainingSum);

        //if either of the one has path then return true
        return left || right;
    }

}