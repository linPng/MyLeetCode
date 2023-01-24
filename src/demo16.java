import java.util.Arrays;

public class demo16 {
    //最接近的三数之和 中等 排序双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int r=nums[0]+nums[1]+nums[2];
        if(r==target)return r;
        int a=0,b=0,c=nums.length-1;
        do{
            a=0;
            while(b<nums.length-2&&nums[b++]==nums[b]&&nums[b+1]!=nums[b]){};
            c=nums.length-1;
            do{
                int k=nums[a]+nums[b]+nums[c];
                if(k==target){
                    return target;
                }else if(k>target){
                    while(b<c&&nums[c--]==nums[c]){};
                }else{
                    while(a<b&&nums[a++]==nums[a]){};
                }
                if(Math.abs(k-target)<Math.abs(r-target)){
                    r=k;
                }
            }while(a<b&&b<c);

        }while(b<nums.length-2);
        return r;
    }
    public static void main(String[] args) {

    }
}