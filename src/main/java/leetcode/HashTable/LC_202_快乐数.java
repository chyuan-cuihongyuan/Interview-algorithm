package leetcode.HashTable;

/**
 * @author cuihongyuan
 * @Date: 2023/10/20 0020  - 16:39
 * @Description: leetcode.HashTable
 * @version: 1.0
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class LC_202_快乐数 {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(new LC_202_快乐数().isHappy(n));
        System.out.println(new LC_202_快乐数().isHappy2(n));

    }

    /**
     * 递归算法
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int num;
        int sum = 0;
        while (n > 0) {
            num = n % 10;
            n = n / 10;
            sum = sum + num * num;
        }

        if (sum == 1) {
            return true;
        }else if (sum == 4) { // 非快乐数的终止条件，因为4会进入无限循环
            return false;
        } else {
            return isHappy(sum);
        }

    }

    /**
     * hashset只要出现相同的数就证明出现无线循环所以不是快乐数
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private int getNextNumber(int n){
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
