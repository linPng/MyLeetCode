import java.util.ArrayList;
import java.util.List;

public class demo68 {
    //文本左右对齐
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r=new ArrayList<>();
        List<String> t=new ArrayList<>();
        int i=0;
        int j=0;
        for(String s:words){
            i=i+s.length();
            if(i>maxWidth){
                StringBuilder sb=new StringBuilder();
                int b=maxWidth-j;
                if(t.size()==1){
                    sb.append(t.get(0));
                    while(b>0){sb.append(" ");b--;}
                }else{
                    int n=t.size()-1;
                    int x=b/n;
                    int y=b%n;
                    for(int a=0;a<n;a++){
                        sb.append(t.get(a));
                        b=a<y?x+1:x;
                        while(b>0){sb.append(" ");b--;}
                    }
                    sb.append(t.get(t.size()-1));
                }
                r.add(sb.toString());
                i=s.length();//保留这次加的字符串
                j=0;
                t=new ArrayList<>();
            }
            //不可跳过
            {
                j+=s.length();
                t.add(s);
                i++;
            }
        }
        StringBuilder sb=new StringBuilder();
        int n=t.size()-1;
        for(int a=0;a<n;a++){
            sb.append(t.get(a));
            sb.append(" ");
        }
        sb.append(t.get(t.size()-1));
        int b=maxWidth-sb.length();
        while(b>0){sb.append(" ");b--;}
        r.add(sb.toString());
        return r;
    }
    public static void main(String[] args) {
        /*["What","must","be","acknowledgment","shall","be"]
16
"This", "is", "an", "example", "of", "text", "justification."
*/
        System.out.println(" = " + fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
    }

}