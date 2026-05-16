/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        ans.add(root.val);

        List<Integer> leftBoundry = new LinkedList<>();
        List<Integer> leftLeaves = new LinkedList<>();

        if(root.left != null) {
            parseLeft(root.left, true, leftBoundry, leftLeaves);
        }

        List<Integer> rightBoundry = new LinkedList<>();
        List<Integer> rightLeaves = new LinkedList<>();

        if(root.right != null) {
            parseRight(root.right, true, rightBoundry, rightLeaves);
        }

        /*System.out.println(leftBoundry);
        System.out.println(leftLeaves);
        System.out.println(rightBoundry);
        System.out.println(rightLeaves);
        */

        ans.addAll(leftBoundry);
        ans.addAll(leftLeaves);
        ans.addAll(rightLeaves);
        ans.addAll(rightBoundry);

        return ans;
    }

    private void parseRight(TreeNode root, boolean isRightBoundry, List<Integer> rightBoundry,
                List<Integer> rightLeaves) {
        
        if(root.right == null && root.left == null) {
            rightLeaves.addFirst(root.val);
        }

        if(root.right != null) {
            parseRight(root.right, isRightBoundry, rightBoundry, rightLeaves);
        }

        if(root.left != null) {
            if(root.right == null)
                parseRight(root.left, isRightBoundry, rightBoundry, rightLeaves);
            else
                parseRight(root.left, false, rightBoundry, rightLeaves);
        } 

        if(isRightBoundry && (root.right != null || root.left != null))
            rightBoundry.add(root.val);    
    }

    private void parseLeft(TreeNode root, boolean isLeftBoundry, List<Integer> leftBoundry,
                List<Integer> leftLeaves) {

        if(isLeftBoundry && (root.right != null || root.left != null))
            leftBoundry.add(root.val);

        if(root.left != null) {
            parseLeft(root.left, isLeftBoundry, leftBoundry, leftLeaves);
        }

        if(root.right != null) {
            if(root.left == null)
                parseLeft(root.right, isLeftBoundry, leftBoundry, leftLeaves);
            else
                parseLeft(root.right, false, leftBoundry, leftLeaves);
        } 
        
        if(root.right == null && root.left == null) {
            leftLeaves.add(root.val);
        }        
    }

}
