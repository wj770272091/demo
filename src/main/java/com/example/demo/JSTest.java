package com.example.demo;

import com.example.demo.controller.enumTest;

import java.lang.reflect.Constructor;

/**
 * @NAME: StudyAbroadProcess
 * @USER: 77027
 * @DATE: 2020/10/23
 * @TIME: 16:40
 */
public class JSTest  {
    private static volatile Constructor<enumTest> aa;

    public static void main(String[] args) {

//        JSONArray jsonArray = JSONArray.parseArray("[\"1111\",\"2222\"]");
//        ;
//        System.out.println(jsonArray);
        int[] test = {4, 4, 8, 1, 13, 2, 5, 7, 3, 11};
//        int[] test1 = countSortPlus(test);
//        System.out.println(Arrays.toString(test1));
//        double aa = 0.34;
//        int bb = (int) aa;
//        System.out.println(bb);
//        System.out.println(getMaxSortedDistance(test));
        String a = "3131sasfasd".replaceAll("\\d{2}", "Z");
        String b = "3131sasfasd".replaceAll("^\\d{2}", "Z");
        String c = "3131sdasfasd".replaceAll("sd", "Z");
        String d = "3131sdsfasd".replaceAll("sd$", "Z");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        String str6 = "aa3131sasfasd";
        System.out.println(str6.matches("\\d{2}"));
        System.out.println(str6.matches("^\\d{2}"));
    }

    public static int[] countSortPlus(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        int d = (max - min);
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        int[] sortedArray = new int[array.length];
        for (int i = countArray.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
        }
        return sortedArray;
    }

    public static int[] countSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        int d = (max - min);
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i + min;
            }
        }
        return sortedArray;
    }

    public static int getGreatestCommonDivisorV2(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisorV2(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisorV2(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisorV2(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return getGreatestCommonDivisorV2(big - small, small);
        }
    }

    public static int getMaxSortedDistance(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        int d = max - min;
        if (d == 0) {
            return 0;
        }
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }
        for (int i = 0; i < array.length; i++) {
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        Integer min;
        Integer max;
    }
}

