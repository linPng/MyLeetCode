package planning.BasicDataStructures.Array;

/**
 * @autthor LinP
 * @create 2023-08-18 11:10
 */
public class Array02_88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m>0||n>0){
            if(m==0){
                nums1[m+n-1]=nums2[n-1];
                n--;
            }else if(n==0){
                return;
            }else{
                if(nums1[m-1]>nums2[n-1]){
                    nums1[m+n-1]=nums1[m-1];
                    m--;
                }else{
                    nums1[m+n-1]=nums2[n-1];
                    n--;
                }
            }
        }
    }
}
