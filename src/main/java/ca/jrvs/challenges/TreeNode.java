package main.java.ca.jrvs.challenges;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    public static class Solution {

        public List<Integer> inorderTraversal(TreeNode root){
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        public void helper(TreeNode root, List<Integer> res){
            if (root != null) {
                if (root.left != null){
                    helper(root.left, res);
                }
                res.add(root.val);
                if (root.right != null){
                    helper(root.right, res);
                }
            }
        }
    }
}

