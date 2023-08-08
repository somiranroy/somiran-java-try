package com.somiran.lall.try1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.ArrayUtils;

public class AlgorithmSort {

    public static void main(String[] args) {

        AlgorithmSort alg = new AlgorithmSort();
        alg.palindromCheck();
        System.out.println("Hello- all looks good with Palindrom.");

        alg.checkFibonacchiNumber();
        System.out.println("Hello- all looks good with Fibonacci Number.");

        alg.checkReverseStgring();
        System.out.println("Hello- all looks good with Reverse String.");

        alg.check_flatten();
        System.out.println("Hello- all looks good with flatten.");

        alg.check_flatten_manyArrays();
        System.out.println("Hello- all looks good with check_flatten_manyArrays.");

        alg.check_bubbleSort();
        System.out.println("Hello- all looks good with check_bubbleSort.");

        alg.check_insertionSort();
        System.out.println("Hello- all looks good with check_insertionSort.");

        alg.check_selectionSort();
        System.out.println("Hello- all looks good with check_selectionSort.");

        alg.check_mergedSort();
        System.out.println("Hello- all looks good with check_mergedSort.");

    }
    
    public void check_mergedSort() {
        assertNull(mergedSort(null));
        assertArrayEquals(new int[] {64}, mergedSort(new int[] {64}));
        assertArrayEquals(new int[] {11,12,22,25,34,64,90}, mergedSort(new int[] {64, 34, 25, 12, 22, 11, 90}));
    }

