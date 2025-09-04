package leetcode.problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ExpressiveWords {

    public static int solution(String s,String []words){

        int []map = new int[26];

        mapping(map,s);


        int []temp=new int[26];
        int count=0;
        for(int i=0;i<words.length;i++){

            mapping(temp,words[i]);

            boolean flag=false;

            for(char c:s.toCharArray()){
                if(temp[c-'a']==map[c-'a']) continue;
                else if(map[c-'a']<3){
                    flag=true;
                    break;
                }

            }
            if(!flag){
                count++;
            }
            Arrays.fill(temp,0);

        }

        return count;

    }

    static void mapping(int []a,String s){
        for(char c:s.toCharArray()){
            a[c-'a']++;
        }
    }


    public static void main(String[] args) {
        System.out.println(solution("abcd",new String[]{"abc"}));
        System.out.println(solution("aaa",new String[]{"aaaa"}));
        System.out.println(solution("dddiiiinnssssssoooo",new String[]{"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}));
        System.out.println(solution("heeellooo",new String[]{"hello", "hi", "helo"}));
        System.out.println(solution("zzzzzyyyyy",new String[]{"zzyy","zy","zyy"}));
    }
}
