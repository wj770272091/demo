//package com.example.demo;
//
//import com.alibaba.fastjson.JSONArray;
//import com.example.demo.bean.Person;
//import com.example.demo.controller.enumTest;
//
//import java.io.Serializable;
//import java.lang.reflect.Constructor;
//import java.util.*;
//
///**
// * @NAME: StudyAbroadProcess
// * @USER: 77027
// * @DATE: 2020/10/23
// * @TIME: 16:40
// */
//public class SFTest {
//    private static volatile Constructor<enumTest> aa;
//
//    public static void main(String[] args) {
//
//        JSONArray jsonArray = JSONArray.parseArray("[\"1111\",\"2222\"]");
//        ;
//        System.out.println(jsonArray);
//        int[] test = {4, 4, 8, 1, 2, 5, 7, 3};
////最后一次交换的位置
//        int lastIndex = 0;
////无序数列的边界
//        int sortBorder = test.length - 1;
////for (int i=0 ;i<test.length-1;i++){
//////    boolean sign = true;
//////    for (int j=0;j<sortBorder;j++){
//////        int a=0;
//////        if (test[j]>test[j+1]){
//////            a=test[j+1];
//////            test[j+1]=test[j];
//////            test[j]=a;
//////            lastIndex=j;
//////            sign=false;
//////        }
//////    }
//////    sortBorder=lastIndex;
//////    if (sign){
//////        break;
//////    }
//////}
////
////        for (int i = 0; i < test.length / 2; i++) {
////            boolean b = true;
////            int tmp = 0;
////            for (int j = i; j < test.length-i - 1; j++) {
////                if (test[j] > test[j + 1]) {
////                    tmp = test[j];
////                    test[j] = test[j + 1];
////                    test[j + 1] = tmp;
////                    b = false;
////                }
////            }
////            if (b){
////                break;
////            }
////            b=true;
////            for (int j=test.length-i-1;j>i;j--){
////                if (test[j]<test[j-1]){
////                    tmp=test[j];
////                    test[j]=test[j-1];
////                    test[j-1]=tmp;
////                    b=false;
////                }
////            }
////            if (b){
////                break;
////            }
////
////        }
//
////        quickSortZ(test, 0, test.length - 1);
//        heapSort(test);
//        System.out.println(Arrays.toString(test));
////        for (int l = 0; l < test.length; l++) {
////            System.out.println(test[l]);
////        }
//        System.out.println(new Date());
//    }
//
//    public static void quickSort(int[] arr, int startIndex, int endIndex) {
//        if (startIndex >= endIndex) {
//            return;
//        }
//        int pivotIndex = partition(arr, startIndex, endIndex);
//        quickSort(arr, startIndex, pivotIndex - 1);
//        quickSort(arr, pivotIndex + 1, endIndex);
//    }
//
//    public static int partition(int[] arr, int startIndex, int endIndex) {
//        int pivot = arr[startIndex];
//        int left = startIndex;
//        int right = endIndex;
//        while (left != right) {
//            while (left < right && arr[right] > pivot) {
//                right--;
//            }
//            while (left < right && arr[left] <= pivot) {
//                left++;
//            }
//            if (left < right) {
//                int p = arr[left];
//                arr[left] = arr[right];
//                arr[right] = p;
//            }
//        }
//        arr[startIndex] = arr[left];
//        arr[left] = pivot;
//        return left;
//    }
//
//    public static int partitiond(int[] arr, int startIndex, int endIndex) {
//        int pivot = arr[startIndex];
//        int mark = startIndex;
//
//        for (int i = startIndex + 1; i <= endIndex; i++) {
//            if (arr[i] < pivot) {
//                mark++;
//                int p = arr[mark];
//                arr[mark] = arr[i];
//                arr[i] = p;
//            }
//        }
//        arr[startIndex] = arr[mark];
//        arr[mark] = pivot;
//        return mark;
//    }
//
//    public static void quickSortZ(int[] arr, int startIndex, int endIndex) {
//        Stack<Map<String, Integer>> quickSortStack = new Stack<Map<String, Integer>>();
//        Map rootParam = new HashMap();
//        rootParam.put("startIndex", startIndex);
//        rootParam.put("endIndex", endIndex);
//        quickSortStack.push(rootParam);
//        while (!quickSortStack.isEmpty()) {
//            Map<String, Integer> param = quickSortStack.pop();
//            int pivotIndex = partitiond(arr, param.get("startIndex"), param.get("endIndex"));
//            if (param.get("startIndex") < pivotIndex - 1) {
//                Map<String, Integer> leftParam = new HashMap<String, Integer>();
//                leftParam.put("startIndex", param.get("startIndex"));
//                leftParam.put("endIndex", pivotIndex - 1);
//                quickSortStack.push(leftParam);
//            }
//            if (pivotIndex + 1 < param.get("endIndex")) {
//                Map<String, Integer> rightParam = new HashMap<String, Integer>();
//                rightParam.put("startIndex", pivotIndex + 1);
//                rightParam.put("endIndex", param.get("endIndex"));
//                quickSortStack.push(rightParam);
//            }
//        }
//    }
//
//
//    public static void downAdjust(int[] arrary, int parentIndex, int length) {
//        int temp = arrary[parentIndex];
//        int childIndex = 2 * parentIndex + 1;
//        while (childIndex < length) {
//            if (childIndex + 1 < length && arrary[childIndex + 1] > arrary[childIndex]) {
//                childIndex++;
//            }
//            if (temp>=arrary[childIndex]){
//                break;
//            }
//            arrary[parentIndex]=arrary[childIndex];
//            parentIndex = childIndex;
//            childIndex = 2*childIndex+1;
//        }
//        arrary[parentIndex]=temp;
//    }
//
//    public static void heapSort(int[] array){
//for (int i= (array.length-2)/2;i>=0;i--){
//downAdjust(array,i,array.length);
//}
//System.out.println(Arrays.toString(array));
//for (int i=array.length-1;i>0 ;i--){
//    int temp=array[i];
//    array[i]=array[0];
//    array[0]=temp;
//            downAdjust(array,0,i);
//}
//
//    }
//}
//
