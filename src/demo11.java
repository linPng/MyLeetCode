public class demo11 {
    //盛最多水的容器
    //边界收缩
    public int maxArea(int[] height) {
        int max=0;
        int l=0;
        int r=height.length-1;
        while(r>l){
            int t=(r-l)*Math.min(height[r],height[l]);
            if(t>max)max=t;
            if(height[r]>height[l]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
    public static void main(String[] args) {

    }
}