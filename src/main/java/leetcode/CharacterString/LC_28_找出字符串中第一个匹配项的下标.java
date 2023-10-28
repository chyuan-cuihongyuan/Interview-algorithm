package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/28 0028  - 16:56
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class LC_28_找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";

        System.out.println(new LC_28_找出字符串中第一个匹配项的下标().strStr(haystack, needle));

    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (haystackLength < needleLength) {
            return -1;
        }
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needleLength).equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

}
