package leetcode.HashTable;

/**
 * @author cuihongyuan
 * @Date: 2023/10/20 0020  - 15:24
 * @Description: leetcode.HashTable
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class LC_349_两个数组的交集 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1, 2,2};
        int[] nums2 = {2,2};

        int[] intersection = new LC_349_两个数组的交集().intersection(nums1, nums2);
        int[] intersection2 = new LC_349_两个数组的交集().intersection2(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
        System.out.println(Arrays.toString(intersection2));

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)){
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组
//        int[] ints = resSet.stream().mapToInt(x -> x).toArray();
//        return ints;

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }

        return arr;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1001];
        int[] hash2 = new int[1001];

        for (int i : nums1) {
            hash1[i]++;
        }

        for (int i : nums2) {
            hash2[i]++;
        }

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 1001; i++) {
            if (hash1[i] > 0 && hash2[i] > 0) {
                integers.add(i);
            }
        }
        int[] ints = new int[integers.size()];
        int index = 0;
        for (int i : integers) {
            ints[index++] = i;
        }
        return ints;
    }
}