    public int[] mergedSort (int[] array) {

        if(null == array) {
            return null;
        }

        if(array.length <= 1) {
            return array;
        }

        int[] left = new int[array.length/2];
        int[] right = new int[array.length - left.length];

        for(int i=0; i <array.length/2; i++) {
            left[i] = array[i];
        }

        for(int i=0; i < right.length; i++) {
            right[i] = array[i+left.length];
        }
        
        left = mergedSort(left);
        right = mergedSort(right);

        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {

        int[] merged = new int[left.length + right.length];

        int i=0,j=0,k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
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

    public void check_insertionSort() {
        assertNull(insertionSort(null));
        assertArrayEquals(new int[] {64}, insertionSort(new int[] {64}));
        assertArrayEquals(new int[] {11,12,22,25,34,64,90}, insertionSort(new int[] {64, 34, 25, 12, 22, 11, 90}));
    }

    public int[] insertionSort(int[] array) {
        
        if(ArrayUtils.isEmpty(array)) {
            return array;
        } else {
            int length = array.length;
            int temp = 0;

            for (int i =1; i <length; i++) {
                int j = i;
                while(j > 0) {
                    if (array[j-1] > array[j] ) {
                        temp = array[j-1];
                        array[j-1] = array[j];
                        array[j] = temp;
                     }
                    j--;
                }
            }
        }

        return array;
    }

    public void check_selectionSort() {
        assertNull(selectionSort(null));
        assertArrayEquals(new int[] {64}, selectionSort(new int[] {64}));
        assertArrayEquals(new int[] {11,12,22,25,34,64,90}, selectionSort(new int[] {64, 34, 25, 12, 22, 11, 90}));
    }

    public int[] selectionSort(int[] array) {

        if(!ArrayUtils.isEmpty(array)) {

            int length = array.length;
            int min_value = 0;
            int min_index = 0;

            for(int i=0 ; i <length; i++) {
                min_index = i;
                min_value = array[i];
                for (int j = i; j <length-1; j++) {
                    if(array[j] < min_value) {
                        min_value = array[j];
                        min_index = j;
                    }
                }
                array[min_index] = array[i];
                array[i] = min_value;
            }
        } 
        return array;
    }





    public void check_bubbleSort() {
        assertEquals(null, bubbleSort(null));
        assertArrayEquals(new int[] {64}, bubbleSort(new int[] {64}));
        assertArrayEquals(new int[] {11,12,22,25,34,64,90}, bubbleSort(new int[] {64, 34, 25, 12, 22, 11, 90}));

    }

    public int[] bubbleSort(int[] array) {

        if(ArrayUtils.isEmpty(array)) {
            return array;
        } else {
            boolean isAnythingChanged = false;
            int temp = 0;

            do {
                isAnythingChanged = false;
                for (int i=0; i < array.length -1; i++) {
                    if(array[i] > array[i+1]) {
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        isAnythingChanged = true;
                    }
                }
            } while(isAnythingChanged);
        }

        return array;
    }


    






    public void check_flatten() {
        assertNull(flatten(null));
        assertArrayEquals(new int[] {}, flatten(new Integer[] {}));
        assertArrayEquals(new int[] {1,2,3}, flatten(new Object[] {new Integer[] {1,2,3}}));
        assertArrayEquals(new int[] {1,2,3,4,5,6}, flatten(new Object[] {new Integer[] {1,2,3}, new Integer[] {4,5,6}}));
    }

    public void check_flatten_manyArrays() {
        assertArrayEquals(new int[] {}, flatten_manyArrays(ArrayUtils.toObject(new int[] {})));
        assertArrayEquals(new int[] {1,2,3}, flatten_manyArrays(new Integer[] {1,2,3}));
        assertArrayEquals(new int[] {1,2,3,4,5,6}, flatten_manyArrays(new Integer[] {1,2,3}, new Integer[] {4,5,6}));
    }

    int[] flatten_manyArrays(Integer[] ... arrays) {
        return Stream.of(arrays).flatMap(Arrays::stream).mapToInt(i-> i).toArray();
    }

    public int[] flatten(Object[] input) {

        if(null == input) {
            return null;
        } else if(input.length == 0) {
            return new int[] {};
        } else {
            List<Integer> result = Lists.newArrayList();
        
            Stream.of(input).forEach(each -> {
                if(each instanceof Integer) {
                    result.add((Integer)each);
                } else if (each.getClass().isArray()) {
                    result.addAll(Arrays.asList((Integer[])each));
                } else if (each instanceof List){
                    result.addAll((List<Integer>)each);
                } else {
                    // Ignore do nothing
                }
            });
    
            return result.stream().mapToInt(i -> i).toArray();
        }
    }





    // Palindrom is a word that is symmetrically same in the middle.
    public void palindromCheck() {
        assertFalse("null or empty string not allowed", isPalindrom(""));
        assertFalse("null or empty string not allowed", isPalindrom(null));
        assertTrue("rar should be palandrom", isPalindrom("a"));
        assertTrue("rar should be palandrom", isPalindrom("ar"));
        assertTrue("rar should be palandrom", isPalindrom("rar"));
        assertTrue("Noon should be palandrom", isPalindrom("noon"));
        assertTrue("RaceCar should be palandrom", isPalindrom("racecar"));
        assertFalse("RaceCar should be palandrom", isPalindrom("racsadadasdaecar"));
    }

    boolean isPalindrom(String string) {

        boolean result = false;
        if(!Strings.isNullOrEmpty(string)) {
            int length = string.length();
            if(length > 2) {
                if(string.charAt(0) == string.charAt(length -1)) {
                    return isPalindrom(string.substring(1, length-1));
                }
            } else {
                return true;
            }
        }
        return result;
   }


   public void checkFibonacchiNumber () {
    assertEquals ("1st position should be 0",0, fibonacciNumber(0));
    assertEquals ("2nd position should be 1",1, fibonacciNumber(1));
    assertEquals ("3rd position should be 2",1, fibonacciNumber(2));
    assertEquals ("4th position should be 3",2, fibonacciNumber(3));
    assertEquals ("5th position should be 3",3, fibonacciNumber(4));
    assertEquals ("6th position should be 3",5, fibonacciNumber(5));
    assertEquals ("7th position should be 3",8, fibonacciNumber(6));
   }

    public int fibonacciNumber(int position) {

        int result = 0;
        if( 0 == position) {
            result = 0;
        } else if( 1 == position) {
            result = 1;
        } else {
            result = fibonacciNumber(position -1) + fibonacciNumber(position -2);
        }

        return result;
   }


   public void checkReverseStgring() {
        assertNull("null was wrong", reverseString(null));
        assertEquals("empty was wrong", "", reverseString(""));
        assertEquals("a was wrong", "a", reverseString("a"));
        assertEquals("an was wrong", "an", reverseString("na"));
        assertEquals("Som was wrong", "som", reverseString("mos"));
        assertEquals("Somiran was wrong", "somiran", reverseString("narimos"));
   }


   public String reverseString(String string) {

    if(Strings.isNullOrEmpty(string)) {
        return string;
    } else {
        int length = string.length();

        if(1 == length) {
            return string;
        } else {
            return reverseString(string.substring(1, length)) + string.charAt(0);
        }        
    }
}




}
