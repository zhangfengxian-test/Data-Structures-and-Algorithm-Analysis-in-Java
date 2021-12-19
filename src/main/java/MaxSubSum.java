/**
 * 最大子序列和问题
 */
public class MaxSubSum {

    /**
     * 分治法求解
     * 时间复杂度：O(N logN)
     */
    public static int maxSubSum3(int[] a) {
        return maxSumRec(a, 0, a.length - 1);
    }

    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right) {
            return a[left] > 0 ? a[left] : 0;
        }

        int mid = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, mid);
        int maxRightSum = maxSumRec(a, mid + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = mid; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum,
            maxLeftBorderSum + maxRightBorderSum);
    }

    private static int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    /**
     * 线性时间的求和算法
     */
    public static int maxSubSum4(int[] a) {
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubSum4(new int[] {4, -3, 5, -2, -1, 2, 6, -2}));
    }

}
