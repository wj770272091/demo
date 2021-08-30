package com.example.demo;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @NAME: BucketTest
 * @USER: 77027
 * @DATE: 2020/11/30
 * @TIME: 9:41
 */
public class BucketTest {

    public static double[] bucketSort(double[] array){
        double max=array[0];
        double min=array[0];
        for (int i=1;i<array.length;i++){
            if(min>array[i]){
                min=array[i];
            }else if (max<array[i]){
                max=array[i];
            }
        }
        double d=max-min;
        int bucketNum=array.length;
        ArrayList<LinkedList<Double>> bucketList=new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i=0;i<bucketNum;i++){
            bucketList.add(new LinkedList<Double>());
        }
        for (int i=0;i<array.length;i++){
            System.out.println("计算"+(array[i]-min));
            int num = (int)((array[i]-min)*(bucketNum-1)/d);
            System.out.println(num);
            bucketList.get(num).add(array[i]);
        }
        for (int i=0;i<bucketList.size();i++){
            Collections.sort(bucketList.get(i));
        }
        double[] sortedArray = new double[array.length];
        int index=0;
        for (LinkedList<Double> list:bucketList){
            for (Double element:list){
                sortedArray[index] = element;
                index++;
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array=new double[]{4.12,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] sortArray = bucketSort(array);
        System.out.println(Arrays.toString(sortArray));
    }

}
