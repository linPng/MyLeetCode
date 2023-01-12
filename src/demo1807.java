import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo1807 {
    //替换字符串中的括号内容

    //stringbuild 提高效率
    public static String evaluate(String s, List<List<String>> knowledge) {
        Map map = new HashMap<>();
        for(List l:knowledge){
            map.put(l.get(0),l.get(1));
        }
        StringBuilder ret=new StringBuilder();
        StringBuilder key=new StringBuilder();
        boolean isKey=false;
        for(char c: s.toCharArray()){
            if(c=='('){
                isKey=true;
                key=new StringBuilder();
            }else if(c==')'){
                isKey=false;
                ret.append(map.getOrDefault(key.toString(),"?"));
            }else{
                if(isKey){
                    key.append(c);
                }else{
                    ret.append(c);
                }
            }
        }
        return ret.toString();
    }

    //substring效率低超时
    public static String evaluate2(String s, List<List<String>> knowledge) {
        Map map = new HashMap<>();
        for(List l:knowledge){
            map.put(l.get(0),l.get(1));
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int j=i+1;
                for(;j<s.length();j++){
                    if(s.charAt(j)==')'){
                        break;
                    }
                }
                String key=s.substring(i+1,j);
                System.out.println("key = " + key);
                String value=(String) map.getOrDefault(key,"?");
                s=s.substring(0,i)+value+s.substring(j+1);
                System.out.println("s = " + s);
            }
        }
        return s;
    }
    public static void main(String[] args) {
        List<List<String>>  list =new ArrayList();

        System.out.println(" = " + evaluate("(name)is(age)yearsold",list));
    }

}