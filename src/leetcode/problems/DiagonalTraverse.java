package leetcode.problems;

import java.util.*;

public class DiagonalTraverse {

    public static String solution(int [][]m){

        LinkedHashMap<Integer, ArrayList<Integer>> hashMap=new LinkedHashMap<>();

        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                int key=i+j;
                if(!hashMap.containsKey(key)){
                    hashMap.put(key,new ArrayList<>(List.of(m[i][j])));
                }
                else{
                    ArrayList<Integer> temp= hashMap.get(key);
                    temp.add(m[i][j]);
                    hashMap.put(key,temp);
                }
            }
        }
//        System.out.println(hashMap);

        int []out=new int[m.length * m[0].length];
        int idx=0;

        for(Map.Entry<Integer, ArrayList<Integer>> entry:hashMap.entrySet()){
            ArrayList<Integer> arrayList= entry.getValue();
            if(entry.getKey()%2==0){
                for(int i=arrayList.size()-1;i>=0;i--){
                    out[idx++]= arrayList.get(i);
                }
            }
            else{
                for(Integer i: arrayList){
                    out[idx++]=i;
                }
            }
            arrayList.clear();
        }

//        System.out.println(hashMap);

        return Arrays.toString(out);
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(solution(new int[][]{{1,2},{3,4}}));
    }
}
