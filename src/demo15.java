import java.util.*;

public class demo15 {
    //三数之和 中等 排序双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r=new ArrayList<>();
        Set<String> s=new HashSet<>();
        for(int b=1;b<nums.length-1;b++){
            int a=0,c=nums.length-1;
            if(nums[a]+nums[b]>0)break;
            //if(nums[b]+nums[c]<0)break;
            do{
                if(nums[a]+nums[b]+nums[c]==0){
                    String key=String.valueOf(nums[a])+String.valueOf(nums[b])+String.valueOf(nums[c]);
                    if(!s.contains(key)){
                        r.add(Arrays.asList(nums[a], nums[b], nums[c]));
                        s.add(key);
                    }
                    while(c>=2&&nums[c--]==nums[c]){}
                    while(a<=nums.length-2&&nums[a++]==nums[a]){}
                }else if(nums[a]+nums[b]+nums[c]>0){
                    while(c>=2&&nums[c--]==nums[c]){}
                }else{
                    while(a<=nums.length-2&&nums[a++]==nums[a]){}
                }
                if(nums[a]+nums[b]>0)break;
                if(nums[b]+nums[c]<0)break;
            }while(a<b&&b<c);
        }
        return r;
    }
    public static void main(String[] args) {

    }
}