public class demo6283 {
    //正整数和负整数的最大计数
    //暴力解
    public static int maximumCount(int[] nums) {
        int ret=0,f=0,z=0,n=0;
        for(int e:nums){
            if(e<0){
                f++;
            }else
            if(e==0){
                z++;
            }else
            if(e>0){
                n=nums.length-f-z;
                break;
            }
        }
        return f>n?f:n;
    }
    public static void main(String[] args) {
        System.out.println(" = " + maximumCount(new int[]{-3,-2,-1,0,0,1,2}));
    }

}