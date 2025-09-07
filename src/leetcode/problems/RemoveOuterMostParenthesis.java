package leetcode.problems;

import java.util.Stack;

public class RemoveOuterMostParenthesis {
    public static String solution(String s){

//        Stack<Character> stack =new Stack<>();
        String out="";
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)=='('){
//                stack.push(s.charAt(i));
//                sb.append(s.charAt(i));
//            }
//            else {
//                sb.append(")");
//                stack.pop();
//            }
//
//            if(stack.isEmpty()){
//                if(sb.length()>2){
//                    out+= sb.substring(1,sb.length()-1);
//                }
//                sb.delete(0,sb.length());
//            }
//            else if(stack.isEmpty()){
//                out+="";
//                sb.delete(0,sb.length());
//            }
//        }
        int open=0;
        int startIdx=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open++;
            else open--;

            if(open==0){
                if(i-startIdx>2){
                    out+=s.substring(startIdx+1,i);
                }
                startIdx=i+1;
            }
        }

        return out;

    }

    public static void main(String[] args) {
        System.out.println(solution("(()())(())"));
        System.out.println(solution("()()"));
        System.out.println(solution("(()())(())(()(()))"));
    }
}
