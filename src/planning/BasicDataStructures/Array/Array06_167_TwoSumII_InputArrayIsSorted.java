package planning.BasicDataStructures.Array;

/**
 * @autthor LinP
 * @create 2023-08-25 11:10
 */
public class Array06_167_TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret=new int[2];
        int n=numbers.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(numbers[i]+numbers[j]==target){
                    ret=new int[]{i+1,j+1};
                }
            }
        }
        return ret;
    }
}
