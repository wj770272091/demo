package com.example.demo;


import org.junit.jupiter.api.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.regex.Pattern;


@SpringBootApplication
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
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

//        for (int i = 0; i < 10; ++i) {
//            Object obj = new Object();
//            System.out.println(obj.toString());
//        }
//
//        System.out.println("结束:" + new Date().getTime());
//        isAdditiveNumber("199100199");
        Options opt = new OptionsBuilder()
                .include(LinkedListIterationBenchMark.class.getSimpleName())
                .forks(1)
                .warmupIterations(2)
                .measurementIterations(2)
                .output("E:/Benchmark.log")
                .build();

        try {
            new Runner(opt).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if (gcd(j, i) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> setR = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            setR.put(list1[i], i);
        }
        List<String> re = new ArrayList<>();
        int minIndexSum = -1;
        for (int j = 0; j < list2.length; ++j) {
            if (setR.containsKey(list2[j])) {
                int nn = j + setR.get(list2[j]);
                if (minIndexSum == -1) {
                    minIndexSum = nn;
                }
                if (nn < minIndexSum) {
                    minIndexSum = nn;
                    re.clear();
                }
                if (nn == minIndexSum) {
                    re.add(list2[j]);
                }

            }

        }
        return re.toArray(new String[re.size()]);
    }

    int[] nums;
    int orVal, cut;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.orVal = 0;
        this.cut = 0;
        dddd(0, 0);
        return cut;
    }

    public void dddd(int cc, int maxN) {
        if (cc == nums.length) {
            if (maxN > orVal) {
                orVal = maxN;
                cut = 1;
            } else if (maxN == orVal) {
                cut++;
            }
            return;
        }
        dddd(cc + 1, maxN | nums[cc]);
        dddd(cc + 1, maxN);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> subList, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(subList));
        }else {
            helper(nums,index+1,subList,result);
            subList.add(nums[index]);
            helper(nums,index+1,subList,result);
            subList.remove(subList.size()-1);
        }
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public int minimumDifference(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= len - k; ++i) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }

    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int c = len - 2; c >= 2; --c) {
            map.put(nums[c + 1], map.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; ++a) {
                for (int b = a + 1; b < c; ++b) {
                    res += map.getOrDefault(nums[a] + nums[b] + nums[c], 0);
                }
            }
        }
        return res;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : hand) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!cnt.containsKey(x)) {
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int num = x + j;
                if (!cnt.containsKey(num)) {
                    return false;
                }
                cnt.put(num, cnt.get(num) - 1);
                if (cnt.get(num) == 0) {
                    cnt.remove(num);
                }
            }
        }
        return true;
    }

    public boolean checkPerfectNumber(int num) {
        int res = 0;
        for (int i = 1; i < num; ++i) {
            if (num % i == 0) {
                res += i;
            }
        }
        return res == num ? true : false;
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 1; i < len - 1; ++i) {
            if (nums[i] > nums[res]) {
                res = i;
            }
        }
        return res;
    }

    public String modifyString(String s) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        for (int i = 0; i < len; ++i) {
            if (ch[i] == '?') {
                for (char n = 'a'; n <= 'c'; ++n) {
                    if ((i > 0 && ch[i - 1] == n) || (i < len - 1 && ch[i + 1] == n)) {
                        continue;
                    }
                    ch[i] = n;
                    break;
                }
            }
        }
        return new String(ch);
    }

    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int res = nums[0];
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
            res = Math.min(nums[mid], res);
        }
        return res;
    }

    public String simplifyPath(String path) {
        String[] ch = path.split("/");
        Deque<String> de = new ArrayDeque<>();
        for (String str : ch) {
            if ("..".equals(str)) {
                if (!de.isEmpty()) {
                    de.pollLast();
                }
            } else if (!".".equals(str) && str.length() > 0) {
                de.offerLast(str);
            }
        }
        StringBuffer res = new StringBuffer();
        if (de.isEmpty()) {
            res.append("/");
        } else {
            while (!de.isEmpty()) {
                res.append("/");
                res.append(de.pollFirst());
            }
        }
        return res.toString();
    }

    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo(int n) {
        while (n != 0 && n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public int maxDepth(String s) {
        char[] ss = s.toCharArray();
        int res = 0, size = 0;
        for (int i = 0; i < ss.length; ++i) {
            if (ss[i] == '(') {
                ++size;
                res = Math.max(res, size);
            } else if (ss[i] == ')') {
                --size;
            }
        }
        return res;
    }

    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set<Integer> ss = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            ss.add(candyType[i]);
        }
        return Math.min(len / 2, ss.size());
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        int len = apples.length;
        int i = 0;
        while (i < len) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            int flDays = i + days[i];
            int count = apples[i];
            if (count > 0) {
                pq.offer(new int[]{flDays, count});
            }
            if (!pq.isEmpty()) {
                int[] aa = pq.peek();
                aa[1]--;
                if (aa[1] == 0) {
                    pq.poll();
                }
                ans++;
            }
            i++;
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[0] <= i) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] bb = pq.poll();
            int con = Math.min(bb[0] - i, bb[1]);
            ans += con;
            i += con;
        }
        return ans;
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        dddddd(list, 0, digits, map, new StringBuffer());
        return list;
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] te = text.split(" ");
        boolean firstB = false;
        boolean secondB = false;
        String res = "";
        for (int i = 0; i < te.length; ++i) {
            String str = te[i];
            boolean f = str.equals(first);
            if (!firstB) {
                if (f) {
                    firstB = true;
                }
            } else if (!secondB) {
                if (str.equals(second)) {
                    secondB = true;
                    continue;
                } else if (!f) {
                    firstB = false;
                }
            }
            if (secondB) {
                res += str + " ";
                if (!f) {
                    firstB = false;
                }
                if (first != second) {
                    secondB = false;
                }
            }
        }
        if (res == "") {
            return new String[0];
        }
        return res.split(" ");
    }

    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }

    public int dayOfYear(String date) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(8);
        set.add(10);
        set.add(12);
        String[] aa = date.split("-");
        int m = Integer.valueOf(aa[1]);
        int d = Integer.valueOf(aa[2]);
        int y = Integer.valueOf(aa[0]);
        int res = 0;
        if (m > 2) {
            for (int i = 1; i < m; ++i) {
                if (set.contains(i)) {
                    res += 31;
                } else {
                    if (i == 2) {
                        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                            res += 29;
                        } else {
                            res += 28;
                        }
                    } else {
                        res += 30;
                    }
                }
            }
            res += d;
        } else {
            return d + (m - 1) * 31;
        }
        return res;
    }

    public int repeatedStringMatch(String a, String b) {
        int l = (b.length() + a.length() - 1) / a.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++)
            sb.append(a);
        for (int i = 0; i <= sb.length() - b.length(); i++) {
            if (sb.substring(i, i + b.length()).equals(b))
                return l;
        }
        sb.append(a);
        for (int i = a.length() * l - b.length() + 1; i <= sb.length() - b.length(); i++)
            if (sb.substring(i, i + b.length()).equals(b))
                return l + 1;
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int mm = mid + 1;
                while (mm < len && nums[mm] == target) {
                    mm++;
                }
                res[1] = mm - 1;
                int nn = mid - 1;
                while (nn > 0 && nums[nn] == target) {
                    nn--;
                }
                res[0] = nn + 1;
                break;
            } else if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public void dddddd(List<String> list, int index, String digits, HashMap<String, String> map, StringBuffer str) {
        if (index == digits.length()) {
            list.add(str.toString());
            return;
        } else {
            char di = digits.charAt(index);
            String ss = map.get(String.valueOf(di));
            for (int i = 0; i < ss.length(); ++i) {
                str.append(ss.charAt(i));
                dddddd(list, index + 1, digits, map, str);
                str.deleteCharAt(index);
            }
        }
    }

    //    public int rob(int[] nums) {
