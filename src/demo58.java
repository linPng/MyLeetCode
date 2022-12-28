public class demo58 {
    //最后一个单词的长度
    public static int lengthOfLastWord(String s) {
        String[] ss=s.trim().split(" ");
        return ss[ss.length-1].length();
    }
    public static void main(String[] args) {

        System.out.println("=== = " + lengthOfLastWord("   fly me   to   the moon       "));
    }

}
