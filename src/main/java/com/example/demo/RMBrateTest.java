//package com.example.demo;
//
//import com.alibaba.fastjson.JSONArray;
//import com.example.demo.bean.Person;
//import com.example.demo.controller.enumTest;
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.junit.Test;
//import org.springframework.web.bind.annotation.Mapping;
//
//import java.io.Serializable;
//import java.lang.reflect.Constructor;
//import java.util.*;
//
//import static org.springframework.data.repository.init.ResourceReader.Type.JSON;
//
///**
// * @NAME: StudyAbroadProcess
// * @USER: 77027
// * @DATE: 2020/10/23
// * @TIME: 16:40
// */
//public class RMBrateTest {
//    private static volatile Constructor<enumTest> aa;
//
//    public static void main(String[] args) {
////        Rate rate=new RMBRate();
////        Company watcher1=new ImportCompany();
////        Company watcher2=new ExportCompany();
////        rate.add(watcher1);
////        rate.add(watcher2);
////        rate.change(10);
////        rate.change(-9);
////
////        LinkedList<Integer> list=new LinkedList<Integer>();
////        list.removeFirst();
//
////        String[] strings = new String[2];
////        strings[0] = "111";
////        JSONArray jsonArray = new JSONArray();
////        System.out.println(strings[0]);
////        TreeSet<Integer> treeSet = new TreeSet<Integer>();
////        TreeSet<Integer> treeSet2 = new TreeSet<Integer>();
////        treeSet.add(1);
////        treeSet.add(10);
////        treeSet.add(5);
////        treeSet.add(7);
////        treeSet2 = (TreeSet<Integer>) treeSet.descendingSet();
////        for (Integer i : treeSet2) {
////
////            System.out.println(i);
////        }
////        HashMap hashMap = new HashMap(13);
////        hashMap.put("", "");
////        List<byte[]> byteArrayList = new ArrayList();
////        while(true){
////            byteArrayList.add(new byte[4096]);
////        }
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
//        quickSort(test,0,test.length-1);
//        for (int l = 0; l < test.length; l++) {
//            System.out.println(test[l]);
//        }
//        System.out.println(new Date());
//    }
//
//    public static void quickSort(int[] arr, int startIndex, int endIndex) {
//        if (startIndex >= endIndex) {
//            return;
//        }
//        int pivotIndex = partition(arr, startIndex, endIndex);
//        quickSort(arr,startIndex,pivotIndex-1);
//        quickSort(arr,pivotIndex+1,endIndex);
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
//    public static int partitiond(int[] arr, int startIndex, int endIndex) {
//        int pivot = arr[startIndex];
//        int mark = startIndex;
//
//for (int i=startIndex+1;i<=endIndex;i++){
//    if (arr[i]<pivot){
//        mark++;
//        int p=arr[mark];
//        arr[mark]=arr[i];
//        arr[i]=p;
//    }
//}
//        arr[startIndex] = arr[mark];
//        arr[mark] = pivot;
//        return mark;
//    }
//}
//
//abstract class Rate {
//    protected List<Company> companys = new ArrayList<Company>();
//
//    public void add(Company company) {
//        companys.add(company);
//    }
//
//    public void remove(Company company) {
//        companys.remove(company);
//    }
//
//    public abstract void change(int number);
//}
//
//class RMBRate extends Rate {
//
//    @Override
//    public void change(int number) {
//        for (Company obs : companys) {
//            ((Company) obs).response(number);
//        }
//    }
//}
//
//interface Company {
//    void response(int number);
//}
//
//class ImportCompany implements Company {
//
//    @Override
//    public void response(int number) {
//        if (number > 0) {
//            System.out.println("人民币升值" + number + "个基点,降低进口产品成本!");
//        } else if (number < 0) {
//            System.out.println("人民币贬值" + (-number) + "个基点,提升进口产品成本!");
//        }
//    }
//}
//
//class ExportCompany implements Company {
//    @Override
//    public void response(int number) {
//        if (number > 0) {
//            System.out.println("人民币汇率升值" + number + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
//        } else if (number < 0) {
//            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
//        }
//    }
//}
//
//class etest implements Serializable {
//    private static final Person person = new Person();
//
//    private etest() {
//    }
//
//    public static Person getPerson() {
//        return person;
//    }
//}
//
////@Mapper
////public interface StudentMapper {
////
////    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
////
////    @Mapping(source = "gender.name", target = "gender")
////    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
////    StudentVO student2StudentVO(Student student);
////
////
////    List<StudentVO> students2StudentVOs(List<Student> studentList);
////
////}
