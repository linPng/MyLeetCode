package contest.biweeklycontest111;

import java.util.List;

public class A {
    //2824. 统计和小于目标的下标对数目
    public int countPairs(List<Integer> nums, int target) {
        int n=nums.size();
        int ret=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums.get(i)+nums.get(j)<target){
                    ret++;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
