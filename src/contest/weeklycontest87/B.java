package contest.weeklycontest87;

public class B {
    //845. 数组中的最长山脉
    //经典动态规划
    public int longestMountain(int[] arr) {
        if(arr.length<3){
            return 0;
        }
        int ret=0,n=arr.length;
        int l[]=new int[n];
        int r[]=new int[n];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                l[i]=l[i-1]+1;
            }else{
                l[i]=0;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                r[i]=r[i+1]+1;
            }else{
                r[i]=0;
            }
        }
        for(int i=0;i<n;i++){
            if (l[i]!=0&&r[i]!=0) {
                ret=Math.max(ret,l[i]+r[i]+1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
