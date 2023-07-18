import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo18 {
    //四数之和 中等 排序双指针
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> r=new ArrayList();
        //Map<String,Integer> map=new HashMap<String,Integer>();
        Arrays.sort(nums);
        int a=0,b=1,c=2,d=3,leng=nums.length;
        String key="";
        a=0;
        while(a<leng-3){
            if((long)nums[a]+nums[a+1]+nums[a+2]+nums[a+3]>target){
                break;
            }
            if((long)nums[leng-4]+nums[leng-3]+nums[leng-2]+nums[leng-1]<target){
                break;
            }
            for(b=a+1;b<leng-2;){
                if((long)nums[a]+nums[b]+nums[b+1]+nums[b+2]>target){
                    break;
                }
                if((long)nums[a]+nums[leng-3]+nums[leng-2]+nums[leng-1]<target){
                    break;
                }
                c=b+1;d=leng-1;
                while(d>c){
                    int an=nums[a]+nums[b]+nums[c]+nums[d];
                    //if(a<b&&b<c&&c<d){
                    key=String.valueOf(nums[a])+String.valueOf(nums[b])+String.valueOf(nums[c])+String.valueOf(nums[d]);
                    //if(!map.containsKey(key)){

                    //map.put(key,an);
                    if(target==an){
                        r.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                    }
                    //}

                    if(an>target){
                        while(d>c&&nums[d--]==nums[d]){};
                    }
                    if(an<target){
                        while(c<leng-1&&nums[c++]==nums[c]){};
                    }
                    if(an==target){
                        while(c<leng-1&&nums[c++]==nums[c]){};
                        while(d>c&&nums[d--]==nums[b]){};
                    }
                }
                //}
                while(b<leng-2&&nums[b++]==nums[b]){};
            }
            while(a<leng-3&&nums[a++]==nums[a]){};
        };


        return r;
    }


    //排序多指针 一次只移动一个指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int a=0,b,c,d,n=nums.length;
        if(n<3){
            return ret;
        }
        while(a<n-3){
            if((long)nums[a]+nums[a+1]+nums[a+2]+nums[a+3]>target){
                break;
            }
            b=a+1;
            while(b<n-2){
                c=b+1;
                d=n-1;
                while(c<d){
                    int t=nums[a]+nums[b]+nums[c]+nums[d];
                    if(t==target){
                        ret.add(Arrays.asList(new Integer[]{nums[a],nums[b],nums[c],nums[d]}));
                        try {while(nums[c]==nums[++c]){}} catch (Exception e) {}
                        try {while(nums[d]==nums[--d]){}} catch (Exception e) {}
                    }else if(t<target){
                        try {while(nums[c]==nums[++c]){}} catch (Exception e) {}
                    }else{
                        try {while(nums[d]==nums[--d]){}} catch (Exception e) {}
                    }
                }
                try {while(nums[b]==nums[++b]){}} catch (Exception e) {}
            }
            try {while(nums[a]==nums[++a]){}} catch (Exception e) {}
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}