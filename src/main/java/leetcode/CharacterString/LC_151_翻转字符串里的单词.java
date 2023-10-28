package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/24 0024  - 18:50
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */

import java.util.Arrays;
import java.util.Collections;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 *
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 */
public class LC_151_翻转字符串里的单词 {

    public static void main(String[] args) {

        String s = "  hello world  ";
        System.out.println(new LC_151_翻转字符串里的单词().reverseWords(s));
        System.out.println(new LC_151_翻转字符串里的单词().reverseWords1(s));

    }

    public String reverseWords(String s) {
        //思路一: 使用 split和reverse
        String[] split = s.trim().split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ", split);
    }

    /**
       思路二: 一种没有用split 和reverse的方法[^1]
       分三步:
       先翻转整个数组
       再翻转单个单词
       清除多余空格
        */
    public String reverseWords1(String s) {
        if (s == null) {
            return null;
        }
        char[] s_arr = s.toCharArray();
        int n = s_arr.length;
        // 翻转这个数组
        reverse(s_arr, 0, n - 1);
        System.out.println(new String(s_arr));
        // 翻转每个单词
        word_reverse(s_arr, n);
        System.out.println(new String(s_arr));
        // 去除多余空格
        return clean_space(s_arr, n);
    }

    private void reverse(char[] s_arr, int i, int j) {
        while (i < j) {
            char t = s_arr[i];
            s_arr[i++] = s_arr[j];
            s_arr[j--] = t;
        }
    }

    private void word_reverse(char[] s_arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            // 找到第一个首字母
            while (i < n && s_arr[i] == ' ') {
                i++;
            }
            j = i;
            // 末位置
            while (j < n && s_arr[j] != ' ') {
                j++;
            }
            reverse(s_arr, i, j - 1);
            i = j;
        }
    }

    private String clean_space(char[] s_arr, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && s_arr[j] == ' ') {
                j++;
            }
            while (j < n && s_arr[j] != ' ') {
                s_arr[i++] = s_arr[j++];
            }
            while (j < n && s_arr[j] == ' ') {
                j++;
            }
            if (j < n) {
                s_arr[i++] = ' ';
            }
        }
        return new String(s_arr).substring(0, i);

    }
}
