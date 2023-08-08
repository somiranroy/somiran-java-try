package com.somiran.lall.sample;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

import org.apache.commons.lang3.ArrayUtils;

public class TryAug21 {

    public static void main(String[] args) {
        TryAug21 abc =  new TryAug21();
        // abc.checkIsPallindom();
        // abc.checkIfSorted();
        // abc.checkIfSorted_Selection();
        // abc.checkIfSorted_Merged();
        // abc.check_flatten_manyArrays();

        abc.check_Tree();
    }

    void checkIsPallindom() {
        
        assertTrue("Empty String should be true", isPalindom(""));
        assertTrue("r String should be true", isPalindom("r"));
        assertTrue("ra String should be true", isPalindom("ra"));
        assertTrue("rar String should be true", isPalindom("rar"));
        assertTrue("racecar String should be true", isPalindom("racecar"));

        //Negative cases
        assertFalse("Null String should be false", isPalindom(null));
        assertFalse("som String should be false", isPalindom("som"));
        assertFalse("somiran String should be false", isPalindom("somiran"));
    }


    boolean isPalindom(String input) {
        if(null == input) {
            return false;
        } else {
            int length = input.length();

            if(length <= 2) {
                return true;
            } else {
                if (input.charAt(0) == input.charAt(length -1)) {
                    return isPalindom(input.substring(1, length-1));
                } else {
                    return false;
                }
            }
        }
    }


    void checkIfSorted() {
        assertNull(insertionSort(null));
        assertArrayEquals("Empty should be same", new int[]{}, insertionSort(new int[]{}));
        assertArrayEquals("Empty should be same", new int[]{1}, insertionSort(new int[]{1}));
        assertArrayEquals("Empty should be same", new int[]{11,12,22,25,34,64,90}, insertionSort(new int[]{64, 34, 25, 12, 22, 11, 90}));

        int[] array = new int[]{64, 34, 25, 12, 22, 11, 90};
        assertArrayEquals (array, insertionSort(array));
    } 

    int[] insertionSort(int[] unsorted) {

        if(ArrayUtils.isNotEmpty(unsorted)) {
            int j =0;
            int temp;
            //Divide the arry into sorted and unsorted.
            // First element is sorted- remaning is unsorted.

            for(int i=1; i < unsorted.length; i++) {
                j = i;

                while (j > 0 && (unsorted[j] <  unsorted[j-1])) {
                    temp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = temp;

                    j--;
                }

            }
        } 
        return unsorted;
    }



    void checkIfSorted_Selection() {
        assertNull(insertionSort(null));
        assertArrayEquals("Empty should be same", new int[]{}, selectionSort(new int[]{}));
        assertArrayEquals("Empty should be same", new int[]{1}, selectionSort(new int[]{1}));
        assertArrayEquals("Empty should be same", new int[]{11,12,22,25,34,64,90}, selectionSort(new int[]{64, 34, 25, 12, 22, 11, 90}));
    } 

