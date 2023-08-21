import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class demo2815 {
    //2815. 数组中的最大数对和
    //可以优化为一次遍历，每次只要记录最大数字最大的那个数
    public int maxSum(int[] nums) {
        List[] lists= new List[10];
        for(int i=0;i<10;i++){
            lists[i]=new LinkedList();
        }
        for(int i:nums){
            String s=String.valueOf(i);
            int max=0;
            for(char c:s.toCharArray()){
                if(c-'0'>max){
                    max=c-'0';
                }
            }
            lists[max].add(i);
        }
        int ret=-1;
        for(int i=1;i<10;i++){
            if(lists[i].size()<2){
                continue;
            }
            Collections.sort(lists[i]);
            int t =lists[i].size();
            int c=(int)lists[i].get(t-1)+(int)lists[i].get(t-2);
            if(c>ret){
                ret=c;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
