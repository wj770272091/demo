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

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split(".");
        String[] str2 = version2.split(".");
        for (int i = 0; i < str1.length || i < str2.length; ++i) {
            int x = 0, y = 0;
            if (i < str1.length) {
                x = Integer.parseInt(str1[i]);
            }
            if (i < str2.length) {
                y = Integer.parseInt(str2[i]);
            }
            if (x < y) {
                return 1;
            }
            if (x > y) {
                return -1;
            }
        }
        return 0;
    }

    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                nums[i] = nums[nums.length - (1 + count)];
                count++;
            }

        }
        return nums.length - count;
    }

    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < res.length; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch == ' ' && length == 0) {
                continue;
            } else if (ch == ' ' && length != 0) {
                break;
            }
            length++;
        }
        return length;
    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int R = 0;
        int L = 0;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'R':
                    R++;
                    break;
                case 'L':
                    L++;
                    break;
                default:
                    break;
            }
            if (R == L && R != 0) {
                count++;
            }
        }
        return count;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right++;
            } else {
                res[0] = numbers[left];
                res[1] = numbers[right];
            }
        }
        return res;
    }

    public int titleToNumber(String columnTitle) {
        int num = 0;
        int ascii = 1;
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            num += k * ascii;
            ascii*=26;
        }
        return num;
    }

    public int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        }
        int left = 0, right = needle.length();
        while (right <= haystack.length()) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 1, right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right];
                ++left;
            }
            ++right;
        }
        return left;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder str = new StringBuilder(strs[0]);
        int length = str.length();
        for (int i = 1; i < strs.length; ++i) {
            if (length == 0 || strs[i].isEmpty()) {
                return "";
            }
            int shortLength = 0;
            if (strs[i].length() < length) {
                shortLength = strs[i].length();
            } else {
                shortLength = length;
            }
            for (int j = 0; j < shortLength; ++j) {
                if (strs[i].charAt(j) != str.charAt(j)) {
                    str = str.delete(j, str.length());
                    length = str.length();
                    break;
                }
                if (j == strs[i].length() - 1) {
                    str = str.delete(j + 1, str.length());
                }
            }

        }
        return str.toString();
    }

    public static void generate(List<String> list, StringBuilder str, int left, int right, int n) {
        if (str.length() == 2 * n) {
            list.add(str.toString());
            return;
        }
        if (left < n) {
            str.append('(');
            generate(list, str, left + 1, right, n);
            str.deleteCharAt(str.length() - 1);
        }
        if (right < left) {
            str.append(')');
            generate(list, str, left, right + 1, n);
            str.deleteCharAt(str.length() - 1);
        }
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
//        StackQueue stackQueue = new StackQueue();
//        stackQueue.enQueue(1);
//        stackQueue.enQueue(2);
//        stackQueue.enQueue(3);
//        System.out.println(stackQueue.deQueue());
//        System.out.println(stackQueue.deQueue());
//        stackQueue.enQueue(4);
//        System.out.println(stackQueue.deQueue());
//        System.out.println(stackQueue.deQueue());
//        int[] numbers = {1, 2, 3, 4, 5};
//
//        BlockingQueue<Runnable> workQueue;
//        System.out.println(Arrays.toString(findNearestNumber(numbers)));
//        System.out.println(removeKDigits("1593212", 3));
//        System.out.println(removeKDigits("30200", 1));
//        System.out.println(removeKDigits("10", 2));
//        System.out.println(removeKDigits("541270936", 3));
        generateParenthesis(3);
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

