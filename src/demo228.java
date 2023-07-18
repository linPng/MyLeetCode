import java.util.ArrayList;
import java.util.List;

public class demo228 {
    //汇总区间
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
    public List<String> summaryRanges2(int[] nums) {
        List<String> ret=new ArrayList<>();
        if(nums.length==0){
            return ret;
        }
        if(nums.length==1){
            ret.add(nums[0]+"");
            return ret;
        }
        int a=nums[0],b=nums[0],c;
        for(int i=1;i<nums.length;i++){
            c=nums[i];
            if(c==b+1){
                b=nums[i];
            }else{
                if(a!=b){
                    ret.add(a+"->"+b);
                }else{
                    ret.add(a+"");
                }
                a=nums[i];
                b=nums[i];
            }
        }
        if(a!=b){
            ret.add(a+"->"+b);
        }else{
            ret.add(a+"");
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}