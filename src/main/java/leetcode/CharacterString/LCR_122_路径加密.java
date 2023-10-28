package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/24 0024  - 18:31
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */

/**
 * 假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。
 *
 * 示例 1：
 * 输入：path = "a.aef.qerf.bb"
 * 输出："a aef qerf bb"
 *
 * 限制：
 * 0 <= path.length <= 10000
 */
public class LCR_122_路径加密 {
    public static void main(String[] args) {

        String path = "a.aef.qerf.bb";
        System.out.println(new LCR_122_路径加密().pathEncryption(path));

    }

    public String pathEncryption(String path) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '.') {
                stringBuffer.append(" ");
                continue;
            }
            stringBuffer.append(path.charAt(i));
        }
        return stringBuffer.toString();
    }
}
