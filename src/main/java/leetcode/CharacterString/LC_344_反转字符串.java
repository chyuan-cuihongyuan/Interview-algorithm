package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/23 0023  - 9:14
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */
public class LC_344_反转字符串 {

    public static void main(String[] args) {
        LC_344_反转字符串 lc_344_反转字符串 = new LC_344_反转字符串();
        char[] s = {'H','a','n','n','a','h'};
        lc_344_反转字符串.reverseString(s);
        System.out.println("反转后为字符串为");
        for (char num : s) {
            System.out.print(num + "  ");
        }
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (right > left) {
            char temp;
            temp =  s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
