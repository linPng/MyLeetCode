import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo60 {
    //排列序列
    public static String getPermutation(int n, int k) {
        String r="";
        int N=factorial(n);//阶乘
        //生成数组转List
        List<Integer> l=new ArrayList<>(Arrays.asList(
                Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9}
                ).boxed().toArray(Integer[]::new)).subList(0,n));
        k=k-1;//转下标
        for(int i=0;i<n;i++){
            N=N/(n-i);
            int index=k/N;
            k=k%N;
            r+=String.valueOf(l.get(index));
            l.remove(index);
        }
        return r;
    }
    public static int factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        else {
            return number * factorial(number - 1);
        }
    }
    public static void main(String[] args) {

        System.out.println(" = " + getPermutation(3,3));
    }

}
