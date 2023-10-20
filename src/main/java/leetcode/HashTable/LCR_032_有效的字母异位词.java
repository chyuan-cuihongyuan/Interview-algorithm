package leetcode.HashTable;

/**
 * @author cuihongyuan
 * @Date: 2023/10/19 0019  - 17:01
 * @Description: leetcode.HashTable
 * @version: 1.0
 */

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 示例 3:
 * 输入: s = "a", t = "a"
 * 输出: false
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t 仅包含小写字母
 */
public class LCR_032_有效的字母异位词 {
    public static void main(String[] args) {
        LCR_032_有效的字母异位词 lcr_032_有效的字母异位词 = new LCR_032_有效的字母异位词();
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = lcr_032_有效的字母异位词.isAnagram(s, t);
        System.out.println(anagram);

    }


    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        if(s.equals(t)) {
            return false;
        }

        int[] recodes = new int[26];

        for (int i = 0; i < s.length(); i++) {
            recodes[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            recodes[t.charAt(i) - 'a']--;
        }

        for (int recode : recodes
        ) {
            if (recode != 0) {
                return false;
            }
        }
        return true;
    }
}
