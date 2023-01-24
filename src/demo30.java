import java.util.ArrayList;
import java.util.List;

public class demo30 {
    //串联所有单词的子串 困难
    //暴力
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> r=new ArrayList<Integer>();
        int l=words.length*words[0].length();
        int d=words[0].length();
        int w=words.length;
        for(int i=0;i<=s.length()-l;i++){
            String t="";
            for(int a=0;a<words.length;a++){
                t=t+s.substring(i+a*d,i+d+a*d)+"#";
            }
            boolean f=true;
            for(String e : words){
                int eindex =t.indexOf(e);
                if(eindex==-1){
                    f=false;
                    break;
                }else{
                    t=t.substring(0,eindex)+t.substring(eindex+d+1,t.length());
                }
            }
            if(f){
                r.add(i);
            }
        }

        return r;
    }
    public static void main(String[] args) {

    }
}