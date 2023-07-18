import java.util.Arrays;

public class demo268 {
    //丢失的数字
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        int arrSum = Arrays.stream(nums).sum();
        return total - arrSum;
    }
    public static void main(String[] args) {

    }
}
