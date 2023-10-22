package leetcode.HashTable;

/**
 * @author cuihongyuan
 * @Date: 2023/10/22 0022  - 18:03
 * @Description: leetcode.HashTable
 * @version: 1.0
 */

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class LC_383_赎金信 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(new LC_383_赎金信().canConstruct(ransomNote, magazine));
        System.out.println(new LC_383_赎金信().canConstruct1(ransomNote, magazine));

    }

    /**
     * 个人所写
     * 时间：3ms
     * 击败 42.37%使用 Java 的用户
     * 内存：41.28MB
     * 击败 91.73%使用 Java 的用户
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int num = 0;
        int[] ints = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ints[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < magazine.length(); i++) {
            ints[magazine.charAt(i) - 'a']++;
        }
        for (int nums : ints) {
            if (nums < 0) {
                num--;
            }
        }

        return num >= 0;
    }

    /**
     * 代码随想录版本，与自己的思路相同但是比我的代码更简洁和高效
     * 时间：1ms
     * 击败 99.78%使用 Java 的用户
     * 内存：41.33MB
     * 击败 87.99%使用 Java 的用户
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        // shortcut
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }
}
