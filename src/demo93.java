import java.util.*;
import java.util.stream.Collectors;

public class demo93 {
    //复原 IP 地址
    //回溯算法
    public static List<String> restoreIpAddresses(String s) {
        List<String> r=new ArrayList<>();
        List<String> t=new ArrayList<>();
        f(s,r,t);
        return r;
    }
    public static void f(String s,List<String> r,List<String> t){
        if(t.size()==4&&s.length()==0){
            //List转String
            r.add(t.stream().map(String::valueOf).collect(Collectors.joining(".")));
            return;
        }
        if(t.size()==4&&s.length()>0){
            return;
        }
        int n=s.length()>2?3:s.length();
        for(int i=1;i<=n;i++){
            String d=s.substring(0,i);
            if(d.length()>1&&s.startsWith("0")){
                continue;
            }
            if(d.length()>2&&d.compareTo("255")>0){
                continue;
            }
            t.add(d);
            f(s.substring(i),  r, t);
            t.remove(t.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(" = " + restoreIpAddresses("101023"));
    }

}