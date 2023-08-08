package contest.weeklycontest84;

import java.util.ArrayList;
import java.util.List;

public class B {
    //833. 字符串中的查找与替换
    //模拟
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[] ret=new int[s.length()];//默认0取自己，-1不取，1+i取targets
        for(int i=0;i<indices.length;i++){
            String sou=s.substring(indices[i],indices[i]+sources[i].length());
            System.out.println("sou = " + sou);
            if(sou.equals(sources[i])){
                ret[indices[i]]=i+1;
                for(int j=1;j<sources.length;j++){
                    ret[indices[i]+j]=-1;
                }

            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ret.length;i++){
            if(ret[i]==0){
                sb.append(s.charAt(i));
            }else if(ret[i]==-1){

            }else{
                sb.append(targets[ret[i]-1]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
