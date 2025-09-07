package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseWords {

    public static String solution(String s){
//        s=s.trim();
//        StringBuilder stringBuilder=new StringBuilder();
//
//        String out="";
//        for(int i=s.length()-1;i>=0;i--){
//            if(s.charAt(i)!= ' '){
//                stringBuilder.append(s.charAt(i));
//            }
//            else if(!stringBuilder.isEmpty()){
//                out= out+ stringBuilder.reverse().toString();
//                out+=" ";
//                stringBuilder.delete(0,stringBuilder.length());
//            }
//        }
////        out.indexOf()
//        out+=stringBuilder.reverse().toString();
//        return out;

        return Arrays.stream(s.trim().split("\\s+"))
                .filter(word  -> !word.isEmpty())
                .collect(Collectors.collectingAndThen(
                        Collectors.toList()

                        ,list -> {
                            Collections.reverse(list);
                            return String.join(" ",list);
                        }
                ));

    }

    public static void main(String[] args) {
        System.out.println(solution("a good   example"));
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello world  "));
    }
}
