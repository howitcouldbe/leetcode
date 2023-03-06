import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
// 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

//思路:最直接的就是三个循环，然后想到先排序再双指针
public class question_15 {
    public static void main(String[] args) {
        int[] nums = {0,1,1};
        System.out.println(threeSum(nums));
//        threeSum(nums);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> lists = new ArrayList<>();
        int tail=nums.length-1;
        for(int head=0;head<tail;head++){
            //相同的就不必遍历了
            if(head>0 && nums[head] == nums[head-1])
                continue;
            tail = nums.length-1;
            for(int i= head+1; i<tail;i++){
                //相同的就不必遍历了
                if(i>head+1 && nums[i]==nums[i-1]) {
                    continue;
                }
                //右指针不能一步一步走，要直接走到走不了为止，因为一步一步走会丢失掉一部分数据
                while(i<tail && nums[head]+nums[tail]+nums[i]>0){
                    tail--;
                }
                if(i == tail)
                    break;
                if(nums[head]+nums[tail]+nums[i] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[head]);
                    list.add(nums[i]);
                    list.add(nums[tail]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