    int[] selectionSort(int[] unsorted) {

        int min_value = 0;
        int min_index = 0;
        if(ArrayUtils.isNotEmpty(unsorted)) {
            for(int i = 0; i <unsorted.length; i++) {
                min_value = unsorted[i];
                min_index = i;
                for(int j=i+1; j <unsorted.length; j++) {
                    if(unsorted[j] < min_value) {
                        min_value = unsorted[j];
                        min_index = j;
                    }
                }
                //Replace                
                if(min_index != i) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[min_index];
                    unsorted[min_index] = temp;
                }
            }
        }
        return unsorted;
    }


    void checkIfSorted_Merged() {
        assertNull(mergedSort(null));
        assertArrayEquals("Empty should be same", new int[]{}, mergedSort(new int[]{}));
        assertArrayEquals("Empty should be same", new int[]{1}, mergedSort(new int[]{1}));
        assertArrayEquals("Empty should be same", new int[]{11,12,22,25,34,64,90}, mergedSort(new int[]{64, 34, 25, 12, 22, 11, 90}));
    } 


    int[] mergedSort(int[] array) {

        if(ArrayUtils.isNotEmpty(array)) {

            if(array.length != 1) {
                
                int[] left = new int[array.length/2];
                int[] right = new int[array.length - left.length];

                for(int i = 0; i < left.length; i++) {
                    left[i] = array[i];
                }
                for(int i = 0; i < right.length; i++) {
                    right[i] = array[left.length+ i];
                }

                left = mergedSort(left);
                right = mergedSort(right);

                array = merge(left, right);

            }
        }
        return array;
    }


    int[] merge(int[] left, int[] right) {
        
        int i=0, j=0, k=0;
        int[] merged = new int[left.length + right.length];

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++; 
            }
            k++; 
        }

        while(i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }

        return merged;
    }

    public void check_flatten_manyArrays() {
        assertArrayEquals(new int[] {}, flatten_manyArrays(ArrayUtils.toObject(new int[] {})));
        assertArrayEquals(new int[] {1,2,3}, flatten_manyArrays(new Integer[] {1,2,3}));
        assertArrayEquals(new int[] {1,2,3,4,5,6}, flatten_manyArrays(new Integer[] {1,2,3}, new Integer[] {4,5,6}));
    }

    int[] flatten_manyArrays(Integer[] ... arrays) {
        return Stream.of(arrays).flatMap(Arrays::stream).mapToInt(i->i).toArray();
    }


    void check_Tree() {
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

        System.out.println("\nPrinting Virgin Tree");
        print(theNode);

        //delete(theNode, 111);
        // System.out.println("\nPrinting After Delete");
        // print(theNode);

        sum_Hopes(theNode, 5, 191);

        maximumSumPath(theNode);
        System.out.println("Max Path Sum Value: " + max);
    }

    TreeNode add(TreeNode node, int value) {
        if(null == node) {
            node = new TreeNode(value, null, null);
        } else if(value < node.value) {
          node.left = add(node.left, value);  
        } else if(value > node.value) {
            node.right = add(node.right, value);
        } 
        return node;
    }

    void print(TreeNode node) {
        if(node == null) {
            return;
        }
        print(node.left);
        System.out.print(node.value + ", ");
        print(node.right);
    }
    

    TreeNode delete(TreeNode node, int value) {
        if(null == node){
            return null;
        }

        if(value < node.value) {
             node.left = delete(node.left, value);

        } else if(value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // This is the equal node and needs to be deleted.
            if(node.left == null && node.right == null) {
                node = null;
            } else if( node.left == null) {
                node = node.right;
            } else if(node.right == null) {
                node = node.left;
            } else {
                node.value = findShortestNumber(node.right);
                node.right = delete(node.right, node.value);
            }

        }

        return node;
        
    }

    int findShortestNumber(TreeNode node) {
        return (null == node.left) ? node.value:  findShortestNumber(node.right);
    }


    void find(TreeNode node, int value, List<TreeNode> nodes) {
        if(null != node){
            if(null == nodes) {
                nodes = Lists.newArrayList();
            }

            nodes.add(node);

            if(node.value == value) {
                return;
            } else if (value < node.value) {
                find(node.left, value, nodes);
            } else {
                find(node.right, value, nodes);
            }
        }
    }


    int sum_Hopes(TreeNode node, int value1, int value2) {
        
        List<TreeNode> first = Lists.newArrayList();
        List<TreeNode> second = Lists.newArrayList();

        find(node, value1, first);
        find(node, value2, second);

        
        first.stream().map(mapper -> mapper.value).forEach(System.out::println);

        System.out.println("Seconfd");
        second.stream().map(mapper -> mapper.value).forEach(System.out::println);

        int i = 0;
        for(i=0; i < first.size() && i < second.size(); i++) {
            if(first.get(i).value != second.get(i).value) {
                break;
            }
        }

        System.out.println("First Path: " + first.stream().skip(i).map(mapper -> mapper.value).reduce(0, Integer::sum));
        System.out.println("Second Path: " + second.stream().skip(i).map(mapper -> mapper.value).reduce(0, Integer::sum));
        System.out.println("LCA Node: " + first.get(i-1).value);

        int result =  first.stream().skip(i).map(mapper -> mapper.value).reduce(0, Integer::sum) + 
                    second.stream().skip(i).map(mapper -> mapper.value).reduce(0, Integer::sum) + 
                    first.get(i-1).value;
        System.out.println("Result Sum Hopes: " + result);

        return result;
    }

    int max = Integer.MIN_VALUE;
    List<TreeNode> maxPathNodes = Lists.newArrayList();

    int maximumSumPath(TreeNode node) {

        if(node == null) {
            return 0;
        }
        
        int left = maximumSumPath(node.left);
        int right = maximumSumPath(node.right);

        // There are 4 possibilities
        // 1. Node
        // 2. Node + Left
        // 3. Node + Right
        // 4. Node + Left + Right 
        
        int returnValue = Math.max(left, right) + node.value;
        
        int maxValue = Math.max(Math.max(node.value, node.value + Math.max(left, right)), node.value+left+right);
        max = Math.max(max, maxValue);

        return returnValue;

    }

}
