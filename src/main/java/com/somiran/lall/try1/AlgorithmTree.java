package com.somiran.lall.try1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.Lists;
import com.somiran.lall.sample.TreeNode;

public class AlgorithmTree {



    public static void main(String[] args) {

        AlgorithmTree alg = new AlgorithmTree();
        alg.test_treehandling();
    }


    void test_treehandling() {
        TreeNode node = makeTreeNode();
        print(node);

        List<TreeNode> path = Lists.newArrayList();
        find(node, 189, path);

        System.out.println("\nPrinting our priced- ");
        path.stream().forEach(System.out::println);

        delete(node, 156);
        System.out.println("\nPrinting after delete - ");
        print(node);

        System.out.println("\nPrinting debt Traversal- ");
        dept_traversal_print(node);

        System.out.println("\nPrinting breath Traversal- ");
        breath_traversal_print(node);
    }

    // InOrder   -> Left, Root, Right
    // PreOrder  -> Root, Left, Right
    // PostOrder -> Left, Right, Root

    int sum_Hopes(TreeNode node, int value1, int value2) {

        List<TreeNode> path1 = Lists.newArrayList();
        List<TreeNode> path2 = Lists.newArrayList();
        find(node, value1, path1);
        find(node, value2, path2);

        int i=0;
        for(i = 0 ; i < path1.size() && i <path2.size(); i++) {
            if(path1.get(i).value != path2.get(i).value) {
                break;
            }
        }

        return path1.stream().skip(i).map(mapper-> mapper.value).reduce(0, Integer::sum)
            + path2.stream().skip(i).map(mapper-> mapper.value).reduce(0, Integer::sum)
            + path1.get(i).value;
    }

    void dept_traversal_print (TreeNode node) {
        if(null != node) {
            dept_traversal_print(node.left);
            System.out.print(node.value + ",");
            dept_traversal_print(node.right);
        }
    }

    void breath_traversal_print (TreeNode node) {

        if(null == node) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        TreeNode current = null;
        while(!queue.isEmpty()) {
            current = queue.remove();
            System.out.print(current.value + ",");

            if(null != current.left) {
                queue.add(current.left);
            }
            if(null != current.right) {
                queue.add(current.right);
            }
        }
    }





    TreeNode add(TreeNode node, int value) {
        if(null == node) {
            node = new TreeNode(value, null, null);
        } else {
            if(value < node.value) {
                node.left = add(node.left, value);
            } else if (value > node.value){
                node.right = add(node.right, value);
            } else {
            }
        }
        return node;
    }

    void print(TreeNode root) {
        if(null == root) {
            System.out.println("Nothing to print");
        } else {
            if(null != root.left) {
                print(root.left);
            }
            System.out.print(root.value + ",");
            if(null != root.right) {
                print(root.right);
            }
        }
    }


    void find(TreeNode node, int value, List<TreeNode> path) {
        if(null == node) {
            return;
        } else {
            path.add(node);
            if(value == node.value) {
                return;
            } else if(value <node.value) {
                find(node.left, value, path);
            } else if(value > node.value) {
                find(node.right, value, path);
            }
        }
    }




    void delete(TreeNode node, int value) {
        if(null == node) {
            return;
        } else {
            if(value == node.value) {
                // Implement the delete
                if(node.left == null && node.right == null) {
                    node = null;
                } else if (node.left == null) {
                    node = node.right;
                } else if(node.right == null) {
                    node = node.left;
                } else {
                    // Find the shortest number from the right or the highest nuber from the left
                    node.value = findShortestNumber(node.right);
                    delete(node.right, node.value);
                }

            } else if(value <node.value) {
                delete(node.left, value);
            } else if(value > node.value) {
                delete(node.right, value);
            }
        }
    }

    int findShortestNumber(TreeNode node) {
        return (node.left == null) ? node.value : findShortestNumber(node.left);
    }
    



    TreeNode makeTreeNode() {
        TreeNode theNode = new TreeNode(111, null, null);
        add(theNode, 53);
        add(theNode, 5);
        add(theNode, 156);
        add(theNode, 3);
        add(theNode, 13);
        add(theNode, 28);
        add(theNode, 59);
        add(theNode, 71);
        add(theNode, 32);
        add(theNode, 1);
        add(theNode, 189);
        add(theNode, 145);
        add(theNode, 1);
        add(theNode, 156);
        add(theNode, 191);
        add(theNode, 190);
        add(theNode, 195);

        return theNode;
    }





    
}
