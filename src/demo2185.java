public class demo2185 {
    //统计包含给定前缀的字符串
    public static int prefixCount(String[] words, String pref) {
        int ret=0;
        for (String e:words) {
            if (e.startsWith(pref))ret++;
        }
        return ret;
    }
    public static void main(String[] args) {
        System.out.println(" = " + prefixCount(new String[]{"pay","attention","practice","attend"},"at"));
    }

}