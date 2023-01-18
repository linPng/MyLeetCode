public class demo4 {
    //寻找两个正序数组的中位数
    //暴力枚举
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d=0,d2=0;
        int m=nums1.length;
        int n=nums2.length;
        for(int i=0;i<=(nums1.length+nums2.length)/2;i++){
            d2=d;
            if(m==0){d=nums2[nums2.length-n];n--;continue;}
            if(n==0){d=nums1[nums1.length-m];m--;continue;}
            if(nums1[nums1.length-m]<nums2[nums2.length-n]){
                d=nums1[nums1.length-m];
                m--;
            }else{
                d=nums2[nums2.length-n];
                n--;
            }
        }
        if ((nums1.length+nums2.length)%2==0) {
            d=((d+d2)/2);
        }
        return d;
    }
    public static void main(String[] args) {

    }
}
