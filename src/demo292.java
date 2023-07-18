import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class demo292 {
    //Nim 游戏
    public boolean canWinNim(int n) {
        n=n%4;
        if(n==0){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
