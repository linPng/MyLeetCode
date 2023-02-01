public class demo189 {
    //轮转数组 中等
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(k==0){
            return;
        }
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            newArr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, nums.length);
    }
    //环状替换
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);//有最大公约数个环
        for (int start = 0; start < count; ++start) {
            int current = start;//当前下标
            int prev = nums[start];//当前数
            do {
                int next = (current + k) % n;//下一个下标
                int temp = nums[next];//缓存
                nums[next] = prev;//赋值给下一个
                prev = temp;//下标移到下一个
                current = next;
            } while (start != current);//是否回到起点
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
    public static void main(String[] args) {

    }
}
