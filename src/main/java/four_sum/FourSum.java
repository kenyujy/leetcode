package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {

        int[] nums = {-13, 11, 11, 0, -5, -14, 12, -11, -11, -14, -3, 0, -3, 12, -1, -9, -5, -13, 9, -7, -2, 9, -1, 4, -6, -13, -7, 10, 10, 9, 7, 13, 5, 4, -2, 7, 5, -13, 11, 10, -12, -14, -5, -8, 13, 2, -2, -14, 4, -8, -6, -13, 9, 8, 6, 10, 2, 6, 5, -10, 0, -11, -12, 12, 8, -7, -4, -9, -13, -7, 8, 12, -14, 10, -10, 14, -3, 3, -15, -14, 3, -14, 10, -11, 1, 1, 14, -11, 14, 4, -6, -1, 0, -11, -12, -14, -11, 0, 14, -9, 0, 7, -12, 1, -6};

        int[] nums2 = {1, 0, -1, 0, -2, 2, -3};
        int[] nums3 = {1, 0, -1, 0, -2, 2, -3};
        //List list = fourSum2(nums2, 0);
        //System.out.println(list);
        List list2 = fourSum(nums3, 0);
        System.out.println(list2);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++)
                    for (int m = k + 1; m < nums.length; m++) {
                        if (nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        }
                    }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Integer> list1 = list.get(i);//取出元素去重
                List<Integer> list2 = list.get(j);//取出元素去重
                Collections.sort(list1); //排序去重
                Collections.sort(list2); //排序去重
                if (list1.equals(list2)) {
                    if (!l2.contains(j))  //防止重复标记
                        l2.add(j);
                }
            }
        }
        Collections.sort(l2); //要把标记的重复序列排序，按顺序去除

        for (int i = 0; i < l2.size(); i++) {
            list.remove(l2.get(i) - i); //把标记重复的去掉,因为list重新排列，要去掉-i个
        }

        return list;
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        /*当数组为null或元素小于4个时，直接返回*/
        if (nums == null || nums.length < 4) {
            return result;
        }
        /*对数组进行从小到大排序*/
        Arrays.sort(nums);
        int length = nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for (int k = 0; k < length - 3; k++) {
            /*当k的值与前面的值相等时忽略*/
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }

            for (int i = k + 1; i < length - 2; i++) {
                /*当i的值与前面的值相等时忽略*/
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /*定义指针j指向i+1*/
                int j = i + 1;
                /*定义指针h指向数组末尾*/
                int h = length - 1;
                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略*/
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                if (min > target) {
                    continue;
                }
                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while (j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while (j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
