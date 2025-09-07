package leetcode;

import java.util.Arrays;

public class MaxValueArray {

    public static int solution(int []a){

        return Arrays.stream(a)
                .max().getAsInt();
    }

    public static void main(String[] args) {
        int []a=new int[11];
        for(int i=0;i<=10;i++){
             a[i]= (int) (Math.random()*100);
        }

        System.out.println(Arrays.toString(a));

        System.out.println(solution(a));
    }
}
