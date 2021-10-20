package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
class DemoApplicationTests {

    @Test
    void contextLoads() {
//        File file=new File("E:\\360MoveData\\Users\\77027\\Documents\\Tencent Files\\770272091\\FileRecv\\_______o5iltc.html");
//        new ParseFile().readHtml(file);
//        String str="<div xmlns=\"\" id=\"idm576458645-container\" style=\"margin: 0 0 45px 0;\" class=\"section-wrapper\"><div class=\"clear\"></div></div>";
//        System.out.println(str.length());
//        int[] res=new int[]{5,-3,5};
//        MsTest.maxSubarraySumCircular(res);
//        List<ExportTemperatureDto> list=new ArrayList<>();
//        list.add(new ExportTemperatureDto(1,"haha"));
//        list.add(new ExportTemperatureDto(1,"haha121"));
//        list.add(new ExportTemperatureDto(2,"gffg"));
//        list.add(new ExportTemperatureDto(3,"dasdeas"));
//        ArrayList<ExportTemperatureDto> ress = list.stream().collect(collectingAndThen(
//                toCollection(
//                        () -> new TreeSet<>(comparing(ExportTemperatureDto::getPersonId))
//                ),
//                ArrayList::new
//        ));
//        for (ExportTemperatureDto ex:ress){
//            System.out.println(ex.toString());
//        }
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new dns(lock1, lock2, true), "线程1").start();
        new Thread(new dns(lock1, lock2, false), "线程2").start();
    }

    public class dns implements Runnable {
        Object lock1;
        Object lock2;
        Boolean falg;

        public dns(Object lock1, Object lock2, Boolean falg) {
            this.lock1 = lock1;
            this.lock2 = lock2;
            this.falg = falg;
        }

        @Override
        public void run() {
            if (falg) {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName()+"获取锁1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"等待锁2释放");
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName()+"获取锁2");
                    }
                }
            }
            if (!falg){
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName()+"获取锁2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"等待锁1释放");
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+"获取锁1");
                    }
                }
            }
        }
    }

}
