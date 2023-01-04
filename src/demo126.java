import java.util.*;

public class demo126 {
    //单词接龙 II

    //暴力解 超出时间限制
    static Map<String, Set<String>> keymap=new HashMap<>();
    static List<String> path=new ArrayList<>();
    static List<List<String>> ret=new ArrayList<>();
    static int N=0;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        N=wordList.size();
        wordList.add(beginWord);
        for(String s:wordList){
            for(String t:wordList){
                if(!s.equals(t)&&isNear(s,t)){
                    Set<String> se=keymap.getOrDefault(s,new HashSet<>());
                    se.add(t);
                    keymap.put(s,se);
                }
            }
        }
        wordList.remove(beginWord);
        path.add(beginWord);
        dfs(beginWord,endWord,wordList);
        //倒序删除list
        for(int i=ret.size()-1;i>=0;i--){
            if (ret.get(i).size()>N+1){
                ret.remove(i);
            }
        }
        return ret;
    }
    public static void dfs(String beginWord, String endWord, List<String> wordList, Set<String> set){
        if(path.size()>N)return;
        if(keymap.getOrDefault(beginWord,new HashSet<>()).contains(endWord)){
            path.add(endWord);
            ret.add(new ArrayList<>(path));
            path.remove(endWord);
            N=path.size();
            return;
        }
        for(String s:keymap.getOrDefault(beginWord,new HashSet<>())){
            if (!path.contains(s)) {
                path.add(s);
                dfs(s,endWord,wordList,set);
                path.remove(s);
            }
        }
    }
    //仅有单个字母不同
    public static boolean isNear(String s1,String s2){
        int c=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                c++;
            }
        }
        if(c!=1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        List<String> wordList= new ArrayList<String>(Arrays.asList(new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim"}));
        System.out.println(" = " + findLadders("cet","ism",wordList));
    }
}