package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


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
//        Object lock1 = new Object();
//        Object lock2 = new Object();
//        new Thread(new dns(lock1, lock2, true), "线程1").start();
//        new Thread(new dns(lock1, lock2, false), "线程2").start();
        System.out.println("开始:" + new Date().getTime());
//        Object obj = null;
//        for (int i = 0; i < 10; ++i) {
//            obj = new Object();
//            System.out.println(obj.toString());
//        }

        for (int i = 0; i < 10; ++i) {
            Object obj = new Object();
            System.out.println(obj.toString());
        }

        System.out.println("结束:" + new Date().getTime());
    }

    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set<Integer> ss = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            ss.add(candyType[i]);
        }
        return Math.min(len / 2, ss.size());
    }

    public boolean isSubsequence(String s, String t) {
        int len = t.length();
        int lens = s.length();
        char[] arr = s.toCharArray();
        Stack<Character> ss = new Stack<Character>();
        for (int i = lens - 1; i >= 0; --i) {
            ss.add(arr[i]);
        }
        for (int j = 0; j < len; ++j) {
            if (ss.empty()) {
                return true;
            }
            Character cc = ss.peek();
            if (t.charAt(j) == cc) {
                ss.pop();
            }
        }
        return ss.empty() ? true : false;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            char a = text1.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                char b = text2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);

                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        long sum = 0;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            sum = (long) mid * mid;
            if (sum < num) {
                left = mid + 1;
            } else if (sum > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = 0;
        int count = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            count = nums[mid];
            if (count < target) {
                left = mid + 1;
            } else if (count > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (num <= i) {

                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0, j = len - 1, pns = len - 1; i <= j; ) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[pns] = nums[j] * nums[j];
                j--;
            } else {
                ans[pns] = nums[i] * nums[i];
                i++;
            }
            pns--;
        }
        return ans;
    }

    public String getHint(String secret, String guess) {
        int[] cns = new int[10];
        int[] cng = new int[10];
        int Bulls = 0;
        for (int i = 0; i < secret.length(); ++i) {
            char charS = secret.charAt(i);
            char charG = guess.charAt(i);
            if (charS == charG) {
                Bulls++;
            } else {
                cns[charS - '0']++;
                cng[charG - '0']++;
            }
        }
        int Cows = 0;
        for (int j = 0; j < cns.length; ++j) {
            Cows += Math.min(cns[j], cng[j]);
        }
        StringBuilder str = new StringBuilder();
        str.append(Bulls);
        str.append("A");
        str.append(Cows);
        str.append("B");
        return str.toString();
    }

    public void moveZeroes(int[] nums) {
        int left = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; ++i) {
            if (nums[i] == 0) {
                left = i + 1;
                while (left < len - 1 && nums[left] == 0) {
                    left++;
                }
                int dmp = nums[i];
                nums[i] = nums[left];
                nums[left] = dmp;
            }
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int[] res = new int[2];
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i++;
                    res[1] = j++;
                    return res;
                }
            }
        }
        return res;
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        Character dmp = '1';
        while (left < right) {
            dmp = s[left];
            s[left]=s[right];
            s[right]=dmp;
            left++;
            right--;
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; ++i) {
            arr[(i + k) % len] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, len);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
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
                    System.out.println(Thread.currentThread().getName() + "获取锁1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "等待锁2释放");
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + "获取锁2");
                    }
                }
            }
            if (!falg) {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "获取锁2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "等待锁1释放");
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + "获取锁1");
                    }
                }
            }
        }
    }

}
