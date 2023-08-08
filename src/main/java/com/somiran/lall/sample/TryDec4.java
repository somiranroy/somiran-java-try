package com.somiran.lall.sample;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.common.collect.Lists;

public class TryDec4 {

    class Node {
        int data;
        Node pointer;
    }

    Node head = null; 

    void add(int data) {
        if(null ==head) {
            head = new Node();
            head.data = data;
            head.pointer = null;
        } else {
            Node node  = new Node();
            node.data = data;
            node.pointer = head;
            head = node;
        }
    }

    void print() {
        Node node = head;
        
        System.out.println(node.data);
        System.out.println(node.pointer);
        System.out.println(node.pointer.pointer);
        while (null != node) {
            System.out.print(node.data + ",");
            node = node.pointer;
        }

    }

    public void printMiddle() {
        Node fastNode = head;
        Node slowNode = head;

        while(null != fastNode && null != fastNode.pointer) {
            fastNode = fastNode.pointer.pointer;
            slowNode = slowNode.pointer;
        }

        System.out.println("Middle List is: " + slowNode.data);
    }

    void test_linkedlist() {
        add(9);
        add(8);
        add(7);add(6);
        add(5);add(4);
        add(3);add(2);
        add(1);
        print();;
        printMiddle();
    }

    String reverse(String string) {

        if(null == string || string.isEmpty()) {
            return "";
        }
        return reverse(string.substring(1)) + string.charAt(0);
    }

    int[] flatten(Object[] object) {
        if(null == object) {
            return null;
        }

        ArrayList<Integer> flattened = Lists.newArrayList();
        
        Arrays.stream(object).forEach(item -> {
            if(item.getClass().isArray()) {
                Arrays.stream((Integer[]) item).forEach(action -> flattened.add(action));
            } else if (item instanceof Integer){
                flattened.add((Integer)item);
            } else {
                //Ignore- do nothing.
            }
        });
        
        return flattened.stream().mapToInt(i -> i).toArray();
    }

    void check_flattened() {
        assertEquals(null, flatten(null));
        assertArrayEquals(new int[] {}, flatten(new Integer[] {}));
        assertArrayEquals(new int[] {1,2,3}, flatten((new Integer[] {1,2,3})));
        assertArrayEquals(new int[] {1,2,3, 4,5,6}, flatten((new Object[] {1,new Integer[] {2,3}, new Integer[] {4,5,6}})));
    }
 
    public static void main(String[] args) {

        TryDec4 tryD = new TryDec4();
        //tryD.test_linkedlist();
        //assertEquals("narimoS", tryD.reverse("Somiran"));
        tryD.check_flattened();

    }


    
}
