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

    public int trailingZeroes(int n) {
        int res = 0;
        int count = 5;
        while (n > count) {
            res += n / count;
            count *= 5;
        }
        return res;
    }

    public int chalkReplacer(int[] chalk, int k) {
        int res = 0;
        int num = 0;
        while (k >= 0) {
            k -= chalk[num];
            num++;
            if (num >= chalk.length) {
                num = 0;
            }
            res = num;
        }
        return res == 0 ? chalk.length - 1 : res - 1;
    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int dist = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                int mm = m.getValue();
                ans += mm * (mm - 1);
            }
        }
        return ans;
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String str : dictionary) {
            int i = 0, j = 0;
            while (i < str.length() && j < s.length()) {
                if (str.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == str.length()) {
                if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & (1 >> i)) != 0) {
                res++;
            }
        }
        return res;
    }

    public int findPeakElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {

                map.put(nums[i], i);
            }
        }
        Arrays.sort(nums);
        return map.get(nums[nums.length - 1]);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            int totalSum = 0;
            while (n > 0) {
                int d = n % 10;
                n = n / 10;
                totalSum += d * d;
            }
            n = totalSum;
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int[] pp = new int[n];
        Arrays.fill(pp, 1);
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (pp[i] == 1) {
                count++;
                if (i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        pp[j] = 0;
                    }
                }

            }
        }
        return count;
    }

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); ++i) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }

        }
        return true;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            ret.add(temp.toString());
        }
        return ret;
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

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        bl(root, "", paths);
        return paths;
    }

    public void bl(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuffer str = new StringBuffer(path);
        if (root.left == null && root.right == null) {
            paths.add(path);
        } else {
            str.append(root.val);
            str.append("->");
            bl(root.left, str.toString(), paths);
            bl(root.right, str.toString(), paths);
        }
    }

    public int addDigits(int num) {
        while (num > 10) {
            int res = num % 10;
            int res2 = num / 10;
            num = res + res2;
        }
        return num;
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] ff = new int[]{2, 3, 5};
        for (int i = 0; i < ff.length; ++i) {
            while (n % ff[i] == 0) {
                n /= ff[i];
            }
        }
        return n == 1;
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3) {
            return true;
        }
        while (n > 0) {
            if (n % 3 != 0) {
                return false;
            } else if (n / 3 == 3) {
                return true;
            }
            n /= 3;
        }
        return false;
    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < length; ++i) {
            if (nums[i] != i) {
                return i;
            }
        }
        return length;
    }

    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i < bits.length; ++i) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length, left = 0, right = 0;
        while (right < length) {
            if (nums[right] != 0) {
                int num = nums[right];
                nums[right] = nums[left];
                nums[left] = num;
                left++;
            }
            right++;
        }
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public int titleToNumber(String columnTitle) {
        int num = 0;
        int ascii = 1;
        for (int i = columnTitle.length() - 1; i >= 0; --i) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            num += k * ascii;
            ascii *= 26;
        }
        return num;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node res = head;
        dgFlatten(res, res.next);
        return res;
    }

    public void dgFlatten(Node node, Node next) {
        if (node == null) {
            return;
        }
        if (node.child != null) {
            node.next = node.child;
            dgFlatten(node.next, next);
        } else {
            node = node.next;
        }
        dgFlatten(node, node.next);

    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length;
        while (left < right) {
            char next = s[right];
            s[right] = s[left];
            s[left] = next;
            left++;
            right--;
        }
    }

    public String reverseVowels(String s) {
        String yuan = "aeiouAEIOU";
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;
        while (left < right) {
            while (left < c.length && yuan.indexOf(c[left]) < 0) {
                left++;
            }
            while (right > 0 && yuan.indexOf(c[right]) < 0) {
                right--;
            }
            if (left < right) {
                Character next = c[left];
                c[left] = c[right];
                c[right] = next;
                left++;
                right--;
            }
        }
        StringBuffer str = new StringBuffer();
        for (Character cc : c) {
            str.append(cc);
        }
        return str.toString();
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int car = (a & b) >> 1;
            a = a ^ b;
            b = car;
        }
        return a;
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= length; ++i) {
            dp[i] = Math.min((cost[i - 1] + dp[i - 1]), (cost[i - 2] + dp[i - 2]));
        }
        return dp[length];
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[length - 1];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; ++i) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[length];
    }

    public int rob2(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(ro(nums, 0, length - 2), ro(nums, 1, length - 1));
    }

    public int ro(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; ++i) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public int deleteAndEarn(int[] nums) {
        int length = nums.length;
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        return deleteEarn(sum);
    }

    public int deleteEarn(int[] nums) {
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean count = true;
        while (!que.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = que.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = que.poll();
                if (count) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            res.add(new LinkedList<>(list));
            count = !count;
        }
        return res;
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 0; i < len; ++i) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return sum;
    }


    public static int maxSubarraySumCircular(int[] A) {
        int N = A.length;

        int ans = A[0], cur = A[0];
        for (int i = 1; i < N; ++i) {
            cur = A[i] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }

        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2

        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        int[] rightsums = new int[N];
        rightsums[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            rightsums[i] = rightsums[i + 1] + A[i];
        }

        // maxright[i] = max_{j >= i} rightsums[j]
        int[] maxright = new int[N];
        maxright[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; --i) {
            maxright[i] = Math.max(maxright[i + 1], rightsums[i]);
        }

        int leftsum = 0;
        for (int i = 0; i < N - 2; ++i) {
            leftsum += A[i];
            ans = Math.max(ans, leftsum + maxright[i + 2]);
        }

        return ans;
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums, 0, maxF, 0, len);
        System.arraycopy(nums, 0, minF, 0, len);
        for (int i = 1; i < len; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < len; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    public int getMaxLen(int[] nums) {
        int length = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else if (nums[i] < 0) {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            } else {
                positive = 0;
                negative = 0;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }

    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int max = values[0] + 0;
        int df = 0;
        for (int i = 1; i < len; ++i) {
            df = Math.max(df, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return df;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1=nums1.length;
        int len2=nums2.length;
        int[] inster=new int[len1+len2];
        int index=0,index1=0,index2=0;
        while (index1<len1&&index2<len2){
            int num1=nums1[index1],num2=nums2[index2];
            if (num1==num2){
                if (index==0||inster[index-1]!=num1){
                    inster[index++]=num1;
                }
                index1++;
                index2++;
            }else if (num1<num2){
                index1++;
            }else {
                index2++;
            }
        }
        return Arrays.copyOfRange(inster, 0, index);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode node1L = node1.left, node2L = node2.left, node1R = node1.right, node2R = node2.right;
            if (node1L == null ^ node2L == null) {
                return false;
            }
            if (node2R == null ^ node1R == null) {
                return false;
            }
            if (node1L != null) {
                q1.offer(node1L);
            }
            if (node2L != null) {
                q2.offer(node2L);
            }
            if (node1R != null) {
                q1.offer(node1R);
            }
            if (node2R != null) {
                q2.offer(node2R);
            }
        }
        return q1.isEmpty() && q2.isEmpty();
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
                    num = num.substring(0, j) + num.substring(j + 1);
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
            num = num.substring(start);
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

