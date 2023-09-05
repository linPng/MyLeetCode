package planning.BasicDataStructures.Array;

public class Array10_11_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int ret=0;
        int l=0;
        int r=height.length-1;
        while(r>l){
            ret=Math.max(ret,(r-l)*Math.min(height[r],height[l]));
            if(height[r]<height[l]){
                r--;
            }else{
                l++;
            }
        }
        return ret;
    }



}
