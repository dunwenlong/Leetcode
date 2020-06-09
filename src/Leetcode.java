import com.sun.source.tree.Tree;

import java.util.*;

public class Leetcode {
    public static int[] constructArr(int[] A) {
        int lenA = A.length;
        if (lenA == 1) {
            int[] B = {1};
            return B;
        }
        int[] B = new int[lenA];
        int temp = 1;
        B[0] = 1;
        for (int i = 1; i < lenA; i++) {
            temp *= A[i - 1];
            B[i] = temp;
        }
        int[] C = new int[lenA];
        C[lenA - 1] = 1;
        temp = 1;
        for (int i = lenA - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args) {
//        int [][] testData = {{1,2,3},{4,5,6},{7,8,9}};
//        for(int v: Leetcode.spiralOrder(testData)) {
//            System.out.println(v);
//        }
//        System.out.println(Leetcode.minArray(testData));
//        System.out.println(Leetcode.nthUglyNumber(10));
        System.out.println(Leetcode.translateNum(12258));
//        String str = "abcdefg";
//        System.out.println("截取最后一个字符串生成的新字符串为: " + str.substring(0,str.length()));
    }

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }

    public static int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        int mid = (l + r) / 2;
        while (l < r) {
            if (numbers[mid] < numbers[r]) {
                r = mid;
                mid = (l + r) / 2;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
                mid = (l + r) / 2;
            } else {
                r--;
                mid = (l + r) / 2;
            }
        }
        return numbers[l];
    }

    public static int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int r = cols - 1;
        int d = rows - 1;
        int l = 0;
        int t = 0;
        int x = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > d) {
                break;
            }
            for (int i = t; i <= d; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[d][i];
            }
            if (t > --d) {
                break;
            }
            for (int i = d; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }

        }
        return res;
    }

    public static int rob(int[] nums) {
        int lenNums = nums.length;
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[lenNums];
        for (int i = 0; i < lenNums; i++) {
            if (i == 0) {
                ;
                dp[i] = nums[i];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[i], nums[i - 1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[lenNums - 1];
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows < 1) {
            return false;
        }
        int columns = matrix[0].length;
        int i = 0;
        int j = columns - 1;
        while (i < rows && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public int sumNums(int n) {
        boolean x = (n > 1) && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                counts[j] += (nums[i] & 1);
                nums[i] = nums[i] >>> 1;
            }
        }
        int m = 3;
        int res = 0;
        for (int j = 0; j < 32; j++) {
            counts[j] = counts[j] % m;
        }
        int x = 2;
        int mask = 0;
        for (int j = 0; j < 32; j++) {
            res <<= 1;
            res |= counts[31 - j];
        }
        return res;
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (temp == dp[p2] * 2) {
                p2++;
            }
            if (temp == dp[p3] * 3) {
                p3++;
            }
            if (temp == dp[p5] * 5) {
                p5++;
            }
            dp[i] = temp;
        }
        return dp[n - 1];
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//    LinkedList<TreeNode> nodeQueue = new LinkedList<>();
//    public int[] levelOrder(TreeNode root) {
//        if(root == null){
//            return new int[0];
//        }
//        ArrayList<Integer> resList = new ArrayList<>();
//        nodeQueue.addLast(root);
//        while (!nodeQueue.isEmpty()){
//            LinkedList<TreeNode> tempQueue = new LinkedList<>();
//            while (!nodeQueue.isEmpty()){
//                TreeNode tempNode = nodeQueue.removeFirst();
//                resList.add(tempNode.val);
//                if(tempNode.left!=null){
//                    tempQueue.addLast(tempNode.left);
//                }
//                if(tempNode.right!=null){
//                    tempQueue.add(tempNode.right);
//                }
//            }
//            nodeQueue = tempQueue;
//        }
//        int[] res = new int[resList.size()];
//        for(int i=0; i<resList.size();i++){
//            res[i] = resList.get(i);
//        }
//        return res;
//    }

    LinkedList<TreeNode> nodeQueue = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        boolean isLeft2Right = true;
        nodeQueue.addLast(root);
        while (!nodeQueue.isEmpty()) {
            LinkedList<TreeNode> tempQueue = new LinkedList<>();
            LinkedList<Integer> tempList = new LinkedList<>();
            while (!nodeQueue.isEmpty()) {
                TreeNode tempNode = nodeQueue.removeFirst();
                if (isLeft2Right) {
                    tempList.addLast(tempNode.val);
                } else {
                    tempList.addFirst(tempNode.val);
                }
                if (tempNode.left != null) {
                    tempQueue.addLast(tempNode.left);
                }
                if (tempNode.right != null) {
                    tempQueue.add(tempNode.right);
                }
            }
            resList.add(tempList);
            isLeft2Right = !isLeft2Right;
            nodeQueue = tempQueue;
        }
        return resList;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> helpStack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            helpStack.push(pushed[i]);
            while (!helpStack.isEmpty() && helpStack.peek() == popped[j]) {
                helpStack.pop();
                j++;
            }
        }
        return helpStack.isEmpty();

    }
    //判断后序遍历是否为二叉搜索树
    public boolean verifyPostorder(int[] postorder) {
        return inVerify(postorder, 0, postorder.length-1);
    }
    public boolean inVerify(int[] postorder, int i, int j){
        if(i >= j){
            return true;
        }
        int c = i;
        int rootVal = postorder[j];
        while (postorder[c]<rootVal){
            c++;
        }
        int m = c;
        while (postorder[c]>rootVal){
            c++;
        }
        return c==j&&inVerify(postorder,i,m-1)&&inVerify(postorder,m,j-1);
    }
    public static int translateNum(int num) {
        String st = String.valueOf(num);
        int len = st.length();
        int[] dp = new int[len];
        for(int i=0; i<len; i++){
            if(i==0){
                dp[i] = 1;
                continue;
            }
            if(i==1){
                int temp = Integer.valueOf(st.substring(0,2));
                if(10<temp&&temp<=25){
                    dp[i] = 2;
                } else{
                    dp[i] = 1;
                }
                continue;
            }
            int temp = Integer.valueOf(st.substring(i-1,i+1));
            if(temp>10 && temp<=25){
                dp[i] = dp[i-1] + dp[i-2];
            } else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len-1];
    }
    public static int countDigitOne(int n){
        int high = n/10;
        int low = 0;
        int cur = n%10;
        int res = 0;
        int digit = 1;
        while (high>0 || cur>0){
            if(cur == 0) {
                res += high * digit;
            } else if(cur == 1){
                res += high*digit+low+1;
            } else{
                res += (high+1)*digit;
            }
            low = low+cur*digit;
            cur = high%10;
            high = high/10;
            digit = digit*10;
        }
        return res;
    }
}

