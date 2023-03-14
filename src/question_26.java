import java.util.Arrays;

//给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。

//思路：重复的用max值替代，最后重新排序，前面的自然就是未重复元素
public class question_26 {
    public static void main(String[] args) {
        //数组是开辟在堆
        int[] arr = {1,1,2,2,2,3,4,4,5};
        int k = removeDuplicates(arr);
        for(int i=0;i<k;i++){
            System.out.println(arr[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                index = i;
                count++;
            }else{
                nums[i] = 20000;
            }
        }
        Arrays.sort(nums);
        return count;
    }
}
