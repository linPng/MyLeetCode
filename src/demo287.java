import java.util.Arrays;

public class demo287 {
    //寻找重复数
    //经典快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    //错误  重复数可以不止一个
    public int findDuplicate2(int[] nums) {
        int n=nums.length-1;
        int sum= Arrays.stream(nums).sum();
        int t=n*(n+1)/2;
        return sum-t;
    }
    public static void main(String[] args) {

    }
}
