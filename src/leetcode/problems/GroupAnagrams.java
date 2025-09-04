package leetcode.problems;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> solution(String []s){

        Map<String,List<String>> listMap=new HashMap<>();

        for(int i=0;i<s.length;i++){
            char []chars=s[i].toCharArray();
            Arrays.sort(chars);
            String sortedString= new String(chars);
            if(!listMap.containsKey(sortedString)){
                listMap.put(sortedString,new ArrayList<>());
            }
            List<String > tempList=listMap.get(sortedString);
            tempList.add(s[i]);

            listMap.put(sortedString,tempList);

        }
        List<List<String>> list=new ArrayList<>();

       for(Map.Entry<String,List<String>> entry:listMap.entrySet()){
           list.add(entry.getValue());
       }

        return list;

    };
    {
//        List<List<String>> list=new ArrayList<>();
//        for(int i=0;i<s.length;i++){
//            for(int j=i+1;j<s.length;j++){
//                if(solution(s[i],s[j])){
//                    List<String> list1 =new ArrayList<>(List.of(s[i],s[j]));
//                    list.add(list1);
//                }
//            }
//        }
//        return list;
    }

//    static boolean solution(String s1,String s2){
//        int []sOneMap=new int[26];
//
//        for(int i=0;i<s1.length();i++){
//            sOneMap[s1.charAt(i)-'a']++;
//        }
//
//        int []sTwoMap=new int[26];
//
//        for(int i=0;i<s2.length();i++){
//            sTwoMap[s2.charAt(i)-'a']++;
//        }
//
//        return Arrays.equals(sTwoMap,sOneMap);
//    }


    public static void main(String[] args) {
        System.out.println(solution(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(solution(new String[]{"a"}));
        System.out.println(solution(new String[]{""}));
    }
}