//        int len = nums.length;
//        if (len==1){
//            return nums[0];
//        }else if (len==2){
//            return Math.max();
//        }
//
//    }
    public int maxPower(String s) {
        int ans = 1, cnt = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cnt;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int d = nums[0] - nums[1], t = 0, ans = 0;
        for (int i = 2; i < length; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                t++;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        String[] res = new String[n];
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        for (int j = 0; j < n; ++j) {
            if (j > 3) {
                res[arr[j][0]] = String.valueOf(Integer.valueOf(arr[j][1]) + 1);
            } else {
                res[arr[j][0]] = desc[arr[j][1]];
            }
        }
        return res;
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (k > 0) {
                if (nums[i] < 0) {
                    nums[i] = -nums[i];
                    k--;
                } else if (nums[i] == 0) {
                    k = 0;
                } else {
                    if (k % 2 != 0) {
                        if (i > 0 && nums[i] > nums[i - 1]) {
                            nums[i - 1] = -nums[i - 1];
                        } else {
                            nums[i] = -nums[i];
                        }

                    }
                    k = 0;
                }
            }
        }
        if (k > 0 && k % 2 != 0) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        sum = Arrays.stream(nums).sum();
        return sum;
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();
        int originalColor = grid[row][col];
        visited[row][col] = true;
        dfs(grid, row, col, visited, borders, originalColor);
        for (int i = 0; i < borders.size(); i++) {
            int x = borders.get(i)[0], y = borders.get(i)[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, List<int[]> borders, int originalColor) {
        int m = grid.length, n = grid[0].length;
        boolean isBorder = false;
        int[][] direc = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < 4; i++) {
            int nx = direc[i][0] + x, ny = direc[i][1] + y;
            if (!(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == originalColor)) {
                isBorder = true;
            } else if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(grid, nx, ny, visited, borders, originalColor);
            }
        }
        if (isBorder) {
            borders.add(new int[]{x, y});
        }
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int nn = n % 10;
            n = n / 10;
            sum += nn * nn;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> se = new HashSet<>();
        while (n != 1 && !se.contains(n)) {
            se.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, 1);
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }
        int re = 0;
        for (int ree : res) {
            re = Math.max(re, ree);
        }
        return re;
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

    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, right = matrix[0].length - 1;
        int lenY = matrix.length;
        for (int i = 0; i < lenY; ++i) {
            if (target <= matrix[i][right] && target >= matrix[i][l]) {
                while (l <= right) {
                    int mid = (l + right) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    }
                    if (matrix[i][mid] < target) {
                        l = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }

    public int search1(int[] nums, int target) {
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

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return ans;
    }


    //public int lengthOfLongestSubstring(String s) {
    //    HashMap<Character, Integer> map = new HashMap();
    //    int len = s.length();
    //    int left = 0, right = 0;
    //    int res = 0;
    //    while (right < len) {
    //        char ch = s.charAt(right);
    //        right++;
    //        map.put(ch, map.getOrDefault(ch, 0) + 1);
    //        while (map.get(ch) > 1) {
    //            char ch2 = s.charAt(left);
    //            map.put(ch2, map.getOrDefault(ch2, 1) - 1);
    //            left++;
    //        }
    //        res = Math.max(right - left, res);
    //    }
    //    return res;
    //}
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });
        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            for (int j = 0; j < Math.min(nums2.length, k); ++j) {
                if (queue.size() == k && nums1[i] + nums2[j] > queue.peek().get(0) + queue.peek().get(1)) {
                    break;
                }
                if (queue.size() == k) {
                    queue.poll();
                }
                List<Integer> re = new ArrayList<>();
                re.add(nums1[i]);
                re.add(nums2[j]);
                queue.offer(re);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < k && !queue.isEmpty(); ++i) {
            res.add(0, queue.poll());
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            char a = s.charAt(left);
            char b = s.charAt(right);
            if (!Character.isLetterOrDigit(a)) {
                left++;
            } else if (!Character.isLetterOrDigit(b)) {
                right--;
            } else {
                if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                    return false;
                }
                left++;
                right--;
            }

        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        for (; start < len; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }
        return start == len / 2 || isP(start + 1, end, s) || isP(start, end - 1, s);
    }

    public boolean isP(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }

    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; ++i) {
            count += count(s, i, i);
            count += count(s, i, i + 1);
        }
        return count;
    }

    public int count(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode first = head, second = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dump.next;
    }

    public int totalMoney(int n) {
        int week = 1, day = 1;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += week + day - 1;
            ++day;
            if (day == 8) {
                day = 1;
                ++week;
            }
        }
        return res;

    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            --cnt1[s2.charAt(i) - 'a'];
        }
        if (areAllZero(cnt1)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            --cnt1[s2.charAt(i) - 'a'];
            ++cnt1[s2.charAt(i - n) - 'a'];
            if (areAllZero(cnt1)) {
                return true;
            }
        }
        return false;
    }

    public boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = -1;
        int com = 0;
        int[] cot = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            cot[s.charAt(i)]++;
            if (cot[s.charAt(i)] == 2) {
                com++;
            }
            while (com > 0) {
                left++;
                cot[s.charAt(left)]--;
                if (cot[s.charAt(left)] == 1) {
                    com--;
                }
            }
            res = Math.max(res, i - left);
        }
        return res;
    }

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    int sum = 0;

    public int findTilt(MsTest.TreeNode root) {
        sum(root);
        return sum;
    }

    public int sum(MsTest.TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        sum += Math.abs(left - right);
        return left + right + node.val;
    }


    public int[] shuffle() {
        int[] shuffled = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
        }
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = random.nextInt(list.size());
            shuffled[i] = list.remove(j);
        }
        System.arraycopy(shuffled, 0, nums, 0, nums.length);
        return nums;
    }


    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; ++secondStart) {
            if (num.charAt(0) == '0' && secondStart != 1) {
                break;
            }
            for (int secondEnd = secondStart; secondEnd < n - 1; ++secondEnd) {
                if (num.charAt(secondStart) == '0' && secondStart != secondEnd) {
                    break;
                }
                if (valid(secondStart, secondEnd, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0, firstEnd = secondStart - 1;
        while (secondEnd <= n - 1) {
            String third = stringAdd(num, firstStart, firstEnd, secondStart, secondEnd);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart, thirdEnd + 1).equals(third)) {
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            int third = nums[i];
            if (third > second) {
                return true;
            } else if (third > first) {
                second = third;
            } else {
                first = third;
            }
        }
        return false;
    }

    public int minSub(int k, int[] nums) {
        int left = 0;
        int len = nums.length;
        int minPath = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < len; ++right) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                minPath = Math.min(minPath, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minPath == Integer.MAX_VALUE ? 0 : minPath;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int len = nums.length;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            if (sum - nums[i] == total - sum) {
                return i;
            }
        }
        return -1;
    }

    public int dominantIndex(int[] nums) {
        int max1 = -1, max2 = -1;
        int res = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
                res = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max1 >= 2 * max2 ? res : 1;
    }


    public String stringAdd(String s, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        StringBuffer third = new StringBuffer();
        int carry = 0, cur = 0;
        while (firstEnd >= firstStart || secondEnd >= secondStart || carry != 0) {
            cur = carry;
            if (firstEnd >= firstStart) {
                cur += s.charAt(firstEnd) - '0';
                --firstEnd;
            }
            if (secondEnd >= secondStart) {
                cur += s.charAt(secondEnd) - '0';
                --secondEnd;
            }
            carry = cur / 10;
            cur %= 10;
            third.append((char) (cur + '0'));
        }
        third.reverse();
        return third.toString();
    }


    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder str = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int bitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int bitB = j >= 0 ? a.charAt(j--) - '0' : 0;
            int sum = bitA + bitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            str.append(sum);
        }
        if (carry != 0) {
            str.append(carry);
        }
        return str.reverse().toString();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int c = nums[i];
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                List<Integer> re = new ArrayList<>();
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                int a = nums[left];
                int b = nums[right];
                if (sum == -c) {
                    re.add(nums[left]);
                    re.add(nums[right]);
                    re.add(c);
                    res.add(re);
                    while (left < right && nums[left] == a) {
                        left++;
                    }
                    while (left < right && nums[right] == b) {
                        right--;
                    }
                } else if (sum < -c) {
                    while (left < right && nums[left] == a) {
                        left++;
                    }
                } else {
                    while (left < right && nums[right] == b) {
                        right--;
                    }

                }

            }
        }
        return res;
    }


    List<List<Integer>> ree = new ArrayList<>();
    List<Integer> tt = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dddfs(false, 0, nums);
        return ree;
    }

    public void dddfs(boolean x, int cur, int[] nums) {
        if (cur == nums.length) {
            ree.add(new ArrayList<>(tt));
            return;
        }

        dddfs(false, cur + 1, nums);
        if (!x && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        tt.add(nums[cur]);
        dddfs(true, cur + 1, nums);
        tt.remove(tt.size() - 1);

    }

    public boolean validTicTacToe(String[] board) {
        int x = 0, y = 0;
        for (String str : board) {
            char[] ch = str.toCharArray();
            for (char c : ch) {
                x = (c == 'X') ? x + 1 : x;
                y = (c == 'O') ? y + 1 : y;
            }
        }
        if (x != y && x != y + 1) {
            return false;
        }
        if (win(board, 'X') && x != y + 1) {
            return false;
        }
        if (win(board, 'O') && x != y) {
            return false;
        }
        return true;
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
        }
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (int j = 0; j < licensePlate.length(); ++j) {
            char ch = licensePlate.charAt(j);
            if (Character.isLetter(ch)) {
                ++count[Character.toLowerCase(ch) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; ++i) {
            int[] c = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < count[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] mm = new int[m];
        int[] nn = new int[n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mm[i] = Math.max(grid[i][j], mm[i]);
                nn[j] = Math.max(grid[i][j], nn[j]);
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int count = Math.min(mm[i], nn[j]);
                int count1 = grid[i][j];
                if (count1 < count) {
                    res += count - count1;
                }
            }
        }
        return res;
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int dight = x % 10;
            x /= 10;
            res = res * 10 + dight;
        }
        return res;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                if (count[s.charAt(i) - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < goal.length(); ++i) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return (second != -1 && s.charAt(second) == goal.charAt(first) && s.charAt(first) == goal.charAt(second));
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        int count = 0;
        int l = grid.length;
        int r = grid[0].length;
        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < r; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    num(grid, i, j);
                }
            }
        }
        return count;
    }

    public void num(char[][] grid, int m, int n) {
        int mm = grid.length;
        int nn = grid[0].length;
        if (m < 0 || n < 0 || m >= mm || n >= nn || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        num(grid, m + 1, n);
        num(grid, m - 1, n);
        num(grid, m, n + 1);
        num(grid, m, n - 1);
    }

    public String originalDigits(String s) {
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (
                int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }

    public int findCircleNum(int[][] isConnected) {
        int lenth = isConnected.length;
        boolean[] vo = new boolean[lenth];
        int count = 0;
        for (int i = 0; i < lenth; ++i) {
            if (!vo[i]) {
                find(isConnected, lenth, vo, i);
                count++;
            }

        }
        return count;
    }

    public void find(int[][] isConnected, int lenth, boolean[] vo, int i) {
        for (int j = 0; j < lenth; ++j) {
            if (isConnected[i][j] == 1 && !vo[j]) {
                vo[j] = true;
                find(isConnected, lenth, vo, j);
            }
        }
    }

    public boolean isSubtree(MsTest.TreeNode root, MsTest.TreeNode subRoot) {
        return dd(root, subRoot);
    }

    public boolean dd(MsTest.TreeNode root, MsTest.TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || dd(root.left, subRoot) || dd(root.right, subRoot);
    }

    public boolean check(MsTest.TreeNode root, MsTest.TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }

    public MsTest.TreeNode searchBST(MsTest.TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        return searchBST(root.val < val ? root.right : root.left, val);
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        // 记录岛屿的最大面积
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹没岛屿，并更新最大岛屿面积
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return 0;
        }
        if (grid[i][j] == 0) {
            // 已经是海水了
            return 0;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0;

        return dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1) + 1;
    }

    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; --i) {
            for (int j = i + 1; j <= n; ++j) {
                int count = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    int cost = k + Math.max(f[k + 1][j], f[i][k - 1]);
                    count = Math.min(cost, count);
                }
                f[i][j] = count;
            }
        }
        return f[1][n];
    }

    public MsTest.ListNode middleNode(MsTest.ListNode head) {
        MsTest.ListNode low, fast;
        low = fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }

    public MsTest.TreeNode mergeTrees(MsTest.TreeNode root1, MsTest.TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        MsTest.TreeNode ma = new MsTest.TreeNode(root1.val + root2.val);
        ma.left = mergeTrees(root1.left, root2.left);
        ma.left = mergeTrees(root1.right, root2.right);
        return ma;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        con(root.left, root.right);
        return root;
    }

    public void con(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        con(node1.left, node1.right);
        con(node2.left, node2.right);
        con(node1.right, node2.left);
    }

    public String reverseWords(String s) {

        String[] ss = s.split(" ");
        int len = ss.length;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            char[] ch = ss[i].toCharArray();
            int left = 0;
            int right = ch.length - 1;
            while (left < right) {
                Character a = ch[left];
                ch[left] = ch[right];
                ch[right] = a;
                left++;
                right--;
            }
            str.append(ch);
            if (i != len - 1) {
                str.append(" ");
            }

        }
        return str.toString();
    }

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    public MsTest.ListNode mergeTwoLists(MsTest.ListNode l1, MsTest.ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode code = head;
        while (code != null) {
            ListNode next = code.next;
            code.next = prev;
            prev = code;
            code = next;
        }
        return prev;
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        boolean[] time = new boolean[1440];
        for (String str : timePoints) {
            String[] ss = str.split(":");
            int tm = Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
            if (time[tm]) {
                return 0;
            }
            time[tm] = true;
        }
        int minRes = time.length - 1;
        int prev = -1;
        int first = time.length - 1;
        int last = -1;
        for (int i = 0; i < 1440; ++i) {
            if (time[i]) {
                if (prev >= 0) {
                    minRes = Math.min(minRes, i - prev);
                }
                prev = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        minRes = Math.min(minRes, first + time.length - last);
        return minRes;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int num = s.pop() + s.pop();
                    s.push(num);
                    break;
                case "-":
                    int numF = s.pop();
                    int numL = s.pop();
                    int num1 = numL - numF;
                    s.push(num1);
                    break;
                case "*":
                    int num2 = s.pop() * s.pop();
                    s.push(num2);
                    break;
                case "/":
                    int numFi = s.pop();
                    int numLa = s.pop();
                    int num3 = numLa / numFi;
                    s.push(num3);
                    break;
                default:
                    s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0 || matrix[0].length() == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] heights = new int[matrix[0].length()];
        for (String str : matrix) {
            char[] row = str.toCharArray();
            for (int i = 0; i < row.length; ++i) {
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            queue1.offer(root);
        }
        int maxValue = Integer.MIN_VALUE;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            maxValue = Math.max(maxValue, node.val);
            if (node.left != null) {
                queue2.offer(node.left);
            }
            if (node.right != null) {
                queue2.offer(node.right);
            }
            if (queue1.isEmpty()) {
                res.add(maxValue);
                maxValue = Integer.MIN_VALUE;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return res;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    public int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    public int dfs(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int[] maxLeftSum = {Integer.MIN_VALUE};
        int left = dfs(node.left, maxLeftSum);
        int[] maxRightSum = {Integer.MIN_VALUE};
        int right = dfs(node.right, maxRightSum);
        maxSum[0] = Math.max(maxLeftSum[0], maxRightSum[0]);
        maxSum[0] = Math.max(maxSum[0], node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        Stack<TreeNode> ss = new Stack<>();
        while (cur != null || !ss.isEmpty()) {
            while (cur != null) {
                ss.push(cur);
                cur = cur.left;
            }
            cur = ss.pop();
            if (prev != null) {
                prev.right = cur;
            } else {
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }

    public TreeNode convertBST(TreeNode root) {
        TreeNode cur = root;
        int sum = 0;
        Stack<TreeNode> ss = new Stack<>();
        while (cur != null || !ss.isEmpty()) {
            while (cur != null) {
                ss.push(cur);
                cur = cur.right;
            }
            cur = ss.pop();
            sum += cur.val;
            cur.val = sum;
            cur = cur.left;
        }
        return root;
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> ee : queue) {
            res[i] = ee.getKey();
            i++;
        }
        return res;
    }

    public int numberOfMatches(int n) {
        int res = 0;
        while (n != 1) {
            int yu = n % 2;
            res += n / 2;
            n = n / 2 + yu;
        }
        return res;
    }

    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] f = new int[len];
        int[] q = new int[len];
        if (s.charAt(0) == '0') {
            f[0] = 0;
            q[0] = 1;
        } else {
            f[0] = 1;
            q[0] = 0;
        }
        for (int i = 1; i < len; ++i) {
            f[i] = f[i - 1] + s.charAt(i) == '0' ? 0 : 1;
            q[i] = Math.min(f[i - 1], q[i - 1]) + s.charAt(i) == '1' ? 0 : 1;
        }
        return Math.min(f[len - 1], q[len - 1]);
    }

    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(arr[i], i);
        }
        int res = 2;
        int[][] dp = new int[len][len];
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                int aa = arr[i] - arr[j];
                int index = map.getOrDefault(aa, -1);
                dp[i][j] = index > 0 && index < j ? dp[j][index] + 1 : 2;
                res = Math.max(dp[i][j], res);
            }
        }
        return res > 2 ? res : 0;
    }

    public int countValidWords(String sentence) {
        int res = 0;
        String[] ch = sentence.split(" ");
        for (String c : ch) {
            Pattern p = Pattern.compile("[a-z]*([a-z]-[a-z])?[a-z]*[!,.]?");
            if (p.matcher(c).matches()) {
                res++;
            }
        }
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= i; ++j) {
                dp[i][j] = triangle.get(i).get(j);
                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i > 0 && i == j) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int aa : dp[len - 1]) {
            res = Math.min(res, aa);
        }
        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int diff = (sum + target) / 2;
        int[][] dp = new int[len + 1][diff + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= diff; ++j) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][diff];
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        int maxV = 0;
        int res = 0;
        for (int[] pp : properties) {
            if (pp[1] < maxV) {
                res++;
            } else {
                maxV = pp[1];
            }
        }
        return res;
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        Pair[] pair = {new Pair(a, 'a'), new Pair(b, 'b'), new Pair(c, 'c')};
        while (true) {
            Arrays.sort(pair, (p1, p2) -> p2.feq - p1.feq);
            boolean hasnext = false;
            for (Pair pp : pair) {
                if (pp.feq <= 0) {
                    break;
                }
                int m = res.length();
                if (m >= 2 && pp.ch == res.charAt(m - 2) && res.charAt(m - 1) == pp.ch) {
                    continue;
                }
                hasnext = true;
                res.append(pp.ch);
                pp.feq--;
                break;
            }
            if (!hasnext) {
                break;
            }
        }
        return res.toString();
    }

    class Pair {
        int feq;
        char ch;

        public Pair(int aa, char bb) {
            this.feq = aa;
            this.ch = bb;
        }
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 && n == 0) {
            return 0;
        }
        int[][] mm = new int[m][n];
        int len = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int length = dfs(matrix, mm, i, j);
                len = Math.max(len, length);
            }
        }
        return len;
    }

    public int dfs(int[][] matrix, int[][] mm, int i, int j) {
        if (mm[i][j] != 0) {
            return mm[i][j];
        }
        int mL = matrix.length;
        int nL = matrix[0].length;
        int le = 0;
        int[][] dd = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] aa : dd) {
            int m = i + aa[0];
            int n = j + aa[1];
            if (m < mL && m > 0 && n < nL && n > 0 && matrix[i][j] < matrix[m][n]) {
                int len = dfs(matrix, mm, m, n);
                le = Math.max(le, len + 1);
            }
        }
        mm[i][j] = le;
        return le;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minCost(int[][] costs) {
        int len = costs.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[3][2];
        for (int j = 0; j < 3; ++j) {
            dp[j][0] = costs[0][j];
        }
        for (int i = 1; i < len; ++i) {
            for (int j = 0; j < 3; ++j) {
                int prev1 = dp[(j + 2) % 3][(i - 1) % 2];
                int prev2 = dp[(j + 1) % 3][(i - 1) % 2];
                dp[j][i % 2] = Math.min(prev1, prev2) + costs[i][j];
            }
        }
        int last = (len - 1) % 2;
        return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] cou = new int[2];
        cou[0] = nums[0];
        if (len > 1) {
            cou[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < len; ++i) {
            cou[i % 2] = Math.max(cou[(i - 1) % 2], cou[(i - 2) % 2] + nums[i]);
        }
        return cou[(len - 1) % 2];
    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] re = new int[len];
        re[0] = cost[0];
        re[1] = cost[1];
        for (int i = 2; i < len; ++i) {
            re[i] = Math.min(re[i - 1], re[i - 2]) + cost[i];
        }
        return Math.min(re[len - 1], re[len - 2]);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        helper(0, 0, s, "", "", res);
        return res;
    }

    public void helper(int i, int seg, String s, String seq, String ip, List<String> res) {
        if (i == s.length() && seg == 3 && isV(seq)) {
            res.add(ip + seq);
        } else if (seg <= 3 && i < s.length()) {
            char ch = s.charAt(i);
            if (isV(seq + ch)) {
                helper(i + 1, seg, s, seq + ch, ip, res);
            }
            if (seq.length() > 0 && seg < 3) {
                helper(i + 1, seg + 1, s, "" + ch, ip + seq + ".", res);
            }
        }
    }

    public boolean isV(String ss) {
        return Integer.valueOf(ss) <= 255 && (ss.equals("0") || ss.charAt(0) != '0');
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = split(head);
        head1 = sortList(head1);
        head2 = sortList(head2);
        return merge(head1, head2);
    }

    public ListNode split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dump.next;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int as : asteroids) {
            while (!s.isEmpty() && s.peek() > 0 && s.peek() < -as) {
                s.pop();
            }
            if (!s.isEmpty() && as < 0 && s.peek() == as) {
                s.peek();
            } else if (s.isEmpty() || as > 0 || s.peek() < 0) {
                s.push(as);
            }
        }
        return s.stream().mapToInt(i -> i).toArray();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> ss = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            while (!ss.isEmpty() && temperatures[ss.peek()] < temperatures[i]) {
                res[ss.peek()] = i - ss.pop();
            }
            ss.push(i);
        }
        return res;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ll1 = reverseList(l1);
        ListNode ll2 = reverseList(l2);
        int co = 0;
        ListNode prev = new ListNode(0);
        ListNode sumNode = prev;
        while (ll1 != null || ll2 != null) {
            int value = (ll1 == null ? 0 : ll1.val) + (ll2 == null ? 0 : ll2.val) + co;
            co = value >= 10 ? 1 : 0;
            value = value >= 10 ? value - 10 : value;
            sumNode.next = new ListNode(value);
            sumNode = sumNode.next;
            ll1 = ll1 == null ? null : ll1.next;
            ll2 = ll2 == null ? null : ll2.next;
        }
        if (co > 0) {
            sumNode.next = new ListNode(co);
        }
        return reverseList(sumNode.next);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        if (fast.next != null) {
            secondHalf = slow.next.next;
        }
        slow.next = null;
        return equals(slow, reverseList(secondHalf));
    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            head = newNode;
        } else if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
        } else {
            Node cur = head;
            Node next = head.next;
            Node biggest = head;
            while (!(cur.val <= newNode.val && next.val >= newNode.val) && next != head) {
                cur = next;
                next = next.next;
                if (cur.val >= biggest.val) {
                    biggest = cur;
                }
            }
            if (cur.val <= newNode.val && next.val >= newNode.val) {
                cur.next = newNode;
                newNode.next = next;
            } else {
                newNode.next = biggest.next;
                biggest.next = newNode;
            }

        }
        return head;
    }

    public boolean equals(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;

        }
        return l1 == null && l2 == null;
    }

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans1 = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfsCom(1, n, k);
        return ans1;
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        dnf(nums, list);
        return res;
    }

    public void dnf(int[] num, LinkedList<Integer> list) {
        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; ++i) {
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            dnf(num, list);
            list.removeLast();
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        for (Character c : s.toCharArray()) {
            int len = list.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < len; ++i) {
                    list.add(new StringBuilder(list.get(i)));
                    list.get(i).append(Character.toLowerCase(c));
                    list.get(len + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < len; ++i) {
                    list.get(i).append(c);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (StringBuilder aa : list) {
            res.add(aa.toString());
        }
        return res;
    }

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mark = new int[len];
        for (int i = 0; i < len; ++i) {
            String word = words[i];
            for (int j = 0; j < word.length(); ++j) {
                mark[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((mark[i] & mark[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public void dfsCom(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            ans1.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(cur);
        dfsCom(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfsCom(cur + 1, n, k);
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

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0) {
                left = i + 1;
                while (left < len - 1 && nums[left] == 0) {
                    left++;
                }
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
            }
        }
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int count = 1;
        int yu = 0;
        while (count != 0) {
            count = numBottles / numExchange;
            yu = numBottles % numExchange;
            res += count;
            numBottles = count + yu;
        }
        return res;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
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
            s[left] = s[right];
            s[right] = dmp;
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
