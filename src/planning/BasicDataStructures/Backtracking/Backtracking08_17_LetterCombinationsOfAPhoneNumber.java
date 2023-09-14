package planning.BasicDataStructures.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking08_17_LetterCombinationsOfAPhoneNumber {

    String[][] str = {{""},{""},{"a","b","c"},{"d","e","f"}
            ,{"g","h","i"}
            ,{"j","k","l"}
            ,{"m","n","o"}
            ,{"p","q","r","s"}
            ,{"t","u","v"}
            ,{"w","x","y","z"}};
    public List<String> letterCombinations(String digits) {
        List<String> ret=new ArrayList<>();
        if(digits.length()==0){
            return ret;
        }
        if(digits.length()==1){
            for(String s:str[Integer.valueOf(digits)]){
                ret.add(s);
            }
            return ret;
        }
        List<String> per=letterCombinations(digits.substring(0,digits.length()-1));
        for(String st:per){
            for(String s:str[Integer.valueOf(String.valueOf(digits.charAt(digits.length()-1)))]){
                ret.add(st+s);
            }
        }
        return ret;
    }

}
