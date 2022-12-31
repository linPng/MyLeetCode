import java.util.ArrayDeque;
import java.util.Deque;

public class demo71 {
    //简化路径
    public static String simplifyPath(String path) {
        Deque<String> d = new ArrayDeque<>();
        for(String s:path.split("/")){
            if(!s.equals(".")&&!s.equals("")){
                if(s.equals("..")){
                    d.pollLast();
                }else{
                    d.add(s);
                }
            }
        }
        String r="";
        for(String s:d){
            r=r+"/"+s;
        }
        if(d.size()==0){
            r="/";
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(" = " + simplifyPath("/a/./b/../../c/"));
    }

}