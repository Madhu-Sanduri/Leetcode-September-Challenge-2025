package leetcode.problems;

import java.util.*;

public class RemovingAnagrams {

    public static List<String> solution(String []words){

//        HashMap<String, PriorityQueue<Integer>> priorityQueueHashMap=new HashMap<>();
//
//        for(int i=0;i<words.length;i++){
//            char [] chars= words[i].toCharArray();
//            Arrays.sort(chars);
//            String sortedString=new String(chars);
//
//            if(!priorityQueueHashMap.containsKey(sortedString)){
//                priorityQueueHashMap.put(sortedString,new PriorityQueue<>());
//            }
//
//            priorityQueueHashMap.get(sortedString).offer(i);
//
//        }
//        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
//        List<String> list= new ArrayList<>();
//
//        for(Map.Entry<String,PriorityQueue<Integer>> priorityQueueEntry: priorityQueueHashMap.entrySet()){
//            priorityQueue.offer(priorityQueueEntry.getValue().poll());
//        }
//        while (!priorityQueue.isEmpty()){
//            list.add(words[priorityQueue.poll()]);
//        }
//        return list;

        String s=words[0];
        int []currentFreq = mapping(s);
        List<String> list=new ArrayList<>();
        for(int i=1;i<words.length;i++){

            int []iteration=mapping(words[i]);

            if(Arrays.equals(iteration,currentFreq)) continue;
            else {
                list.add(s);
                s=words[i];
                currentFreq=mapping(s);
            }
        }
        list.add(s);
        return list;
    }

    static int[] mapping(String s){

        int []map=new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }

        return map;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abba","baba","bbaa","cd","cd"}));
        System.out.println(solution(new String[]{"a","b","c","d","e"}));
    }
}
