package leetcode.meituan;

import java.util.Scanner;

/**
 * @author cuihongyuan
 * @Date: 2023/12/10 0010  - 18:40
 * @Description: leetcode.meituan
 * @version: 1.0
 */

/**
 * 美团2024届秋招笔试第一场编程真题
 *
 * 小美正在设计美团外卖的定价信息。已知外卖定价的规则如下：
 * 1. 每道菜有折扣价和原价。折扣价不能超过原价。
 * 2. 订单有满
 * �
 * x元减
 * �
 * y元的优惠。当购买的菜的价格总和不小于
 * �
 * x元时，总价格可以减
 * �
 * y元。“减”的价格不能超过“满”的价格。
 * 3. 满减优惠和折扣价是互斥的，当且仅当每个菜都选择了原价才可以触发满减。
 * 4. 系统会自动为客户计算最低价格的方案。
 *
 * 在设计定价时，原价、折扣价和满减的价格都必须是正实数。如果设计的定价发生问题，则会提示数据错误。
 * 请使用等价划分法设计测试用例，来测试该系统的功能。
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 256M，其他语言512M
 * 输入描述：
 * 第一行输入一个正整数n，代表菜的总数。
 * 接下来的n行，每行输入两个实数a_i和b_i，代表每道菜的原价是a_i，折扣价是b_i。
 * 最后一行输入两个实数x和y，代表满x元可以减y元。
 *
 * 1\leq n \leq 10^5
 * 数据中所有实数的绝对值不超过1000。
 * 输出描述：
 * 如果数据有误，则输出一行字符串"error"。
 * 否则输出一个小数，小数点后保留2位即可。该小数代表顾客购买了全部菜各一份时，订单的总价格。
 * 示例1
 * 输入例子：
 * 2
 * 10 5.5
 * 10 6.5
 * 15 3
 * 输出例子：
 * 12.00
 * 例子说明：
 * 虽然触发了满15元减3元，但使用折扣只需要花12元，低于使用满减的价格（20-3=17），因此最终系统会为客户推荐折扣价。
 * 示例2
 * 输入例子：
 * 2
 * 10 5.5
 * 10 6.5
 * 20 10
 * 输出例子：
 * 10.00
 * 例子说明：
 * 触发满20元减10元即可。满减价优于折扣价。
 * 示例3
 * 输入例子：
 * 2
 * 10 10.25
 * 10 3.5
 * 20 4.5
 * 输出例子：
 * error
 * 例子说明：
 * 折扣价高于原价，数据错误。
 */
public class 小美的外卖订单 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > 100000) {
            System.out.println("error");
            return;
        }

        double[] originalPrices = new double[n];
        double[] discountPrices = new double[n];

        for (int i = 0; i < n; ++i) {
            originalPrices[i] = scanner.nextDouble();
            discountPrices[i] = scanner.nextDouble();

            if (originalPrices[i] <= 0 || discountPrices[i] <= 0 || discountPrices[i] > originalPrices[i]) {
                System.out.println("error");
                return;
            }
        }

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        if (x <= 0 || y <= 0 || x < y) {
            System.out.println("error");
            return;
        }

        double totalOriginalPrice = 0.0;
        double totalDiscountPrice = 0.0;

        for (int i = 0; i < n; ++i) {
            totalOriginalPrice += originalPrices[i];
            totalDiscountPrice += discountPrices[i];
        }
        double v = totalOriginalPrice > x ? totalOriginalPrice - y : totalOriginalPrice;
        double minTotalPrice = Math.min(totalDiscountPrice, v);

        System.out.printf("%.2f%n", minTotalPrice);
    }
}
