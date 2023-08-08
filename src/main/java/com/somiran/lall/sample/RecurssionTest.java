package com.somiran.lall.sample;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.elasticsearch.common.Strings;

public class RecurssionTest {


    public static void main(String[] args) {

        int[]unsorted = new int[] {5,3,1,2,4,6, 3, 9, 5};
        RecurssionTest recurssionClass = new RecurssionTest();
        
        long start = (new Date()).getTime();
        
        long stop = (new Date()).getTime();
        
        System.out.print(TimeUnit.SECONDS.convert(start - stop, TimeUnit.MILLISECONDS));
        
    //    recurssionClass.alg_sort_quick(unsorted);
    //    System.out.print(Arrays.toString(unsorted));
        
//        System.out.println(Arrays.toString(recurssionClass.alg_sort_merge(new int[] {5,3,1,2,4,6})));
//
//        assertEquals(6, recurssionClass.sumNumbers(3));
//
//
//        //fibonacchiNumber = 0, 1, 1, 2, 3, 5, 8, 11... 
//        assertEquals(0, recurssionClass.fibonacchiNumber(1));
//        assertEquals(1, recurssionClass.fibonacchiNumber(2));
//        assertEquals(1, recurssionClass.fibonacchiNumber(3));
//        assertEquals(2, recurssionClass.fibonacchiNumber(4));
//        assertEquals(3, recurssionClass.fibonacchiNumber(5));
//        assertEquals(5, recurssionClass.fibonacchiNumber(6));
//        assertEquals(8, recurssionClass.fibonacchiNumber(7));
//
//
//        //As a reminder, if a string is equal to its reverse, it is called a palindrome. Such as Madam, civic, kayak. If you reverse any of these words they stay the same.
//        assertEquals(true, recurssionClass.isPalindrome("kayak"));
//        assertEquals(true, recurssionClass.isPalindrome("civic"));
//        assertEquals(false, recurssionClass.isPalindrome("somiran"));
//        assertEquals(true, recurssionClass.isPalindrome("k"));
//        assertEquals(true, recurssionClass.isPalindrome("kk"));
//
//
//        //S
//        //So
//        //Som
//        //Somiran
//        //SomiranR
//        assertEquals("S", recurssionClass.reverse("S"));
//        assertEquals("oS", recurssionClass.reverse("So"));
//        assertEquals("moS", recurssionClass.reverse("Som"));
//        assertEquals("narimoS", recurssionClass.reverse("Somiran"));
//        assertEquals("RnarimoS", recurssionClass.reverse("SomiranR"));
//        assertEquals("", recurssionClass.reverse(""));
//        assertEquals(null, recurssionClass.reverse(null));
//        
//        assertEquals("S", recurssionClass.reverse_modified("S"));
//        assertEquals("oS", recurssionClass.reverse_modified("So"));
//        assertEquals("moS", recurssionClass.reverse_modified("Som"));
//        assertEquals("narimoS", recurssionClass.reverse_modified("Somiran"));
//        assertEquals("RnarimoS", recurssionClass.reverse_modified("SomiranR"));
//        assertEquals("", recurssionClass.reverse_modified(""));
//        assertEquals(null, recurssionClass.reverse_modified(null));
//        
//        assertEquals(null, recurssionClass.flatten(null));
//        assertArrayEquals(new int[] {}, recurssionClass.flatten(new Integer[] {}));
//        assertArrayEquals(new int[] {1,2,3}, recurssionClass.flatten((new Integer[] {1,2,3})));
//        assertArrayEquals(new int[] {1,2,3, 4,5,6}, recurssionClass.flatten((new Object[] {1,new Integer[] {2,3}, new Integer[] {4,5,6}})));
//        
//        // Bubble sort- https://www.geeksforgeeks.org/bubble-sort/
//        // O (n^2)
//        assertEquals(null, recurssionClass.sort_bubble(null));
//        assertArrayEquals(new int[] {11,12,22,25,34,64,90}, recurssionClass.sort_bubble(new int[] {64, 34, 25, 12, 22, 11, 90}));
//        
//        // Insertion Sort- https://www.geeksforgeeks.org/insertion-sort/?ref=leftbar-rightbar
//        // Make the 
        
        
        
    }
    

    
    
    
    
    
    private void alg_sort_quick(int[] unsorted) {
        alg_sort_quick(unsorted, 0, unsorted.length-1);
    }
    
