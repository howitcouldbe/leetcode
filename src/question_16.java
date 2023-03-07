//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//返回这三个数的和。
//假定每组输入只存在恰好一个解。

//思路:最先想到的是中间变量min用来保存target与三个整数的差值，通过更新min的值来找到那三个整数，之后就是如何遍历的问题
//同样的通过双指针来试试

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question_16 {
    public static void main(String[] args) {
        int[]  nums = {1,1,1,1};
        int target = 0;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int head=0;head<nums.length-2;head++){
            int mid = head+1,tail =nums.length-1;
            while(mid<tail){
                if(Math.abs(target-nums[head]-nums[mid]-nums[tail])<min) {
                    min = Math.abs(target - nums[head] - nums[mid] - nums[tail]);
                    sum = nums[head] + nums[mid] + nums[tail];
                }
                if(mid>head+1 && nums[mid] == nums[mid-1]){
                    mid++;
                    continue;
                }else if(tail<nums.length-1 && nums[tail]==nums[tail+1]){
                    tail--;
                    continue;
                }
                if(target-nums[head]-nums[mid]-nums[tail]>0){
                    mid++;
                }else if(target-nums[head]-nums[mid]-nums[tail]<0){
                    tail--;
                }else if(target-nums[head]-nums[mid]-nums[tail] == 0){
                    return nums[head]+nums[mid]+nums[tail];
                }
            }
        }
        return sum;
    }
}

