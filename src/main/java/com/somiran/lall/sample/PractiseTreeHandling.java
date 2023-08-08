package com.somiran.lall.sample;

import java.util.LinkedList;
import java.util.Queue;

public class PractiseTreeHandling {


    public static void main(String[] args) {

        PractiseTreeHandling service = new PractiseTreeHandling();


        TreeNode theNode = new TreeNode(111, null, null);

        service.add(theNode, 53);
        service.add(theNode, 5);
        service.add(theNode, 156);
        service.add(theNode, 3);
        service.add(theNode, 13);
        service.add(theNode, 28);
        service.add(theNode, 59);
        service.add(theNode, 71);
        service.add(theNode, 32);
        service.add(theNode, 1);
        service.add(theNode, 189);
        service.add(theNode, 145);
        service.add(theNode, 1);
        service.add(theNode, 156);
        service.add(theNode, 191);
        service.add(theNode, 190);
        service.add(theNode, 195);

        service.debt_printNode(theNode);

    }
    // Create a Binary Tree
    TreeNode add (TreeNode root, int number) {
        if (null == root) {
            root = new TreeNode(number, null, null);
        } else {
            if(number < root.value) {
                root.left = add(root.left, number);
            } else if (number > root.value) {
                root.right = add(root.right, number);
            }
        }
        return root;
    }

    void debt_printNode(TreeNode root) {
        if(null != root) {
            debt_printNode(root.left);
            System.out.println(root.value);
            debt_printNode(root.right);
        }
    }

    // 1. Delete a Node

    TreeNode delete (TreeNode node, int value) {
        if(null == node)
            return null;

        if(value < node.value) {
            node.left = delete (node.left, value);
        } else if(value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if ((null == node.left) && (null == node.right)) {
                return null;
            } else if(null == node.left) {
                return node.right;
            } else if (null == node.right) {
                return node.left;
            } else {
                node.value = leastValue(node.right).value;
                node.right = delete(node.right, value);
            }
        }
        return node;
    }

    TreeNode leastValue(TreeNode node) {
        return (null == node.left)? node: leastValue(node.left);
    }

    // 2. Breath Search

    void breath_search(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(null != root) {
                
        }
 
    }

    
    // 3. LCA- sum of Hopes

    // 4. Forest Island Problem



    
}
