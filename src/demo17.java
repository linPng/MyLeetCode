import java.util.ArrayList;
import java.util.List;

public class demo17 {
    //电话号码的字母组合 中等 模拟
    public List<String> letterCombinations(String digits) {
        List<String> r=new ArrayList();
        char[][] t={{'a','b','c'},{'d','e','f'}
                ,{'g','h','i'},{'j','k','l'}
                ,{'m','n','o'},{'p','q','r','s'}
                ,{'t','u','v'},{'w','x','y','z'}};;
        int l=digits.length();
        for(int i=0;i<l;i++){
            List<String> newlist=new ArrayList();
            int x=digits.charAt(i)-'0'-2;
            char[] c=t[x];
            for(int y=0;y<c.length;y++){
                List<String> temp=new ArrayList();
                char inchar=c[y];
                if(r.size()<1)temp.add(String.valueOf(inchar));
                for(String q:r){
                    temp.add(q+String.valueOf(inchar));
                }
                newlist.addAll(temp);
            }
            r=newlist;
        }
        return r;
    }
    public static void main(String[] args) {

    }
}