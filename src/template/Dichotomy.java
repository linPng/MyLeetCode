package template;

/**
 * @autthor LinP
 * @create 2023-07-31 9:55
 */
public class Dichotomy {
    //二分模版

    //二分法查找目标值
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1; // 目标值不存在
    }
    //寻找有序数组的上界
    public int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }

        }

        return left; // 返回上界下标
    }
    //寻找有序数组的下界
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left; // 返回下界下标
    }
}
