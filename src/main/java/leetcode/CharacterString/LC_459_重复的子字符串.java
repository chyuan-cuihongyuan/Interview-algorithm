package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/29 0029  - 10:54
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 *
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class LC_459_重复的子字符串 {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(new LC_459_重复的子字符串().repeatedSubstringPattern(s));
        System.out.println(new LC_459_重复的子字符串().repeatedSubstringPattern1(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        String substring = str.substring(1, str.length() - 1);
        boolean contains = substring.contains(s);
        return contains;
//        return str.substring(1, str.length() - 1).contains(s);

    }

    public boolean repeatedSubstringPattern1(String s) {
        if (s.equals("")) {
            return false;
        }

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            // 更新 next 数组的值
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}
