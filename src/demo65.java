public class demo65 {
    //有效数字 自动机
    public static boolean isNumber(String s) {
        //状态：-1.错误； 0.初始；1.符号位；2.整数位； 3.小数点位(左边有数字)；4.小数位；5.E符位； 6.E符号位；7.E整数位；8.小数点位(左边无数字)   9.结束
        //符号：0.符号+-；1.数字；2.小数点；3.Ee     4.结束
        int[][] t = new int[][]{{1,2,8,-1,-1},{-1,2,8,-1,-1},{-1,2,3,5,9}
                ,{-1,4,-1,5,9},{-1,4,-1,5,9},{6,7,-1,-1,-1}
                ,{-1,7,-1,-1,-1},{-1,7,-1,-1,9},{-1,4,-1,-1,-1}};
        char[] c=s.toCharArray();
        int state=0;
        for(char e:c){
            int ct=toCharType(e);
            if (ct==-1){
                return false;
            }
            state=t[state][ct];
            if(state==-1){
                return false;
            }
        }
        state=t[state][4];
        if(state==-1){
            return false;
        }
        return true;
    }
    public static int toCharType(char ch) {
        if (ch >= '0' && ch <= '9') {
            return 1;
        } else if (ch == 'e' || ch == 'E') {
            return 3;
        } else if (ch == '.') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 0;
        } else {
            return -1;
        }
    }

}