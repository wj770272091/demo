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

//        for (int i = 0; i < 10; ++i) {
//            Object obj = new Object();
//            System.out.println(obj.toString());
//        }
//
//        System.out.println("结束:" + new Date().getTime());
        subsets(new int[]{1, 2, 3});
    }

    public int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set<Integer> ss = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            ss.add(candyType[i]);
        }
        return Math.min(len / 2, ss.size());
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

    public void dddddd(List<String> list, int index, String digits, HashMap<String, String> map, StringBuffer str) {
        if (index == digits.length()) {
            list.add(str.toString());
            return;
        } else {
            char di = digits.charAt(index);
            String ss=map.get(String.valueOf(di));
            for (int i=0;i<ss.length();++i){
                str.append(ss.charAt(i));
                dddddd(list,index+1,digits,map,str);
                str.deleteCharAt(index);
            }
        }
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

    public MsTest.ListNode removeNthFromEnd(MsTest.ListNode head, int n) {
        MsTest.ListNode low = head, fast = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            low = low.next;
        }

        low.next = low.next.next;
        return head;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int len = s.length();
        int left = 0, right = 0;
        int res = 0;
        while (right < len) {
            char ch = s.charAt(right);
            right++;
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1) {
                char ch2 = s.charAt(left);
                map.put(ch2, map.getOrDefault(ch2, 1) - 1);
                left++;
            }
            res = Math.max(right - left, res);
        }
        return res;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
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

    int[] nums;
    int[] original;

    public void Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
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

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
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

    public MsTest.ListNode reverseList(MsTest.ListNode head) {
        MsTest.ListNode prev = null;
        MsTest.ListNode cuur = head;
        while (cuur != null) {
            MsTest.ListNode next = cuur.next;
            cuur.next = prev;
            prev = cuur;
            cuur = next;
        }
        return prev;
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
