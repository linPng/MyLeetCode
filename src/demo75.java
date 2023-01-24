public class demo75 {
    //颜色分类 暴力
    public void sortColors(int[] nums) {
        int a=0,b=0,c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)a++;
            if(nums[i]==1)b++;
            if(nums[i]==2)c++;
        }
        int i=0;
        while(a>0){
            nums[i]=0;i++;a--;
        }
        while(b>0){
            nums[i]=1;i++;b--;
        }
        while(c>0){
            nums[i]=2;i++;c--;
        }
    }
    public static void main(String[] args) {

    }
}