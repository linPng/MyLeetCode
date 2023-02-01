import java.util.HashMap;
import java.util.Map;

public class demo2325 {
    //解密消息 模拟
    public static String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<key.length();i++){
            char c=key.charAt(i);
            if(c==' '){
                continue;
            }
            map.putIfAbsent(c,(char)('a'+map.size()));
        }
        StringBuilder sb=new StringBuilder();
        for(char c:message.toCharArray()){
            if(c==' '){
                sb.append(' ');
            }else{
                sb.append(map.getOrDefault(c,' '));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(" = " + decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"));
    }
}