package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortFreqByCharacters {

    public static String solution(String s){

        HashMap<Character,Integer> hashMap=new HashMap<>();

        for(char c:s.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        List<Character> list=new ArrayList<>(hashMap.keySet()); //this line

        list.sort((a,b) -> hashMap.get(b) - hashMap.get(a)); //this line

        StringBuilder out=new StringBuilder();

        for(Character c:list){
            int charCount= hashMap.get(c);
            while (charCount>0){
                out.append(c);
                charCount--;
            }
        }

//        System.out.println(list);
//        System.out.println(hashMap);

        return out.toString();

    }

    public static void main(String[] args) {
        System.out.println(solution("tree"));
        System.out.println(solution("cccaaa"));
        System.out.println(solution("Aabb"));
    }
}
