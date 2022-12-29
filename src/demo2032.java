import java.util.*;

public class demo2032 {
    //至少在两个数组中出现的值
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        //数组转set
        Set<Integer> set1=new HashSet<>(Arrays.asList(
                Arrays.stream(nums1
                ).boxed().toArray(Integer[]::new)));
        Set<Integer> set2=new HashSet<>(Arrays.asList(
                Arrays.stream(nums2
                ).boxed().toArray(Integer[]::new)));
        Set<Integer> set3=new HashSet<>(Arrays.asList(
                Arrays.stream(nums3
                ).boxed().toArray(Integer[]::new)));
        Set<Integer> r12=new HashSet<>();
        r12.addAll(set1);r12.retainAll(set2);//求差集
        Set<Integer> r13=new HashSet<>();
        r13.addAll(set1);r13.retainAll(set3);
        Set<Integer> r23=new HashSet<>();
        r23.addAll(set2);r23.retainAll(set3);
        Set<Integer> r=new HashSet<>();
        r.addAll(r12);
        r.addAll(r13);
        r.addAll(r23);
        List<Integer> l=new ArrayList<>(r);
        return l;
    }
    //hash
    public static List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            System.out.println("map.getOrDefault(i, 0) = " + map.getOrDefault(i, 0));
            System.out.println("(map.getOrDefault(i, 0) | 2) = " + (map.getOrDefault(i, 0) | 2));
            map.put(i, map.getOrDefault(i, 0) | 2);//|表示二进制或
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            if ((v & (v - 1)) != 0) {//v & (v - 1)解释 1.三个数组出现：111&110=110(√) 2.两个数组出现：110&101=100(√),101&100=100(√),011&010=010(√) 3.一个数组出现：100&011=000(×),010&001=000(×),001&000=000(×),
                res.add(k);
            }
        }
        return res;
    }
    public static void main(String[] args) {

        System.out.println(" = " + twoOutOfThree2(new int[]{1,2},new int[]{1,3},new int[]{2,3}));
    }

}