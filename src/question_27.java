import java.util.Arrays;

//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

//思路：与上一题差不多，但换双指针做，每次找到需要移除的元素，直接将其和最后一个元素对换位置，最后一个指针前移，前指针不动；若前指针的元素不是，则移动前指针；直到前后指针相同，再判断当前是否需要删除。
public class question_27 {
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int k = removeElement(arr,3);
        for(int i=0;i<k;i++){
            System.out.println(arr[i]);
        }
    }
    public static int removeElement(int[] nums, int val) {
        int j = nums.length-1;
        int tmp;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(i==j && nums[i] != val){
                count++;
                break;
            } else if (i==j && nums[i] == val) {
                break;
            }
            if(nums[i]==val){
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j--;i--;
            }else {
                count++;
            }
            System.out.println(Arrays.toString(nums));
        }
        return count;
    }
}
