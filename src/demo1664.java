public class demo1664 {
    //生成平衡数组的方案数
    public int waysToMakeFair(int[] nums) {
        int ret=0,a=0,b=0,c=0,d=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                c+=nums[i];
            }else{
                d+=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                c-=nums[i];
                if(a+d==b+c){
                    ret++;
                }
                a+=nums[i];
            }else{
                d-=nums[i];
                if(a+d==b+c){
                    ret++;
                }
                b+=nums[i];
            }
        }
        return ret;
    }
    //优化
    public int waysToMakeFair2(int[] nums) {
        int ret=0,s=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                s-=nums[i];
            }else{
                s+=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                s+=nums[i];
                if(s==0){
                    ret++;
                }
                s+=nums[i];
            }else{
                s-=nums[i];
                if(s==0){
                    ret++;
                }
                s-=nums[i];
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}