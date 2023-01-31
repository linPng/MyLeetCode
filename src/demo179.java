import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class demo179 {
    //最大数
    public static String largestNumber(int[] nums) {
        //int数组转包装类
        Integer[] Ints = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        //自定义数组排序
        Arrays.sort(Ints, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return (String.valueOf(i2)+String.valueOf(i1)).compareTo((String.valueOf(i1)+String.valueOf(i2)));
            }
        });
        if(Ints[0]==0){
            return "0";
        }
        //合并字符串
        String ret=Arrays.stream(Ints).map(String::valueOf).collect(Collectors.joining()).replaceAll("^(0+)","0");
        return ret;
    }
    public static void main(String[] args) {
        System.out.println("args = " + largestNumber(new int[]{0,0}));
        System.out.println("args = " + largestNumber(new int[]{999999991,9}));
        System.out.println("args = " + largestNumber(new int[]{3,30,34,5,9}));
    }
}
