package contest.weeklycontest83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A {
    //较大分组的位置
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
    //需要优化
    public List<List<Integer>> largeGroupPositions2(String s) {
        int l=0;int r=0;char t=0;
        List ret = new ArrayList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t){
                r=i;
            }else{
                if((r-l)>=2){
                    List add = new ArrayList();
                    add.add(l);
                    add.add(r);
                    ret.add(add);
                }
                l=i;
                r=i;
            }
            t=s.charAt(i);
        }
        if((r-l)>=2){
            List add = new ArrayList();
            add.add(l);
            add.add(r);
            ret.add(add);
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
