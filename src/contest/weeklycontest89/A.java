package contest.weeklycontest89;

public class A {
    //852. 山脉数组的峰顶索引 二分找峰值 二分模板 峰值模板
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,r=arr.length-1;
        while (l<r){
            int m=(l+r)/2;
            if(arr[m]<arr[m+1]){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }

    public static void main(String[] args) {

    }
}
