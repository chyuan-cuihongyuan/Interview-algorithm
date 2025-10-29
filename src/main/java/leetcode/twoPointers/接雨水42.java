package leetcode.twoPointers;

/**
 * @ClassName: 接雨水42
 * @Author: cuihongyuan chyuan.cn @chyuan
 * @Date: 2025/10/29 15:04
 * @Version: 1.0
 * @Description: leetcode.twoPointers
 */

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
 提示：
 n == height.length
 1 <= n <= 2 * 10⁴
 0 <= height[i] <= 10⁵
 Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5943 👎 0*/

/*
*
* 1. 栈解法
*
* public int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;

    for (int i = 0; i < height.length; i++) {
        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
            int bottom = stack.pop();
            if (stack.isEmpty()) break;

            int left = stack.peek();
            int width = i - left - 1;
            int h = Math.min(height[left], height[i]) - height[bottom];
            result += width * h;
        }
        stack.push(i);
    }

    return result;
}
* 核心思想：
使用 Stack 存储柱子索引，维护一个单调递减的栈
当遇到更高的柱子 height[i] 时，弹出栈顶元素作为凹槽底部
计算由当前柱子、栈顶柱子和弹出柱子形成的凹槽能接的雨水量
关键步骤：
遍历每个柱子索引 i
当 height[i] > height[stack.peek()] 时，形成凹槽
弹出栈顶作为底部，若栈为空则无法形成凹槽
新栈顶为左边界，当前索引为右边界
雨水量 = (右边界-左边界-1) × (min(左高,右高)-底高)
2. 数组解法（动态规划预处理）
* public int trap(int[] height) {
    if (height.length == 0) return 0;

    int n = height.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    // 预处理每个位置左侧最大值
    leftMax[0] = height[0];
    for (int i = 1; i < n; i++) {
        leftMax[i] = Math.max(leftMax[i-1], height[i]);
    }

    // 预处理每个位置右侧最大值
    rightMax[n-1] = height[n-1];
    for (int i = n-2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i+1], height[i]);
    }

    // 计算每个位置能接的雨水
    int result = 0;
    for (int i = 0; i < n; i++) {
        result += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return result;
}
核心思想：
预处理得到每个位置左侧最大高度 leftMax 和右侧最大高度 rightMax
每个位置能接的雨水量等于该位置左右两侧最大高度的较小值减去当前位置高度
关键步骤：
从左到右计算 leftMax 数组
从右到左计算 rightMax 数组
每个位置雨水量 = Math.min(leftMax[i], rightMax[i]) - height[i]
累加所有位置的雨水量
3. 双指针解法
* public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int result = 0;

    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                result += leftMax - height[left];
            }
            left++;
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                result += rightMax - height[right];
            }
            right--;
        }
    }

    return result;
}
核心思想：
使用双指针 left 和 right 分别从数组两端向中间移动
同时维护左侧最大值 leftMax 和右侧最大值 rightMax
根据较矮一侧的柱子计算雨水量
关键步骤：
比较 height[left] 和 height[right]
若左侧较矮，则根据 leftMax 计算雨水量
若右侧较矮，则根据 rightMax 计算雨水量
移动较矮一侧的指针，重复过程
4. 动态规划解法
*public int trap(int[] height) {
    if (height.length == 0) return 0;

    int n = height.length;
    int[] dp = new int[n];
    int leftMax = height[0];

    // 从左到右计算每个位置能接的雨水
    for (int i = 1; i < n; i++) {
        if (height[i] >= leftMax) {
            leftMax = height[i];
            dp[i] = dp[i-1];
        } else {
            dp[i] = dp[i-1] + leftMax - height[i];
        }
    }

    return dp[n-1];
}
 核心思想：
使用动态规划，dp[i] 表示前 i+1 个柱子能接的雨水总量
从左到右遍历，维护左侧最大值 leftMax
根据当前位置是否能形成凹槽更新状态
关键步骤：
dp[0] = 0，第一个柱子无法接雨水
若 height[i] >= leftMax，更新最大值，雨水量不变
若 height[i] < leftMax，累加雨水量 leftMax - height[i]
返回 dp[n-1] 即为总雨水量
5. 单调栈解法
* public int trap(int[] height) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;

    for (int i = 0; i < height.length; i++) {
        // 维护单调递减栈
        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
            int bottomIndex = stack.pop();

            // 如果栈为空，无法形成凹槽
            if (stack.isEmpty()) break;

            // 计算凹槽能接的雨水
            int width = i - stack.peek() - 1;
            int h = Math.min(height[i], height[stack.peek()]) - height[bottomIndex];
            result += width * h;
        }
        stack.push(i);
    }

    return result;
}

*/
public class 接雨水42 {
}
