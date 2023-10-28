package leetcode.CharacterString;

/**
 * @author cuihongyuan
 * @Date: 2023/10/24 0024  - 17:29
 * @Description: leetcode.CharacterString
 * @version: 1.0
 */

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 */
public class LC_541_反转字符串II {

    public static void main(String[] args) {
        String s = "sdhioasdhioashjdashdoiasdnasodhasilkdfjmsdkljas";
        int k = 4;

        System.out.println(new LC_541_反转字符串II().reverseStr(s, k));
        System.out.println("-----------------------------");
        System.out.println(new LC_541_反转字符串II().reverseStr1(s, k));
        System.out.println("-----------------------------");
        System.out.println(new LC_541_反转字符串II().reverseStr2(s, k));
        System.out.println("-----------------------------");
        System.out.println(new LC_541_反转字符串II().reverseStr3(s, k));
        System.out.println("-----------------------------");

    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int l = s.length();
        for(int i = 0; i < l; i += 2*k){
            reverseString(chars, i, Math.min(i+k , l) - 1);
        }
        return new String(chars);
    }

    private void reverseString(char[] s,int left, int right){
        char temp;
        while(left<right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    //代码随想录解法一
    public String reverseStr1(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuffer temp = new StringBuffer();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) {
                //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();
    }

    //解法二（似乎更容易理解点）
    //题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }

    // 解法二还可以用temp来交换数值，会的人更多些
    public String reverseStr3(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
