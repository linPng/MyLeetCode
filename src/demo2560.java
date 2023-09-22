import java.util.Arrays;

public class demo2560 {
    //2560. 打家劫舍 IV
    //经典最小化最大值 -》 二分
    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();//最小值
        int upper = Arrays.stream(nums).max().getAsInt();//最大值
        while (lower <= upper) {
            System.out.println("upper = " + upper);
            System.out.println("lower = " + lower);
            int middle = (lower + upper) / 2;
            System.out.println("middle = " + middle);
            int count = 0;
            boolean visited = false;//避免连续
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {//
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 9, 3, 1};
        demo2560 d = new demo2560();
        System.out.println("d = " + d.minCapability(array,2));

    }
}
