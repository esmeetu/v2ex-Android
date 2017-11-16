package com.firefly.v2ex;

import android.content.Intent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 9/9/17.
 */

public class AppTest {

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getId());
        }
    };

    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getId());

        new Thread(runnable).start();

//        runnable.run();
//        System.out.print(majority1("and1 aaaaassssssroidisaandroidssxksjkjjssssssss"));
    }

    // "andaaaaassssssroidisaandroidssxksjkjjssssssss"
    public static char majority(String s) {
        int[] a = new int[26];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            a[index]++;
            if (a[index] > max) max = a[index];
        }
        char c = 0;
        for(int i = 0; i < 26; i++) {
            if (max == a[i]) {
                c = (char) ('a' + i);
                break;
            }
        }
        return c;
    }

    public static char majority1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int max = -1;
        char key = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }

    //[1, 6, 2, 9, 7, 5, 4]
    public static void reverse(int[] a) {
        if (a == null || a.length == 0) return;
        int lo = 0, hi = a.length - 1;
        while (lo < hi) {
            swap(a, lo, hi);
            lo += 2;
            hi -= 2;
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 1; j < n - i; j++) {
                if (a[j] > a[j-1]) {
                    swap(a, j, j-1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void swap(int[] a, int lo, int hi) {
        int temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }




}
