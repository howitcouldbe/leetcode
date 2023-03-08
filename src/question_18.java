import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
//  请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
//  （若两个四元组元素一一对应，则认为两个四元组重复）

//思路：固定两个指针，使用双指针
public class question_18 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        int target=1000000000;
        System.out.println(fourSum(nums,target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ArrayList<>();
        int tail;
        long time1 = System.currentTimeMillis();
        for(int head=0;head<nums.length-3;head++){
            if(head>0&&nums[head]==nums[head-1]) continue;
            for(tail=nums.length-1;tail>2;tail--){
                if(tail<nums.length-1 && nums[tail]==nums[tail+1]) continue;
                int mid_right = tail-1;
                for(int mid_left=head+1;mid_left<mid_right;mid_left++){
                    if(mid_left>head+1 && nums[mid_left]==nums[mid_left-1]) continue;
                    while(mid_left<mid_right && nums[head]+nums[mid_left]+nums[mid_right]+nums[tail]>target){
                        mid_right--;
                        while(mid_left<mid_right && mid_right<tail-1 && nums[mid_right]==nums[mid_right+1]) {
                            mid_right--;
                        }
                    }
                    if(mid_left == mid_right) break;
                    if(nums[head]/4+nums[mid_left]/4+nums[mid_right]/4+nums[tail]/4>Integer.MAX_VALUE/4) continue;
                    if(nums[head]/4+nums[mid_left]/4+nums[mid_right]/4+nums[tail]/4<Integer.MIN_VALUE/4) continue;
                    if(nums[head]+nums[mid_left]+nums[mid_right]+nums[tail]==target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[head]);
                        list.add(nums[mid_left]);
                        list.add(nums[mid_right]);
                        list.add(nums[tail]);
                        lists.add(list);
                    }
                }
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println((double)time2-(double)time1);
        return lists;
    }
}
