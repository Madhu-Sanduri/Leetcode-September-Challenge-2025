package leetcode.problems;

import java.util.HashSet;

public class HappyNumber {

    public static boolean solution(int num){
        HashSet<Integer> hashSet=new HashSet<>();
        int sum=0;

        while (true){
            if(num==0){
                if(sum==1) return true;
                num=sum;
                sum=0;
                if(hashSet.contains(num)) return false;
                hashSet.add(num);
            }
            int rem=num%10;
            sum+= (rem*rem);
            num/=10;
        }
//        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(18));
        System.out.println(solution(11));
        System.out.println(solution(19));
        System.out.println(solution(2));
    }
}
