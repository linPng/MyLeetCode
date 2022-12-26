import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {



        Map<Integer[],Integer[]> map=new HashMap<>();

        map.put(new Integer[]{1,2},new Integer[]{1,2,3});

        System.out.println(map.containsKey(new Integer[]{1,2}));


        String s="123456789";
        s.toCharArray();
        int i =5;
        String str=s.substring(0,i)+s.substring(s.length()-(6-i),s.length());
        System.out.println("str = " + str);
        /*
        *
        * ["xrezzxgdvg","bcgx","wcfzmfosr"]
["qyouhus","ukou","eirhfbt","qciw","for"]
["bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw",
* "bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw","xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr","for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt","loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg","rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx","bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg","bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr"
* ,"qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"]
[686276715,934288178,625397331,519945877,864052244,971253305,512505036,865635090,281613863]
9
        * */
        /*Integer[] boxedArray = {1, 2, 3, 4};
        int[] primitiveArray =
                Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();

        String a="adb",b="abc",ss=" 123 321 ",s1=" 123 ";
        s1.toCharArray()
        int w=ss.indexOf(s1);
        String[] q=new String[]{"xrezzxgdvg","bcgx","wcfzmfosr"};
        String[] q2=new String[]{"qyouhus","ukou","eirhfbt","qciw","for"};

        String[] q3=new String[]{"bcgx bcgx eirhfbt kvcrym bcgx cxzs eirhfbt wcfzmfosr v qciw","bcgx xrezzxgdvg bcgx xrezzxgdvg wcfzmfosr chap qyouhus biyt wcfzmfosr qciw","xrezzxgdvg wcfzmfosr ukou qcr clnj xrezzxgdvg gvtkvb qciw hi wcfzmfosr","for for mnxpqrdth bcgx bcgx qciw wcfzmfosr lspvgjvk wcfzmfosr eirhfbt","loxyg bcgx jwdesdu xrezzxgdvg wcfzmfosr rrych qyouhus wcfzmfosr klcwo xrezzxgdvg","rvbd wcfzmfosr lj xrezzxgdvg xuwguhgyyy fuz eirhfbt ukou h bcgx","bcgx wpmxyvbhc for qciw wcfzmfosr wjdm qyouhus qciw for xrezzxgdvg","bcgx sj xrezzxgdvg yjoklk bcgx hpc xrezzxgdvg lqfrvk xrezzxgdvg wcfzmfosr","qc wcfzmfosr jkjpgjalc tm v wcfzmfosr orgsqjzwa wcfzmfosr hh bfnxcx"};
        int[] q4=new int[]{686276715,934288178,625397331,519945877,864052244,971253305,512505036,865635090,281613863};
        System.out.println("topStudents() = " + topStudents(q,q2,q3,q4,9));*/

//        Arrays.asList(q4).subList(0,k);

    }
    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> set1 =new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> set2 =new HashSet<>(Arrays.asList(negative_feedback));
        int[] student_num=new int[student_id.length];
        for(int i=0;i<report.length;i++){
            int num=0;
            for(String e:report[i].split(" ")){
                if(set1.contains(e))num+=3;
                if(set2.contains(e))num-=1;
            }
            student_num[i]=num;
            System.out.println("student_num[i] = " + student_num[i]);
            System.out.println("student_id[i] = " + student_id[i]);
            int j=i-1;
            while(j>=0&&(student_num[j+1]>student_num[j]||(student_num[j+1]==student_num[j]&&student_id[j+1]<student_id[j]))){
                int temp=student_num[j];
                student_num[j]=student_num[j+1];
                student_num[j+1]=temp;
                temp=student_id[j];
                student_id[j]=student_id[j+1];
                student_id[j+1]=temp;
                j--;
            }
        }

        for(int i =0;i<student_num.length;i++){
            System.out.println("student_num = " + student_num[i]);
            System.out.println("student_id = " + student_id[i]);
            System.out.println(" = ");
        }

        return Arrays.asList(Arrays.stream(student_id).boxed().toArray(Integer[]::new)).subList(0,k);
    }
    public static List<Integer> topStudents2(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        int[] student_num=new int[student_id.length];
        for(int i=0;i<student_id.length;i++){
            int num=0;
            String ss=" "+report[i]+" ";
            for(String s:positive_feedback){
                String s1=" "+s+" ";
                int w=ss.indexOf(s1);
                while(w>-1){
                    num+=3;
                    ss=ss.substring(0,w)+ss.substring(w+s1.length()-1,ss.length());
                    w=ss.indexOf(s1);
                }
            }
            for(String s:negative_feedback){
                String s1=" "+s+" ";
                int w=ss.indexOf(s1);
                while(w>-1){
                    num-=1;
                    ss=ss.substring(0,w)+ss.substring(w+s1.length()-1,ss.length());
                    w=ss.indexOf(s1);
                }
            }
            student_num[i]=num;
            System.out.println("student_num[i] = " + student_num[i]);
            System.out.println("student_id[i] = " + student_id[i]);
            for(int j=i-1;j>=0;j--){
                if(student_num[j+1]>student_num[j]){
                    int tmep=student_num[j];
                    student_num[j]=student_num[j+1];
                    student_num[j+1]=tmep;

                    tmep=student_id[j];
                    student_id[j]=student_id[j+1];
                    student_id[j+1]=tmep;
                }
            }
        }
        List<Integer> r=new ArrayList<>();
        for(int i=0;i<k;i++){
            r.add(student_id[i]);
        }
        return r;
    }
    public static int search(int[] nums, int target) {
        int n=nums.length,l=0,r=n-1,m=(l+r)/2;
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[l]<=nums[m]){
                if(nums[l]<=target&&target<=nums[m]){
                    r=m-1;
                }else{
                    l=m+1;
                    m=l;
                }
            }else{
                if(nums[m]<=target&&target<=nums[r]){
                    l=m+1;
                    m=l;
                }else{
                    r=m-1;
                }
            }
        }
        return m;

    }
    public static List<String> letterCombinations(String digits) {
        List<String> r=new ArrayList();
        char[][] t={{'a','b','c'},{'d','e','f'}
                ,{'g','h','i'},{'j','k','l'}
                ,{'m','n','o'},{'p','q','r','s'}
                ,{'t','u','v'},{'w','x','y','z'}};;
        int l=digits.length();
        for(int i=0;i<l;i++){
            List<String> newlist=new ArrayList();
            int x=digits.charAt(i)-'0'-2;
            char[] c=t[x];
            for(int y=0;y<c.length;y++){
                List<String> temp=new ArrayList();
                char inchar=c[y];
                if(r.size()<1)temp.add(String.valueOf(inchar));
                for(String q:r){
                    temp.add(q+inchar);
                }
                newlist.addAll(temp);
            }
            r=newlist;
        }
        return r;
    }


}