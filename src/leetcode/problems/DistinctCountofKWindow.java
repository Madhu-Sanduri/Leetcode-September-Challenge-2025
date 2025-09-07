package leetcode.problems;

import java.util.*;
import java.util.List;

public class DistinctCountofKWindow {

    public static ArrayList<Integer> solution(ArrayList<Integer> arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;
        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<k;i++){

            if(map.containsKey(arr.get(i))){
                map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
            }
            else map.put(arr.get(i),1);
        }
        max= map.size();
        list.add(map.size());

        for(int i=k;i<arr.size();i++){

            map.put(arr.get(i-k),map.getOrDefault(arr.get(i-k),0)-1);
            if(map.get(arr.get(i-k))==0){
                map.remove(arr.get(i-k));
            }

            if(map.containsKey(arr.get(i))){
                map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
            }
            map.put(arr.get(i),1);
            list.add(map.size());

            // max=Math.max(max,map.size());
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>(List.of(1, 2, 1, 3, 4, 2, 3 ));
        System.out.println(solution(list,3)); // 2, 3, 3, 3, 3
    }
}
