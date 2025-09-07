package leetcode.problems;

import java.util.Arrays;

public class CountingSubstring {

    public static int solution(String s){

        int []map=new int[3];
//        int size=0;
//        for(int i=0;i<s.length();i++){
//            if(map[0]>0 && map[1]>0 && map[2]>0){
//                size=i;
//                break;
//            }
//            else{
//                map[s.charAt(i)-'a']++;
//            }
//        }
//
//        int count=0;
//         count+= (s.length()-size)+1;
//
//        for(int i=size;i<s.length();i++){
//            map[s.charAt(i-size)-'a']--;
//            map[s.charAt(i)-'a']++;
//            if(map[0]>0 && map[1]>0 && map[2]>0){
//                count+=s.length()-i;
//            }
//
//        }
//        System.out.println(size);

//        System.out.println(Arrays.toString(map));
//        return count;
        int len=s.length();
        int out=0;
        int left=0;

        for(int i=0;i<len;i++){
            map[s.charAt(i)-'a']++;
            while (map[0]>0 && map[1]>0 && map[2]>0){
                out+=(len-i);
                map[s.charAt(left)-'a']--;
                left++;
            }
        }
        return out;
    }


    public static void main(String[] args) {
        System.out.println(solution("abc"));
        System.out.println(solution("abcabc"));
        System.out.println(solution("aaacb"));
        System.out.println(solution("cabbcbc"));
        System.out.println(solution("ababbbc"));
    }
}
