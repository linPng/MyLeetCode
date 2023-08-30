package planning.BasicDataStructures.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @autthor LinP
 * @create 2023-08-24 11:10
 */
public class Array04_941_ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int l=0;
        int r=arr.length-1;
        while(l<arr.length-1){
            if(arr[l+1]>arr[l]){
                l++;
            }else{
                break;
            }
        }
        while(r>0){
            if(arr[r-1]>arr[r]){
                r--;
            }else{
                break;
            }
        }
        if(l==r&&l!=0&&r!=arr.length-1){
            return true;
        }
        return false;
    }
}
