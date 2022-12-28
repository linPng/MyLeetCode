import java.util.*;

public class demo49 {
    //字母异位词分组
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            map.getOrDefault(key,new ArrayList<>()).add(s);//省略containsKey
        }
        return new ArrayList<>(map.values());//map value 转list
    }
    public static void main(String[] args) {
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }

}