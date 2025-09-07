package leetcode.problems;

import java.util.*;

public class MaxValueWindow {

    public static String solution(int []nums,int k){
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // store indices

        for(int i=0;i<k;i++){
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements (they won’t be max)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        int idx=0;

        res[idx++]=nums[dq.peekFirst()];

        for (int i = k; i < n; i++) {
            // remove indices out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // remove smaller elements (they won’t be max)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            res[idx++]=nums[dq.peekFirst()];
            // record max when window size >= k

        }
        return Arrays.toString(res);
    }

//    static int maxValue(List<Integer> list){
//
//        return list.stream()
//                .max(Comparator.comparingInt(x ->x))
//                .get();
//
//    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3));
        System.out.println(solution(new int[]{1, 3, -1, -3, 5, 3, 6, 7},3));
    }
}
