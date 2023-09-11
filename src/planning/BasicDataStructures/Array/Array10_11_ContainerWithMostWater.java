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
    public int maxArea2(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int ret=0;
        while(r>l){
            int h=0;
            if(height[r]>height[l]){
                h=height[l];
                ret=Math.max(ret,(r-l)*h);
                l++;
            }else if(height[r]<height[l]){
                h=height[r];
                ret=Math.max(ret,(r-l)*h);
                r--;
            }else{
                h=height[r];
                ret=Math.max(ret,(r-l)*h);
                l++;
                r--;
            }
        }
        return ret;
    }


}
