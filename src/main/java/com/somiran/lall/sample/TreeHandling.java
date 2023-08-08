package com.somiran.lall.sample;

import java.util.Queue;

import com.google.common.collect.Lists;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeHandling {


    class Metadata {
        int currentValue = 0;
        List<TreeNode> currentPath = Lists.newArrayList(); 
    }

    int max;
    List<TreeNode> maxSumPath = Lists.newArrayList();

    int island = 0;



    public String reverse_string(String word) {
        if(!Strings.isEmpty(word) || word.length() == 1) {

            char[] array = word.toCharArray();
            int size = array.length;
            char temp;

            for(int i=0; i <size/2; i++) {
                temp = array[i];
                array[i] = array[size-1-i];
                array[size-1-i] = temp;
            }
            word = new String(array);
            
        }
        return word;
    }


    public static void main(String[] args) {

        TreeHandling service = new TreeHandling();

        System.out.println("Reversing String Somiran: " + service.reverse_string("Somiran"));
        System.out.println("Reversing String Somi: " + service.reverse_string("Somi"));
        System.out.println("Reversing String S: " + service.reverse_string("S"));


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

        // service.dept_traversal_print(theNode);

        // service.delete(theNode, 156);

        // service.dept_traversal_print(theNode);

        // System.out.println("********Breath Traversal*********");
        // service.breath_traversal_print(theNode);

        System.out.println("********In an effort to get LCA*********");
        TreeNode lca = service.lca(theNode, 145, 195);   
        System.out.println("LCA: " + lca);

        int hopes = service.sumup_hopes(theNode, 145, 195);   
        System.out.println("Sumup-hopes: " + hopes);

        service.maximumSumPath(theNode);
        System.out.println("Maximum Value: " + service.max);
        System.out.println("Maximum Path: " + Arrays.toString(service.maxSumPath.stream().map(obj -> obj.value).toArray()));


        int[][] test_data = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
        };

        System.out.println("No of Island is: " + service.forestIslandProblem(test_data));

    }

    int maximumSumPath(TreeNode node) {

        postOrderIndeptTraversalToFindMaxPath(node);

        return max;

    }


    Metadata postOrderIndeptTraversalToFindMaxPath(TreeNode node) {

        Metadata meta = new Metadata();
        if(null == node) {
            meta.currentValue = 0;
            meta.currentPath = Lists.newArrayList();
            return meta;
        } 
        Metadata meta_left = postOrderIndeptTraversalToFindMaxPath(node.left);
        Metadata meta_right = postOrderIndeptTraversalToFindMaxPath(node.right);
 
        int left = meta_left.currentValue;
        int right= meta_right.currentValue;

        meta.currentValue =  Math.max(left, right) + node.value;
        meta.currentPath = left<right? meta_right.currentPath: meta_left.currentPath;
        meta.currentPath.add(node);

        if(max < left+right+node.value) {
            maxSumPath.addAll(meta_right.currentPath);
            maxSumPath.addAll(meta_left.currentPath);
            max =  left+right+node.value;
        }

        return meta;

    }


    TreeNode lca(TreeNode root, int value1, int value2) {

        if(null == root) {
            return null;
        }

        List<TreeNode> path1 = Lists.newArrayList();
        List<TreeNode> path2 = Lists.newArrayList();

        find(root, value1, path1);
        find(root, value2, path2);

        System.out.println(path1);
        System.out.println(path2);

        TreeNode lca = null;
        for(int i=0; i<path1.size() && i < path2.size(); i++) {
            if(path1.get(i).value != path2.get(i).value) {
                lca = path1.get(i-1);
                break;
            }
        }
        return lca;
    }

    int hopes(TreeNode root, int value1, int value2) {

        if(null == root) {
            return 0;
        }

        List<TreeNode> path1 = Lists.newArrayList();
        List<TreeNode> path2 = Lists.newArrayList();

        find(root, value1, path1);
        find(root, value2, path2);

        System.out.println(path1);
        System.out.println(path2);

        int i = 0;
        for(i=0; i<path1.size() && i < path2.size(); i++) {
            if(path1.get(i).value != path2.get(i).value) {
                break;
            }
        }
        System.out.println(i);
        return (path1.size() -i ) + (path2.size() -i );
    }

    int sumup_hopes(TreeNode root, int value1, int value2) {

        if(null == root) {
            return 0;
        }

        List<TreeNode> path1 = Lists.newArrayList();
        List<TreeNode> path2 = Lists.newArrayList();

        find(root, value1, path1);
        find(root, value2, path2);

        System.out.println(path1);
        System.out.println(path2);

        int i = 0;
        for(i=0; i<path1.size() && i < path2.size(); i++) {
            if(path1.get(i).value != path2.get(i).value) {
                break;
            }
        }

        return path1.stream().skip(i).map(obj -> obj.value).reduce(0, Integer::sum)
        +    path2.stream().skip(i).map(obj -> obj.value).reduce(0, Integer::sum)
        + path1.get(i-1).value;

    }

    TreeNode find(TreeNode root, int value, List<TreeNode> path) {
        if(root == null) {
            return null;
        }
        if(null != path) {
            path.add(root);
        }
        
        if (value < root.value) {
            find(root.left, value, path);
        } else if(value > root.value) {
            find(root.right, value, path);
        }

        return root;
    }

    TreeNode add(TreeNode node, int value) {

        // In Binary Tree we always add leaf nodes.
        if (null == node) {
            return new TreeNode(value, null, null);
        }
        if (value < node.value) {
            node.left = add(node.left, value);
        } else if (value > node.value) {
            node.right = add(node.right, value);
        } else {
            return node;
        }
        return node;
    }

    TreeNode delete(TreeNode node, int value) {

        // Handle situations
        // 1. What to do if the node doesnt exists
        // 2. Got to the node to delete
        // 3.1 If the node is a leaf node- its easy!! Just make the node null.
        // 3.2 if the node has left node empty- assign the right node to the parent
        // node. (return the right node from the recurrsive function)
        // 3.3 if the node has right node empty- assign the left node to the parent
        // node. (return the right left from the recurrsive function)
        // 3.4 If the node has both right and left-
        // 3.4.1 Replace the value of the node with either the smallest value from the
        // right node or max value from the left node.

        if (null == node) {
            return null;
        } else if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // This is the node to delete
            if ((null == node.left) && (null == node.right)) {
                return null;
            } else if (null == node.left) {
                return node.right;
            } else if (null == node.right) {
                return node.left;
            } else {
                // Find the smallest on the right node
                // or the max on the left node.
                node.value = findsmallestRightNodeValue(node.right);
                node.right = delete(node.right, node.value);
            }
        }
        return node;
    }

    int findsmallestRightNodeValue(TreeNode node) {
        return (null == node.left) ? node.value : findsmallestRightNodeValue(node.left);
    }

    void dept_traversal_print(TreeNode node) {
        if (null != node) {
            dept_traversal_print(node.left);
            System.out.println(node.value);
            dept_traversal_print(node.right);
        }
    }

    void breath_traversal_print(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        TreeNode current = null;
        while(!queue.isEmpty()) {
            current = queue.remove();

            if(null != current.left)  {
    ;            queue.add(current.left);
            }
                
            if(null != current.right) {
                queue.add(current.right);
            }

            System.out.println(current.value);
        }
    }

    int forestIslandProblem (int[][] area) {
        if((null == area) || (area.length == 0)) {
            return 0;
        }

        int row = area.length;

        for (int i=0; i <row; i++ ) {
            for(int j=0; j< area[i].length; j++) {
                if(area[i][j] == 1) {
                    System.out.printf ("Element is: %d, row is: %d, column is: %d\n", area[i][j], i, j);
                    island++;
                    area = recurrsivelyFindOneIsland(area, i, j);
                }
            }
        }
        return island;
    }

    int[][] recurrsivelyFindOneIsland (int[][] area, int row, int column) {

        if((row >= area.length) || row<0 || column<0|| (column >= area[row].length))
            return area;
        
        if(area[row][column] != 1) {
            return area;
        }
        if((row > area.length) || (column > area[row].length))
            return area;
        
        area[row][column] = 2;

        recurrsivelyFindOneIsland(area, row-1, column);
        recurrsivelyFindOneIsland(area, row+1, column);
        recurrsivelyFindOneIsland(area, row, column-1);
        recurrsivelyFindOneIsland(area, row, column+1);

        return area;
    }
}