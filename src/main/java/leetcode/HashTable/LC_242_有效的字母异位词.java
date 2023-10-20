package leetcode.HashTable;

/**
 * @author cuihongyuan
 * @Date: 2023/10/19 0019  - 16:37
 * @Description: leetcode.HashTable
 * @version: 1.0
 */

/**
 * 242.有效的字母异位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class LC_242_有效的字母异位词 {

    public static void main(String[] args) {
        LC_242_有效的字母异位词 lc242_有效的字母异位词 = new LC_242_有效的字母异位词();
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = lc242_有效的字母异位词.isAnagram(s, t);
        System.out.println(anagram);

    }


    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
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
