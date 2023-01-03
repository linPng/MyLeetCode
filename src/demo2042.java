public class demo2042 {
    //检查句子中的数字是否递增
    public static boolean areNumbersAscending(String s) {
        int d=-1;
        for(String c:s.split(" ")){
            if(c.charAt(0)>='0'&&c.charAt(0)<='9'){//Character.isDigit(c.charAt(0))
                int i=Integer.valueOf(c);
                if(i<=d){
                    return false;
                }else{
                    d=i;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(" = " + areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

}
