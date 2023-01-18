import java.util.HashMap;
import java.util.Map;

public class demo6 {
    //Z 字形变换
    public String convert(String s, int numRows) {
        if(numRows==1||numRows>s.length()){
            return s;
        }
        Map<Integer,StringBuilder> map=new HashMap<Integer,StringBuilder>();//数组也可以
        int key=1;
        boolean down = true;
        StringBuilder r=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(key)){
                map.put(key,new StringBuilder());
            }
            map.get(key).append(s.charAt(i));
            if(key<numRows&&down){
                key++;
            }else if(key==numRows&&down){
                key--;
                down=!down;
            }else if(key>1&&!down){
                key--;
            }else if(key==1&&!down){
                key++;
                down=!down;
            }
        }
        for(int j=1;j<=numRows;j++){
            r.append(map.containsKey(j)?map.get(j):"");
        }
        return r.toString();
    }
    public static void main(String[] args) {

    }
}
