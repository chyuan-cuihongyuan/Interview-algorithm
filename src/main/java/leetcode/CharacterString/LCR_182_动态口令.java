package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/28 0028  - 15:46
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */


import java.util.Arrays;

/**
 * 某公司门禁密码使用动态口令技术。初始密码为字符串 password，密码更新均遵循以下步骤：
 * 设定一个正整数目标值 target
 * 将 password 前 target 个字符按原顺序移动至字符串末尾
 * 请返回更新后的密码字符串。
 *
 * 示例 1：
 * 输入: password = "s3cur1tyC0d3", target = 4
 * 输出: "r1tyC0d3s3cu"
 *
 * 示例 2：
 * 输入: password = "lrloseumgh", target = 6
 * 输出: "umghlrlose"

 * 提示：
 * 1 <= target < password.length <= 10000
 */
public class LCR_182_动态口令 {
    public static void main(String[] args) {
        String password = "lrloseumgh";
        int target = 6;

        System.out.println(new LCR_182_动态口令().dynamicPassword(password, target));
        System.out.println(new LCR_182_动态口令().dynamicPassword1(password, target));
    }

    public String dynamicPassword(String password, int target) {

        String substring1 = password.substring(target, password.length());
        String substring = password.substring(0, target);
        char[] chars = password.toCharArray();
        int right = 0;

        for (char ch : substring1.toCharArray()) {
            chars[right++] = ch;
        }
        for (char ch : substring.toCharArray()) {
            chars[right++] = ch;
        }


        return String.valueOf(chars);
    }

    public String dynamicPassword1(String password, int target) {
        return password.substring(target) + password.substring(0, target);
    }
}