    private void alg_sort_quick(int[] unsorted, int lowIndex, int highIndex) {
        
        System.out.println(Arrays.toString(Arrays.copyOfRange(unsorted, lowIndex, highIndex+1)));
        System.out.printf("Start %d, End is: %d\n", lowIndex, highIndex);
        
        if(lowIndex >= highIndex && highIndex > 1) {
            return;
        }
        
        int pivot = unsorted[highIndex];
        
        int lp = 0;
        int rp = highIndex -1;
        
        while (lp != rp) {
            
            
            if(unsorted[lp] <= pivot) {
                lp++;
            } else {
                while(rp > 1 && unsorted[rp] > pivot) {
                    rp--;
                }
                int temp = unsorted[lp];
                unsorted[lp] = unsorted[rp];
                unsorted[rp] = temp;
                lp++;
            }
        }
        unsorted[highIndex] = unsorted[lp];
        unsorted[lp] = pivot;
        
        alg_sort_quick(unsorted, lowIndex, lp-1);
        alg_sort_quick(unsorted, lp+1, highIndex);

    }
    
    // Check https://www.youtube.com/watch?v=bOk35XmHPKs
    // 
    private int[] alg_sort_merge(int[] unsorted) {
        
        int length = unsorted.length;
        
        if(length <= 1) {
            return unsorted;
        }
        
        int[] left  = new int[length/2];
        int[] right = new int[length - left.length];
        
        for(int i=0; i < left.length; i++) {
            left[i] = unsorted[i];
        }
        for(int i=0; i < right.length; i++) {
            right[i] = unsorted[i+left.length];
        }
        
        left = alg_sort_merge(left);
        right = alg_sort_merge(right);
        
        return merge(left, right);
        
    }
    
    
    private int[] merge(int[] left, int[] right) {
        
        int[] merged = new int[left.length + right.length];
        
        int i=0, j=0, k=0;
        
        while(i< left.length && j <right.length) {
            if(left[i] < right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            
            k++;
        }
        
        while(i <left.length) {
            merged[k] = left[i];
            i++; 
            k++;
        }

        while(j <right.length) {
            merged[k] = right[j];
            j++; 
            k++;
        }
        return merged;
        
    }
    
    // Simple algorithm- make iteration multipl times throughout the arry
    // Go element by element - compare between i-th element and i+1 th element. Sort between them. 
    // Repeat multipl times till no more swaps are done. 

    private int[] alg_sort_bubble(int[] unsorted) {

        if (null == unsorted)
            return null;
        int length = unsorted.length;
        boolean anythingChanged = false;
        int temp;
        int cycle = 0;
        
        do {
            System.out.println("Cycle count: " + cycle++);
            System.out.println("Array is: " + Arrays.toString(unsorted));
            
            anythingChanged = false;
            for (int i=0; i < length-1; i++) {
                System.out.printf("Checking %d and %d\n", i, i+1);
                if(unsorted[i] > unsorted[i+1]) {
                    System.out.printf("Swapping... %d and %d\n", unsorted[i],unsorted[i+1]);
                    temp = unsorted[i+1];
                    unsorted[i+1] = unsorted[i];
                    unsorted[i] = temp;
                    anythingChanged = true;
                }
            }            
        }while (anythingChanged);
        return unsorted;
    }
    
    
    // Look at the URL- https://www.youtube.com/watch?v=0lOnnd50cGI
    // Take an element from the unsorted list and put it in sorted list

    
    private int[] alg_sort_insertion(int[] unsorted) {
        if (null == unsorted)
            return null;
        
        int length = unsorted.length;
        System.out.println("Array is: " + Arrays.toString(unsorted));
        
        // Start from the 2nd element so i = 1.
        for(int i=1; i < length; i++) {
            int j = i;

            // Take the i-th element and put it in the sorted list. 
            // The way we would do it is keep shifting ith element to the left till we find either the start of the array
            // or the number is put in the right place. See- https://www.youtube.com/watch?v=0lOnnd50cGI - 1:30 min
            while (j > 0 && unsorted[j-1] > unsorted[j]) {
                int temp = unsorted[j-1];
                unsorted[j-1] = unsorted[j];
                unsorted[j] = temp;
                j--;
            }
        }
        return unsorted;
    }
    
    // Selection Sort
    // Again Make sorted and Unsorted List
    // Take the least from the unsorted list and put thme at the end of sorted list
    // https://www.youtube.com/watch?v=xWBP4lzkoyM&t=61s
    // Sort the unsorted list
    
    private int[] alg_sort_selection(int[] unsorted) {
        
        int min_value;
        int min_index;
        for (int i= 0; i < unsorted.length; i++) {
            min_value = unsorted[i];
            min_index = i;
            
            // Find the min value in the unsorted list
            for (int j=i+1; j<unsorted.length-1; j++) {
                if (unsorted[j] < min_value) {
                    min_value = unsorted[j];
                    min_index = j;
                }
            }
            
            // Replace them
            int temp = unsorted[min_index];
            unsorted[min_index] = unsorted[i];
            
            unsorted[i] = temp;
        }
        
        return unsorted;
    }
    
    
    
    private int[] sort_insert(int[] test) {
        if(null == test)
            return null;
        int length = test.length;
        
        int[] sorted_sandbox = new int[length];
        sorted_sandbox[0] = test[0];
            
        
        
        for (int i=1; i<length-1; i++) {
            for (int j=0; j<sorted_sandbox.length-1; j++) {
                if(test[i] > (sorted_sandbox[j])) {
                    
                }
            }
        }
        
        return test;
        
    }
    
    private int[] sort_bubble(int[] test) {

        if(null == test)
            return null;
        
        int length = test.length;
        int temp;
        boolean changed = true;
        
        while (changed) {
            changed = false;
            for (int i=0; i <length-1; i++) {
                if(test[i] > test [i+1]) {
                    temp = test[i];
                    test[i] = test[i+1];
                    test[i+1] = temp;
                    
                    changed = true;
                    
                }
            }
        }
        
        return test;
    }

    private int[] flatten (Object[] array) {
        if(null == array) 
            return null;
        
        if(array.length == 0) {
            return new int[] {};
        }
        
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        Arrays.stream(array).forEach( item -> {
            if(item.getClass().isArray()) {
                Arrays.stream((Integer[])item).forEach(i -> aList.add(i));
                
            } else {
                if((item instanceof Integer))
                    aList.add(((Integer) item).intValue());
                else 
                    System.out.print("Problem in Hand- Invalid Type");
            }
        });
        
        return aList.stream().mapToInt(i -> i).toArray();
    }
    
    
    
    private String reverse_modified (String test) {
        
        if(null == test)
            return null;
        
        if(Strings.isEmpty(test)) {
            return "";
        }
        
        return reverse_modified(test.substring(1)) + test.charAt(0);
    }
    
    private String reverse(String test) {

        String result = swapChar(test, 0);

        System.out.println("Input is : " + test + " and output is : " + result);
        return result;
    }

    private String swapChar(String test, int position) {

        if(Strings.isEmpty(test) || test.length() == 1)
            return test;

        int length = test.length();

        if(position >= length/2)
            return test;

        if(length == 2) {
            return test.charAt(1) + "" + test.charAt(0);
        }

        String passOn = 
                test.substring(0,position) + 
                test.charAt(length -position -1) + 
                test.substring(position+1, length -position -1) + 
                test.charAt(position) + 
                test.substring(length -position, length);
        System.out.println("Next Pass: " + passOn);

        return swapChar(passOn, position+1);

    }
    
    

    private int sumNumbers (final int maxNumber) {
        int result = 0;

        if (maxNumber != 0) {
            return maxNumber + sumNumbers(maxNumber-1);
        }

        return result;

    }

    private int fibonacchiNumber(final int position) {

        int value = 0;

        if (position == 1)
            value = 0;
        else if (position == 2)
            value = 1;
        else 
            value = fibonacchiNumber (position -1) + fibonacchiNumber (position -2);

        return value;

    }

    private boolean isPalindrome(String test) {

        if((null == test) || (test.length() == 0))
            return false;

        if(test.length() == 1) 
            return true;

        test = test.toLowerCase();
        if(test.charAt(0) != test.charAt(test.length() -1)) {
            return false;
        } else {
            test = test.substring(1, test.length() -1);
            if (test.length() == 0)
                return true;
            else {
                return isPalindrome (test);
            }
        }
    }
    
    
    
    
    






}



