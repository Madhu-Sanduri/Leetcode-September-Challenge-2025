package leetcode.problems;

import java.math.BigInteger;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveKDigits {

    public static String solution(String s,int k){
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){

            while (!stack.isEmpty() && (stack.peek()-'0')>= (s.charAt(i)-'0') && k>0){
                stack.pop();
                k--;
            }
            stack.push(s.charAt(i));
        }

        while (k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        if(stack.isEmpty()) return "0";

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<stack.size();i++){

            if(stack.get(i)=='0' && sb.isEmpty()) continue;
            else sb.append(stack.get(i));
        }
        if(sb.length()==0) return "0";
        return sb.toString();

    }


    public static void main(String[] args) {
        System.out.println(solution("1000000",1));
        System.out.println(solution("1234567",1));
        System.out.println(solution("52374333400072837283091820",6));
        System.out.println(solution("1432219",3));
        System.out.println(solution("10200",1));
    }
}
