package com.example.demo;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @NAME: MsTest
 * @USER: 77027
 * @DATE: 2020/12/1
 * @TIME: 9:56
 */
public class MsTest {

    /**
     * 栈模拟队列
     */
    static class StackQueue {
        private Stack<Integer> stackA = new Stack<Integer>();
        private Stack<Integer> stackB = new Stack<Integer>();

        public void enQueue(int element) {
            stackA.push(element);
        }

        public Integer deQueue() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    return null;
                }
                transfer();
            }
            return stackB.pop();
        }

        private void transfer() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }
    }

    /**
     * 全排列的下一个数
     */
    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i++) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    public static int[] findNearestNumber(int[] numbers) {
        int index = findTransferPoint(numbers);
        if (index == 0) {
            return null;
        }
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        numbersCopy = exchangeHead(numbersCopy, index);
        reverse(numbers, index);
        return numbersCopy;
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] book : bookings) {
            res[book[0] - 1] += book[2];
            if (book[1] < n) {
                res[book[1]] -= book[2];
            }
        }

        for (int j = 1; j < n; ++j) {
            res[j] +=res[j-1] ;
        }
        return res;
    }

    /**
     * 删除k个数的最小值
     */
    public static String removeKDigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1, num.length());
                    hasCut = true;
                    break;
                }
            }
            if (!hasCut) {
                num = num.substring(0, num.length() - 1);
            }
            int start = 0;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) != '0') {
                    break;
                }
                start++;
            }
            num = num.substring(start, num.length());
            if (num.length() == 0) {
                return "0";
            }
        }
        return num;
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        int[] numbers = {1, 2, 3, 4, 5};

        BlockingQueue<Runnable> workQueue;
        System.out.println(Arrays.toString(findNearestNumber(numbers)));
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));
    }


}

class BlockingQueueExam {
    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);
//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            service.submit(new Producer("Producer" + i, blockingQueue));
//        }
//        for (int i = 0; i < 5; i++) {
//            service.submit(new Consumer("Consumer" + i, blockingQueue));
//        }
//        service.shutdown();
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("风清扬");
        arrayList.add("李莫愁");
        arrayList.add("东方不败");
        arrayList.add("李莫愁");
        arrayList.add("西门庆");
        arrayList.add("风清扬");
        arrayList.add("孙悟空");
        arrayList.add("风清扬");
        arrayList.add("李莫愁");
        arrayList.add("风清扬");

        StringBuffer regex = new StringBuffer("1");
        ListIterator<String> lit = arrayList.listIterator();
        while (lit.hasNext()) {
            String temp = lit.next();
            Pattern p = Pattern.compile(temp);//这两句很关键！
            System.out.println(regex.toString());
            Matcher m = p.matcher(regex.toString());
            if (m.find()) {
                lit.remove();
            } else {
                regex.append(temp);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));

        }


    }
}

class Producer implements Runnable {
    private final String name;
    private final BlockingQueue<String> blockingQueue;
    private static Random rand = new Random(47);
    private static AtomicInteger productID = new AtomicInteger(0);

    Producer(String name, BlockingQueue<String> blockingQueue) {
        this.name = name;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                SECONDS.sleep(rand.nextInt(5));
                String str = "Product" + productID.getAndIncrement();
                blockingQueue.add(str);                //注意，这里得到的size()有可能是错误的
                System.out.println(name + " product " + str + ", queue size = " + blockingQueue.size());
            }
            System.out.println(name + " is over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final String name;
    private final BlockingQueue<String> blockingQueue;
    private static Random rand = new Random(47);

    Consumer(String name, BlockingQueue<String> blockingQueue) {
        this.name = name;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                SECONDS.sleep(rand.nextInt(5));
                String str = blockingQueue.take();                //注意，这里得到的size()有可能是错误的
                System.out.println(name + " consume " + str + ", queue size = " + blockingQueue.size());
            }
            System.out.println(name + " is over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

